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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class PMDReader extends Reader {
	
	public TestResults parse( File f ) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// Prevent XXE
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource( new FileInputStream(f) );
		Document doc = docBuilder.parse(is);
		
		TestResults tr = new TestResults( "PMD" ,false,TestResults.ToolType.SAST);
		
		// If the filename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.xml), set the compute time on the scorecard.
		tr.setTime(f);

		Node root = doc.getDocumentElement();
		String version = getAttributeValue( "version", root );
        tr.setToolVersion( version );
		
		NodeList nl = root.getChildNodes();
		for ( int i = 0; i < nl.getLength(); i++ ) {
			Node n = nl.item( i );
			if ( n.getNodeName().equals( "file")) {
			    NodeList vs = n.getChildNodes();
			    for ( int j = 0; j < vs.getLength(); j++ ) {
			        if ( n.getNodeName().equals( "violation" ) ) {
		                TestCaseResult tcr = parsePMDItem( n );
		                if ( tcr != null ) {
		                    tr.put( tcr );
		                }
			        }
			    }
			}
		}
		
		return tr;
	}
	
	private TestCaseResult parsePMDItem(Node n) {
		NamedNodeMap attrs = n.getAttributes();
        String test = attrs.getNamedItem( "class" ).getNodeValue();
        String rule = attrs.getNamedItem( "rule" ).getNodeValue();
		
		if ( test.startsWith( BenchmarkScore.BENCHMARKTESTNAME ) ) {
	        TestCaseResult tcr = new TestCaseResult();
	        
			String testNumber = test.substring( BenchmarkScore.BENCHMARKTESTNAME.length() );
			tcr.setNumber( Integer.parseInt( testNumber ) );
	        tcr.setCWE( figureCWE( tcr, rule ) );
            
	        tcr.setCategory( rule );
	        tcr.setEvidence( rule );
	        return tcr;
		}
					
		return null;
	}
	
	
	private static int figureCWE( TestCaseResult tcr, String rule) {
		switch( rule ) {
		case "??1" : 	return 614;  // insecure cookie use
		case "??2" : 	return 330;  // weak random
		case "??3" : 	return 90;   // ldap injection
		case "??4" : 	return 22;   // path traversal
		case "??5" : 	return 22;   // path traversal
		case "??6" : 	return 327;	 // weak encryption - cipher with no integrity
		case "??7" : 	return 327;  // padding oracle -- FIXME: probably wrong
		case "??8" : 	return 643;  // xpath injection
		case "??9" : 	return 328;  // weak hash
		case "??10" : 	return 78;   // command injection
		case "??11" : 	return 327;  // weak encryption DES
		case "??12" :	return 79;   // xss
		
		default : System.out.println( "Unknown category: " + rule );
		}

		return 0;
		
	}

}
