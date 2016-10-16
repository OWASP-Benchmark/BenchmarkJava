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

import java.util.List;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Node;

public class AcunetixReader extends Reader {
	
	public TestResults parse( Node root ) throws Exception {
        TestResults tr = new TestResults( "Acunetix WVS", true, TestResults.ToolType.DAST);
        Node scan = getNamedChild( "Scan", root );

//        <ScanGroup ExportedOn="11/9/2015, 21:42">
//        <Scan>
//         <Name><![CDATA[Scan Thread 1 ( https://172.16.11.1:8443/benchmark/ )]]></Name>
//         <ShortName><![CDATA[Scan Thread 1]]></ShortName>
//         <StartURL><![CDATA[https://172.16.11.1:8443/benchmark/]]></StartURL>
//         <StartTime><![CDATA[11/9/2015, 14:50:33]]></StartTime>
//         <FinishTime><![CDATA[11/9/2015, 15:31:02]]></FinishTime>
//         <ScanTime><![CDATA[40 minutes, 29 seconds]]></ScanTime>

        
//        </ReportItem>
//      </ReportItems>
//    </Scan>
//  </ScanGroup>
        
        String duration = getNamedChild("ScanTime", scan ).getTextContent();
        tr.setTime( duration );
        
        Node issues = getNamedChild( "ReportItems", scan );
        List<Node> issueList = getNamedChildren( "ReportItem", issues );
        
        for ( Node issue : issueList ) {
            try {
                TestCaseResult tcr = parseAcunetixItem(issue);
                if (tcr != null ) {
                    tr.put(tcr);
                    // System.out.println( tcr.getNumber() + ", " + tcr.getCWE() + ", " + tcr.getEvidence() );
                }
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
        return tr;
	}
	
//    <ReportItem id="0" color="orange">
//    <Name><![CDATA[HTML form without CSRF protection]]></Name>
//    <Details><![CDATA[Form name: <font color="navy">&lt;empty&gt;</font><br/>Form action: <font color="navy">https://172.16.11.1:8443/benchmark/BenchmarkTest01925</font><br/>Form method: <font color="navy">POST</font><br/><br/>Form inputs:<br/><ul><li>vectorArea [TextArea]</li><li>answer [Text]</li><li>vector [Text]</li></ul>]]></Details>
//    <Affects><![CDATA[/benchmark/BenchmarkTest01925.html]]></Affects>
//    <IsFalsePositive><![CDATA[False]]></IsFalsePositive>
//    <Severity><![CDATA[medium]]></Severity>
//    <CWE id="352"><![CDATA[CWE-352]]></CWE>

	private TestCaseResult parseAcunetixItem( Node flaw ) throws Exception {
        TestCaseResult tcr = new TestCaseResult();

        String cat = getNamedChild("Name", flaw).getTextContent();
        tcr.setCategory( cat );
        tcr.setEvidence( cat );

        Node vulnId = getNamedChild("CWE", flaw);
        if ( vulnId != null ) {
            String cweNum = getAttributeValue( "id", vulnId );
            int cwe = cweLookup( cweNum );
            tcr.setCWE( cwe  );
        }
        
//        String conf = getNamedChild( "Severity", flaw ).getTextContent();
//        tcr.setConfidence( Integer.parseInt( conf ) );
        
        String uri = getNamedChild( "Affects", flaw ).getTextContent();
        int spaceIdx = uri.indexOf( ' ' );
        if ( spaceIdx != -1 ) {
            uri = uri.substring( 0, spaceIdx );
        }
        String testfile = uri.substring( uri.lastIndexOf('/') +1 );
        if ( testfile.contains("?") ) {
            testfile = testfile.substring(0, testfile.indexOf( "?" ) );
        }
        
        if ( testfile.startsWith( BenchmarkScore.BENCHMARKTESTNAME ) ) {
            String testno = testfile.substring(BenchmarkScore.BENCHMARKTESTNAME.length());
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
