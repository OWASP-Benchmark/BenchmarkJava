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
 * @created 2020
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
import org.xml.sax.InputSource;

public class WapitiReader extends Reader {

    public TestResults parse(File f) throws Exception {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// Prevent XXE
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        InputSource is = new InputSource(new FileInputStream(f));
        Document doc = docBuilder.parse(is);

        TestResults tr = new TestResults( "Wapiti", false, TestResults.ToolType.DAST );

		// Get the version of Wapiti out of the generatorVersion <info> element.
        Node root = doc.getDocumentElement();
        Node reportInfo = getNamedChild( "report_infos", root );
        List<Node> infoList = getNamedChildren( "info", reportInfo );
        for ( Node info : infoList ) {
        	String name = getAttributeValue( "name", info );
        	if ("generatorVersion".equals(name)) {
        		String fullString = info.getTextContent(); // e.g., Wapiti 3.0.3
        		String version = fullString.substring( fullString.lastIndexOf(' ') +1);
        		tr.setToolVersion( version );
        		break; // Exit for loop when version is found
        	}
        }

//        String time = getAttributeValue("ScanTime", root);
//        tr.setTime( time );

        // Now parse each <vulnerability> in the set of <vulnerabilities>
        Node vulns = getNamedChild( "vulnerabilities", root );
        List<Node> vulnList = getNamedChildren( "vulnerability", vulns );

        for ( Node vuln : vulnList ) {
            // Each vulnerability categority is a 'volunerability' node
            // And then there are <entries> within which each '<entry> is an instance of that vuln type

            // First, get the CWE for all these entries
            int cwe = getCWE(vuln);

            // Then process each entry
            Node entriesNode = getNamedChild( "entries", vuln );
            List<Node> entries = getNamedChildren( "entry", entriesNode );
            for ( Node entry : entries ) {
                String path = getNamedChild( "path", entry ).getTextContent();
                if (path.contains(BenchmarkScore.TESTCASENAME)) {
                    String testCaseNum = path.substring(path.length() - BenchmarkScore.TESTIDLENGTH);
                    TestCaseResult tcr = new TestCaseResult();
                    tcr.setCWE(cwe);
                    tcr.setCategory( getAttributeValue( "name", vuln ) );
                    tcr.setEvidence( getNamedChild( "curl_command", entry ).getTextContent() );
                	try {
                    	tcr.setNumber( Integer.parseInt( testCaseNum ) );
                    	tr.put(tcr);
                  	} catch ( NumberFormatException e ) {
                  		System.out.println("ERROR: Couldn't parse test case number from: " + path);
                    	e.printStackTrace();
                  	}
                }
            }
        }
        return tr;
    }

    // Parse the CWE # out of the references included with the vuln
    private int getCWE(Node vuln) {
    	int cwe = -1;
        Node refs = getNamedChild( "references", vuln );
        List<Node> references = getNamedChildren( "reference", refs );
        for ( Node ref : references ) {
            String title = getNamedChild( "title", ref ).getTextContent();
        	if (title.startsWith("CWE-")) {
        		String cweNum = title.substring("CWE-".length(), title.indexOf(":"));
        		try {
                	cwe = Integer.parseInt( cweNum );
                	break;
              	} catch ( NumberFormatException e ) {
                	e.printStackTrace();
                	break;
              	}
        	}
        }
        return cwe;
    }

/*  // Don't need any CWE translations currently.
    private int translate(String cwe) {
        switch( cwe ) {
            case "File Handling"        :   return 22;   // Path Traversal
            case "Commands execution"   :   return 78;   // Command Injection
            case "CRLF Injection"       :   return 9999; // don't care
            case "Cross Site Scripting" :   return 79;
            case "SQL Injection"        :   return 89;
            case "Blind SQL Injection"  :   return 89;
        }
        return -1;
    }
*/
}
