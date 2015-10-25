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

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class FortifyReader extends Reader {

	public TestResults parse( File f ) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// Prevent XXE
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource( new FileInputStream(f) );
		Document doc = docBuilder.parse(is);
		
		TestResults tr = new TestResults("HP Fortify", true, TestResults.ToolType.SAST);
		
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
              
		// FIXME: in the FPR there is audit.xml that has a different version number in it
        
        // get engine build version
        Node eData = getNamedChild("EngineData", root );
        String version = getNamedChild( "EngineVersion", eData ).getTextContent();
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
	
	private TestCaseResult parseFortifyVulnerability(Node vuln) {
		TestCaseResult tcr = new TestCaseResult();
		
        Node ci = getNamedNode("ClassInfo", vuln.getChildNodes() );
        Node type = getNamedNode( "Type", ci.getChildNodes() );
        String vulnType = type.getTextContent();
        tcr.setCategory( vulnType );
        
        Node ii = getNamedNode("InstanceInfo", vuln.getChildNodes() );
        Node cn = getNamedNode( "Confidence", ii.getChildNodes() );
        int conf = Integer.parseInt(cn.getTextContent().substring(0,1));
        tcr.setConfidence( conf );
        
		Node subtype = getNamedNode( "Subtype", ci.getChildNodes() );
		String vulnSubType = "";
		if ( subtype != null ) {
			vulnSubType = subtype.getTextContent();
		}
		tcr.setEvidence( vulnType + "::" + vulnSubType );
		
		tcr.setCWE( cweLookup( vulnType, vulnSubType ) );
		
		Node ai = getNamedNode( "AnalysisInfo", vuln.getChildNodes() );
		Node un = getNamedNode( "Unified", ai.getChildNodes() );
		Node co = getNamedNode( "Context", un.getChildNodes() );
		Node fu = getNamedNode( "Function", co.getChildNodes() );
		String tc = getAttributeValue( "enclosingClass", fu );
		if ( tc != null && tc.startsWith( "BenchmarkTest" ) ) {
			tc = tc.substring( "BenchmarkTest".length() );
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

	private int cweLookup(String vtype, String subtype) {
		switch( vtype ) {
		
		//case "Build Misconfiguration" : return 00;
		case "Command Injection" : return 78;
		case "Cookie Security" : return 614;
		case "Cross-Site Scripting" : return 79;
		//case "Dead Code" : return 00;
		//case "Denial of Service" : return 00;
		case "Header Manipulation" : return 113;
		case "Insecure Randomness" : return 330;
		//case "J2EE Bad Practices" : return 00;
		case "LDAP Injection" : return 90;
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
		case "Weak Encryption" : return 327;
		case "XPath Injection" : return 643;
		
		}
		return 0;
	}
}
