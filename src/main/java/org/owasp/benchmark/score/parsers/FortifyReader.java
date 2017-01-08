/**
* OWASP Benchmark Project
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class FortifyReader extends Reader {

	public static TestResults parse( File f ) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// Prevent XXE
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource( new FileInputStream(f) );
		Document doc = docBuilder.parse(is);
		
		TestResults tr = new TestResults("Fortify", true, TestResults.ToolType.SAST);
		
        // If the filename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.fpr), 
		// set the compute time on the score card.
        tr.setFortifyTime(f);
        
        // FIXME: Is there any way to get the time from Fortify itself?

        Node root = doc.getDocumentElement();
				
        // try to figure out if this is Fortify On-Demand. Note: I believe this only works for
        // Older versions of Fortify like 4.1. BenchmarkScore contains a test for more recent
        // versions of Fortify, like 4.3
        Node build = getNamedChild("Build", root );
        String source = getNamedChild( "SourceBasePath", build ).getTextContent();
        if ( source.contains("ronq") ) {
        	tr.setTool( tr.getTool() + "-OnDemand" );
        }
        
        // get engine build version and rulepack version
        Node eData = getNamedChild("EngineData", root );
        String version = getNamedChild( "EngineVersion", eData ).getTextContent();
        Node rps = getNamedChild("RulePacks", eData );
        Node rp = getNamedChild("RulePack", rps );
        version += "-rp" + getNamedChild( "Version", rp ).getTextContent();
        tr.setToolVersion( version );

        NodeList rootList = root.getChildNodes();
        List<Node> vulnList = getNamedNodes( "Vulnerabilities", rootList );

        List<Node> vulns = getNamedChildren( "Vulnerability", vulnList );		
		
//        int i = 0;
        for ( Node flaw : vulns ) {
            TestCaseResult tcr = parseFortifyVulnerability(flaw);
            if (tcr != null ) {
                tr.put(tcr);
            }
//            if (++i % 1000 == 0) System.out.println("Processed " + i + " vulns.");
        }
        
		return tr;	
	}
	
	private static TestCaseResult parseFortifyVulnerability(Node vuln) {
		TestCaseResult tcr = new TestCaseResult();
		
        Node ci = getNamedNode("ClassInfo", vuln.getChildNodes() );
        Node type = getNamedNode( "Type", ci.getChildNodes() );
        String vulnType = type.getTextContent();
        tcr.setCategory( vulnType );
        
        // We grab this as sometimes we need to dig into this to verify the details of an issue
		Node ai = getNamedNode( "AnalysisInfo", vuln.getChildNodes() );
		Node un = getNamedNode( "Unified", ai.getChildNodes() );
        
		Node subtype = getNamedNode( "Subtype", ci.getChildNodes() );
		String vulnSubType = "";
		if ( subtype != null ) {
			vulnSubType = subtype.getTextContent();
		}
		tcr.setEvidence( vulnType + "::" + vulnSubType );
		
		tcr.setCWE( cweLookup( vulnType, vulnSubType, un ) );
		
		Node co = getNamedNode( "Context", un.getChildNodes() );
		Node fu = getNamedNode( "Function", co.getChildNodes() );
		String tc = getAttributeValue( "enclosingClass", fu );
		if ( tc != null && tc.startsWith( BenchmarkScore.BENCHMARKTESTNAME ) ) {
			tc = tc.substring( BenchmarkScore.BENCHMARKTESTNAME.length() );
			int dollar = tc.indexOf( '$' );
			if ( dollar != -1 ) {
				tc = tc.substring( 0, dollar );
			}
			int tn = Integer.parseInt( tc );
			tcr.setNumber( tn );
			return tcr;
		}
		return null;
	}

	private static int cweLookup(String vtype, String subtype, Node unifiedNode) {

		switch ( vtype ) {

			//case "Build Misconfiguration" : return 00;
			case "Command Injection" : return 78;

			case "Cookie Security" : {
				// Verify its the exact type we are looking for (e.g., not HttpOnly finding)
				if ( "Cookie not Sent Over SSL".equals( subtype )) return 614;
			}

			case "Cross-Site Scripting" : {
				switch ( subtype ) {
					// Not a type of XSS weakness we are testing for. Causes False Positives for Fortify.
					case "Poor Validation" : return 83;
				}
				return 79;
			}

			//case "Dead Code" : return 00;
			//case "Denial of Service" : return 00;
			case "Header Manipulation" : return 113;
			case "Insecure Randomness" : return 330;
			//case "J2EE Bad Practices" : return 00;

			case "LDAP Injection" : return 90;

			// Fortify reports weak randomness issues under Obsolete by ESAPI, rather than in the
			// Insecure Randomness category if it thinks you are using ESAPI. However, its behavior isn't
			// consistent. For Benchmark, we've seen it report it both ways. As such, we are adding this
			// other way to determine if Fortify is reporting weak randomness. Given that Fortify reports 
			// many different types of issues under this category, we actually look to see the name of the
			// method they are flagging. If its 'random()', then we count it as reported.
			case "Obsolete" : {
				if ("Deprecated by ESAPI".equals(subtype)) {
					Node rd = getNamedNode( "ReplacementDefinitions", unifiedNode.getChildNodes() );
					Node def = getNamedNode( "Def", "PrimaryCall.name", rd.getChildNodes() );
					String methodName = getAttributeValue( "value", def );

					// First check grants credit for flagging uses of: java.lang.Math.random()
					if ( "random()".equals(methodName) ||

					// Following grants credit for flagging use of any method that generates random #'s using the 
					// java.util.Random or java.security.SecureRandom classes. e.g., nextWHATEVER().
					   (methodName != null && methodName.startsWith("next"))) {
					  return 330;
					}
				}
			}

			//case "Missing Check against Null" : return 00;
			//case "Null Dereference" : return 00;
			case "Password Management" : return 00;
			case "Path Manipulation" : return 22;

			//case "Poor Error Handling" : return 00;
			//case "Poor Logging Practice" : return 00;
			//case "Poor Style" : return 00;
			//case "Resource Injection" : return 00;

			case "SQL Injection" : return 89;
			//case "System Information Leak" : return 00;
			case "Trust Boundary Violation" : return 501;
			//case "Unreleased Resource" : return 00;
			//case "Unsafe Reflection" : return 00;

			case "Weak Cryptographic Hash" : return 328;

			case "Weak Encryption" :
			{
				switch ( subtype ) {
					// These 2 are not types of Encryption weakness we are testing for. Cause False Positives for Fortify.
					case "Missing Required Step" : return 325;
					case "Inadequate RSA Padding" : return 780;
					//TODO: Assuming this Fortify rule is valid, we might need to fix Benchmark itself to eliminate
					// unintended vulns.
					case "Insecure Mode of Operation" : return 0; // Disable so it doesn't count against Fortify.
				}
				return 327;
			}

			case "XPath Injection" : return 643;

			} // end switch

		return 0;
	}
}
