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
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Document;
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

		TestResults tr = new TestResults( "PMD", false, TestResults.ToolType.SAST );

		// If the filename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.xml), set the compute time on the scorecard.
		tr.setTime(f);

		Node root = doc.getDocumentElement();
		String version = getAttributeValue( "version", root );

		NodeList rootList = root.getChildNodes();
        tr.setToolVersion( version );

		List<Node> fileList = getNamedNodes( "file", rootList );
		
		for ( Node file : fileList ) {
            TestCaseResult tcr = parsePMDItem( file );
            if ( tcr != null ) {
                tr.put( tcr );
            }
        }

		return tr;
	}

	private TestCaseResult parsePMDItem(Node fileNode) {

        String filename = fileNode.getAttributes().getNamedItem( "name" ).getNodeValue();

		Node violationNode = getNamedChild( "violation", fileNode );
		String violation = violationNode.getAttributes().getNamedItem( "rule" ).getNodeValue();
		
		String testclass = filename.substring(filename.lastIndexOf("/") + 1 );
		if ( testclass.startsWith( BenchmarkScore.TESTCASENAME ) ) {
	        TestCaseResult tcr = new TestCaseResult();
	        
			String testNumber = testclass.substring( BenchmarkScore.TESTCASENAME.length(),
					BenchmarkScore.TESTCASENAME.length() +  BenchmarkScore.TESTIDLENGTH);
			try {
				tcr.setNumber( Integer.parseInt( testNumber ) );
			} catch (NumberFormatException e) {
				return null; // If we can't parse the test #, its not in a real test case file. e.g.,
							// BenchmarkTesting.java
			}
	        tcr.setCWE( figureCWE( tcr, violation ) );
            
	        tcr.setCategory( violation );
	        tcr.setEvidence( violation );
	        return tcr;
		}

		return null;
	}

	private static int figureCWE( TestCaseResult tcr, String rule ) {
		switch( rule ) {
			case "CollapsibleIfStatements":
			case "EmptyCatchBlock":
			case "UnusedFormalParameter":
			case "UnusedLocalVariable":
			case "UselessParentheses":
							return 0000; // Don't care
			// Don't think PMD reports any of these:
			case "??1" : 	return 614;  // insecure cookie use
			case "??2" : 	return 330;  // weak random
			case "??3" : 	return 90;   // LDAP injection
			case "??4" : 	return 22;   // path traversal
			case "??5" : 	return 22;   // path traversal
			case "??6" : 	return 327;	 // weak encryption
			case "??7" : 	return 643;  // xpath injection
			case "??8" : 	return 328;  // weak hash
			case "??9" : 	return 78;   // command injection
			case "??10" :	return 79;   // XSS

			default : System.out.println( "Unknown category: " + rule );
		}

		return 0;
	}
}
