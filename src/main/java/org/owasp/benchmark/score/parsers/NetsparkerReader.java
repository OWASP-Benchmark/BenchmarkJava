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
* @created 2016
*/

package org.owasp.benchmark.score.parsers;

import java.util.List;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Node;

public class NetsparkerReader extends Reader {
	
	public TestResults parse( Node root ) throws Exception {
        TestResults tr = new TestResults( "Netsparker", true, TestResults.ToolType.DAST);

        Node target = getNamedChild( "target", root );

//        <target>
//            <url>https://localhost:8443/benchmark/</url>
//            <scantime>211116</scantime>
//        </target>

        String duration = getNamedChild("scantime", target ).getTextContent();
        try {
            long millis = Long.parseLong(duration);
            tr.setTime( TestResults.formatTime( millis ) );
        } catch( Exception e ) {
            tr.setTime( duration );
        }
        
//      No version information in XML        
//        String version = getNamedChild("TBD", root ).getTextContent();
//        tr.setToolVersion( version );
        
        List<Node> issueList = getNamedChildren( "vulnerability", root );
        
        for ( Node issue : issueList ) {
            try {
                TestCaseResult tcr = parseNetsparkerIssue(issue);
                if (tcr != null ) {
                    tr.put(tcr);
                    //System.out.println( tcr.getNumber() + ", " + tcr.getCategory() + ", " + tcr.getCWE() + ", " + tcr.getEvidence() );
                }
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
        return tr;
	}
	
//    <vulnerability confirmed="True">
//    <url>https://localhost:8443/benchmark/securecookie-00/BenchmarkTest00087?BenchmarkTest00087=whatever</url>
//    <type>CookieNotMarkedAsSecure</type>
//    <severity>Important</severity>
//    <certainty>100</certainty>
//
//    <extrainformation>
//        <info name="Identified Cookie"><![CDATA[SomeCookie]]></info>
//    </extrainformation>
//
//    <classification>
//        <OWASP2010>A9</OWASP2010>
//        <OWASP2013>A6</OWASP2013>
//        <WASC>15</WASC>
//        <CWE>614</CWE>
//        <CAPEC>102</CAPEC>
//        <PCI2>6.5.4</PCI2>
//        <PCI3>6.5.10</PCI3>
//        <PCI31>6.5.10</PCI31>
//    </classification>
//
//</vulnerability>

	private TestCaseResult parseNetsparkerIssue( Node flaw ) throws Exception {
        TestCaseResult tcr = new TestCaseResult();

        String type = getNamedChild("type", flaw).getTextContent();
        tcr.setCategory( type );

        String severity = getNamedChild( "severity", flaw ).getTextContent();

        String confidence = getNamedChild( "certainty", flaw ).getTextContent();
        tcr.setConfidence( Integer.parseInt(confidence) );
        
        Node extra = getNamedChild("extrainformation", flaw);
        Node info = getNamedChild("info", extra);
        String evidence = getAttributeValue("name", info);
        tcr.setEvidence( severity + "::" + evidence );

//        <severity>Low</severity>
//        <certainty>90</certainty>

        Node classification = getNamedChild("classification", flaw);
        // Note: not all vulnerabilities have CWEs in Netsparker
        if ( classification != null ) {
            Node vulnId = getNamedChild("CWE", classification);
            if ( vulnId != null ) {
                String cweNum = vulnId.getTextContent();
                int cwe = cweLookup( cweNum );
                tcr.setCWE( cwe  );
            }
        }
        
        String uri = getNamedChild( "url", flaw ).getTextContent();
        String testfile = uri.substring( uri.lastIndexOf('/') +1 );
        if ( testfile.contains("?") ) {
            testfile = testfile.substring(0, testfile.indexOf( "?" ) );
        }
        
        if ( testfile.startsWith( BenchmarkScore.TESTCASENAME ) ) {
            String testno = testfile.substring(BenchmarkScore.TESTCASENAME.length());
            if ( testno.endsWith( ".html" ) ) {
                testno = testno.substring(0, testno.length() -5 );
            }
            try {
                tcr.setNumber( Integer.parseInt( testno ) );
                return tcr;
            } catch( NumberFormatException e ) {
                System.out.println( "> Parse error " + testfile + ":: " + testno );
            }
        }
        return null;
    }
	
	private static int cweLookup( String cweNum ) {
	    if ( cweNum == null || cweNum.isEmpty() ) {
	        return 0000;
	    }
	    int cwe = Integer.parseInt( cweNum );
	    switch( cwe ) {
	    case 80 : return 614;   // insecure cookie use
//        case "insecure-cookie"           :  return 614;  // insecure cookie use
//        case "sql-injection"             :  return 89;   // sql injection
//        case "cmd-injection"             :  return 78;   // command injection
//        case "ldap-injection"            :  return 90;   // ldap injection
//        case "header-injection"          :  return 113;  // header injection
//        case "hql-injection"             :  return 0000; // hql injection
//        case "unsafe-readline"           :  return 0000; // unsafe readline
//        case "reflection-injection"      :  return 0000; // reflection injection
//        case "reflected-xss"             :  return 79;   // xss
//        case "xpath-injection"           :  return 643;  // xpath injection
//        case "path-traversal"            :  return 22;   // path traversal
//        case "crypto-bad-mac"            :  return 328;  // weak hash
//        case "crypto-weak-randomness"    :  return 330;  // weak random
//        case "crypto-bad-ciphers"        :  return 327;  // weak encryption
//        case "trust-boundary-violation"  :  return 501;  // trust boundary
//        case "xxe"                       :  return 611;  // xml entity
        }
		return cwe;
	}
}
