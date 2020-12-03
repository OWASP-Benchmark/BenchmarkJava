/**
* OWASP Benchmark Project
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Dave Wichers
* @created 2015
*/

package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class FindbugsReader extends Reader {
	
	// This reader supports both FindBugs and FindSecBugs, since the later is simply a FindBugs plugin.
	
	public TestResults parse( File f ) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// Prevent XXE
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource( new FileInputStream(f) );
		Document doc = docBuilder.parse(is);
		
		TestResults tr = new TestResults( "FindBugs", false,TestResults.ToolType.SAST);
		
		// If the filename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.xml), set the compute time on the scorecard.
		tr.setTime(f);

//		<BugCollection timestamp='1434663265000' analysisTimestamp='1434663273732' sequence='0' release='' version='3.0.1>
        Node root = doc.getDocumentElement();
        String version = getAttributeValue( "version", root );
        tr.setToolVersion( version );
        
        // If the findbugs version is greater than v3.0.x, it is actually SpotBugs
        if (!(version.startsWith("2") | version.startsWith("3.0"))) {        	
            tr.setTool("SpotBugs");
        }

		NodeList nl = root.getChildNodes();
		for ( int i = 0; i < nl.getLength(); i++ ) {
			Node n = nl.item( i );
			if ( n.getNodeName().equals( "BugInstance")) {
				TestCaseResult tcr = parseFindBugsBug( n );
				if ( tcr != null ) {
					tr.put( tcr );
				}
			}
		}
		
		return tr;
	}
	
	private TestCaseResult parseFindBugsBug(Node n) {
		TestCaseResult tcr = new TestCaseResult();
		NamedNodeMap attrs = n.getAttributes();
		if ( attrs.getNamedItem( "category" ).getNodeValue().equals( "SECURITY") ) {
			Node cl = getNamedNode( "Class", n.getChildNodes() );
			String classname = cl.getAttributes().getNamedItem("classname").getNodeValue();
			classname = classname.substring( classname.lastIndexOf('.') + 1);
			if ( classname.startsWith( BenchmarkScore.TESTCASENAME ) ) {
				try {
					String testNumber = classname.substring( BenchmarkScore.TESTCASENAME.length() );
					tcr.setNumber( Integer.parseInt( testNumber ) );
				} catch (Exception e) {
				// System.out.println("Error parsing node: " + n.toString() + " for classname: " + classname);
					return null; // If we can't parse the test #, its not in a real test case file. e.g., BenchmarkTesting.java
				}
			}
			
			Node cwenode = attrs.getNamedItem("cweid");
			Node catnode = attrs.getNamedItem("abbrev");
			tcr.setCWE( figureCWE( tcr, cwenode, catnode ) );
			
			String type = attrs.getNamedItem("type").getNodeValue();
			tcr.setCategory( type );
			
			return tcr;
		}
		return null;
	}
	
	
	private static int figureCWE( TestCaseResult tcr, Node cwenode, Node catnode) {
		String cwe = null;
		if ( cwenode != null ) {
			cwe = cwenode.getNodeValue();
		}
		
		String cat = null;
		if ( catnode != null ) {
			cat = catnode.getNodeValue();
		}
		tcr.setEvidence( "FB:" + cwe + "::" + cat);

		if ( cwe != null ) {
			// FIX path traversal CWEs
			if ( cwe.equals( "23" ) || cwe.equals( "36" ) ) {
				cwe = "22";
			}
			// FSB identify DES/DESede as CWE-326 (Inadequate Encryption Strength) while Benchmark
			// marked it as CWE-327 (Use of a Broken or Risky Cryptographic Algorithm)
			else if ( cwe.equals( "326" ) ) {
				cwe = "327";
			}
			return Integer.parseInt( cwe );
		}

		//This is a fallback mapping for unsupported/old versions of the Find Security Bugs plugin
		//as defined in: findsecbugs-plugin/src/main/resources/metadata/findbugs.xml
		//All important bug patterns have their CWE ID associated in later versions (1.4.3+).
		switch ( cat ) {
			//Cookies
			case "SECIC" : 		return 614;  // insecure cookie use
			case "SECCU" : 		return 00;   // servlet cookie
			case "SECHOC" :		return 00;   // HTTP Only not set on cookie - Information Leak / Disclosure (CWE-200)??

			//Injections
			case "SECSQLIHIB"     : return 564;  // Hibernate Injection, child of SQL Injection
			case "SECSQLIJDO"     : return 89;
			case "SECSQLIJPA"     : return 89;
			case "SECSQLISPRJDBC" : return 89;
			case "SECSQLIJDBC"    : return 89;

			//LDAP injection
			case "SECLDAPI" : 	return 90;   // LDAP injection

			//XPath injection
			case "SECXPI" : 	return 643;  // XPATH injection

			//Command injection
			case "SECCI" : 		return 78;   // command injection

			//Weak random
			case "SECPR" : 		return 330;  // weak random

			//Weak encryption
			case "SECDU" : 		return 327;  // weak encryption DES
			case "CIPINT" : 	return 327;  // weak encryption - cipher with no integrity
			case "PADORA" : 	return 327;  // padding oracle -- FIXME: probably wrong
			case "STAIV" : 		return 329;  // static initialization vector for crypto

			//Weak hash
			case "SECWMD" : 	return 328;  // weak hash

			//Path traversal
			case "SECPTO" : 	return 22;   // path traversal
			case "SECPTI" : 	return 22;   // path traversal

			//XSS
			case "SECXRW" :		return 79;   // XSS
			case "SECXSS1" :	return 79;   // XSS
			case "SECXSS2" :	return 79;   // XSS

			//XXE
			case "SECXXEDOC" :      return 611;  // XXE
			case "SECXXEREAD" :     return 611;  // XXE
			case "SECXXESAX" :      return 611;  // XXE

			//Input sources
			case "SECSP" : 		return 00;   // servlet parameter - not a vuln
			case "SECSH" : 		return 00;   // servlet header - not a vuln
			case "SECSHR" : 	return 00;   // Use of Request Header -- spoofable
			case "SECSSQ" : 	return 00;   // servlet query - not a vuln

			//Technology detection
			case "SECSC" : 		return 00;   // found Spring endpoint - not a vuln
			case "SECJRS" : 	return 00;   // JAX-RS Endpoint

			//Configuration
			case "SECOPFP" :        return 00;   // Overly Permissive File Permissions

			default : System.out.println( "Unknown vuln category for FindBugs: " + cat );
		}

		return 0;
	}
}
