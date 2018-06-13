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
* @created 2016
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

public class CASTAIPReader extends Reader {
	
	public TestResults parse( File f ) throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        // Prevent XXE
        docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        InputSource is = new InputSource( new FileInputStream(f) );
        Document doc = docBuilder.parse(is);

        TestResults tr = new TestResults( "CAST AIP", true, TestResults.ToolType.SAST);
        Node root = doc.getDocumentElement();

//      <?xml version="1.0" encoding="UTF-8"?>
//      <CASTAIP version="8.2.3" timestamp="2017-09-18 11:55:12.312+00">

//      Only start time available in XML, per above. No stop time
//        String duration = getNamedChild("timestamp", root ).getTextContent();
//        try {
//            long millis = Long.parseLong(duration);
//            tr.setTime( TestResults.formatTime( millis ) );
//        } catch( Exception e ) {
//            tr.setTime( duration );
//        }
        
        String version = getAttributeValue("version", root);
        if (version != null) {
        	tr.setToolVersion( version );
        }
        
        List<Node> issueList = getNamedChildren( "file", root );
        
        for ( Node issue : issueList ) {
            try {
                TestCaseResult tcr = parseCASTAIPIssue(issue);
                if (tcr != null ) {
                    tr.put(tcr);
                    // System.out.println( tcr.getNumber() + ", " + tcr.getCategory() + ", " + tcr.getCWE() + ", " + tcr.getEvidence() );
                }
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
        return tr;
	}
	
// Issues look like this (all on one line)    
// <file name="C:\CASTMS\Deploy\OWASPTST\My Package\src\main\java\org\owasp\benchmark\testcode\BenchmarkTest00007.java">
// <violation beginline="39" endline="70" begincolumn="2" endcolumn="3" rule=" " ruleset="Secure Coding - Input Validation"
// fullname="org.owasp.benchmark.testcode.BenchmarkTest00007.doPost" type="Java Method" critical="YES" >
// Avoid OS command injection vulnerabilities ( CWE-78 )</violation></file>

	private TestCaseResult parseCASTAIPIssue( Node flaw ) throws Exception {
        TestCaseResult tcr = new TestCaseResult();

        // Get the violation description and if it doesn't contain a CWE #, then it's not 
        // relevant to Benchmark.
        String violation = getNamedChild("violation", flaw).getTextContent();
        if (!violation.contains("CWE-")) return null;

        // Get CWE #
        violation = violation.substring( violation.indexOf( "CWE-" ) + "CWE-".length() );
        violation = violation.substring( 0, violation.indexOf( ')' ) );
        int cwe = cweLookup( violation );
        tcr.setCWE( cwe  );
        
        // Get Benchmark test case #. If it's not in a Benchmark test case, return null
        String filename = getAttributeValue("name", flaw);
        filename = filename.replaceAll( "\\\\", "/");
        filename = filename.substring( filename.lastIndexOf( '/' ) );
        if ( filename.contains( BenchmarkScore.BENCHMARKTESTNAME ) ) {
            String testNumber = filename.substring( BenchmarkScore.BENCHMARKTESTNAME.length() + 1, filename.length() - 5 );
            try {
                tcr.setNumber( Integer.parseInt( testNumber ) );
                return tcr;
            } catch( NumberFormatException e ) {
                System.out.println( "> Parse error " + filename + ":: " + testNumber );
            }
        }
        return null;
    }

	
	private static int cweLookup( String name ) {
	    if ( name == null || name.isEmpty() ) {
	        return 0000;
	    }
	    switch( name.trim() ) {
          case "614"                       :  return 614;  // insecure cookie use
          case "78"                        :  return 78;   // command injection
          case "79"                        :  return 79;   // xss
          case "89"                        :  return 89;   // sql injection
          case "90"                        :  return 90;   // ldap injection
//        case "header-injection"          :  return 113;  // header injection
//        case "hql-injection"             :  return 0000; // hql injection
//        case "unsafe-readline"           :  return 0000; // unsafe readline
//        case "reflection-injection"      :  return 0000; // reflection injection
//        case "reflected-xss"             :  return 79;   // xss
          case "91"                        :  return 643;  // xpath injection
          case "73"                        :  return 22;   // path traversal - This tool calls this CWE-73 "External Control of File Name or Path"
//        case "crypto-bad-mac"            :  return 328;  // weak hash
//        case "crypto-weak-randomness"    :  return 330;  // weak random
//        case "crypto-bad-ciphers"        :  return 327;  // weak encryption
          case "501"                       :  return 501;  // trust boundary
//        case "xxe"                       :  return 611;  // xml entity
          case "134"                       :  return 134;  // Use of Externally-Controlled Format String - Which really isn't a Java vuln
          case "22"                        :  return 22;
          case "643"                       :  return 643;
          default         : System.out.println("No matching CWE # found in CAST AIP Reader for: 'CWE-" + name +"'");
        }
		return 0000;
	}
}

