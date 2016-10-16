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

public class WebInspectReader extends Reader {
	
	public TestResults parse( Node root ) throws Exception {
        TestResults tr = new TestResults( "HP WebInspect", true, TestResults.ToolType.DAST);

        // <Scan><Name>Site: https://10.240.28.203:8443/benchmark/</Name><PolicyName>Standard</PolicyName>
        // <StartTime>9/11/2015 1:56:13 PM</StartTime><Duration>02:59:39.0365257</Duration><Issues><Issue>
                
        String duration = getNamedChild("Duration", root ).getTextContent();
        duration = duration.substring( 0, duration.indexOf( '.' ));
        tr.setTime( duration );
        
        Node issues = getNamedChild( "Issues", root );
        List<Node> issueList = getNamedChildren( "Issue", issues );
        
        for ( Node issue : issueList ) {
            try {
                TestCaseResult tcr = parseWebInspectIssue(issue);
                if (tcr != null ) {
                    tr.put(tcr);
                }
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
        return tr;
	}
	
//    <Issue>
//    <CheckTypeID>Vulnerability</CheckTypeID>
//    <EngineType>REQMOD</EngineType>
//    <URL>https://10.240.28.203:8443/benchmark/BenchmarkTest02607.html</URL>
//    <Scheme>https</Scheme>
//    <Host>10.240.28.203</Host>
//    <Port>8443</Port>
//    <TriggerSession null="1"/>
//    <VulnerabilityID>11306</VulnerabilityID>
//    <Severity>1</Severity>
//    <Name>Server Misconfiguration: Cache Policy</Name>
	
	private TestCaseResult parseWebInspectIssue( Node flaw ) throws Exception {
        TestCaseResult tcr = new TestCaseResult();

        String cat = getNamedChild("Name", flaw).getTextContent();
        tcr.setCategory( cat );
        tcr.setEvidence( cat );

        Node vulnId = getNamedChild("VulnerabilityID", flaw);
        if ( vulnId != null ) {
            String vuln = vulnId.getTextContent();
            int cwe = cweLookup( vuln );
            tcr.setCWE( cwe  );
        }
        
        String conf = getNamedChild( "Severity", flaw ).getTextContent();
        tcr.setConfidence( Integer.parseInt( conf ) );
        
        String uri = getNamedChild( "URL", flaw ).getTextContent();
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

	
	private static int cweLookup( String rule ) {
		switch( rule ) {
		case "810" : return 0000;    //Poor Error Handling: Unhandled Exception
		case "1436" : return 0000;   // Poor Error Handling: Unhandled Exception
		case "1498" : return 0000;   // Poor Error Handling: Unhandled Exception
		case "4720" : return 614;    // Cookie Security: Cookie Not Sent Over SSL
		case "4724" : return 0000;   // Password Management: Unmasked Password Field
		case "4725" : return 0000;   // Server Misconfiguration: SSL Certificate Hostname Discrepancy
		case "4729" : return 0000;   // Transport Layer Protection: Insecure Transmission
		case "5546" : return 0000;   // Compliance Failure: Missing Privacy Policy
		case "5597" : return 0000;   // Privacy Violation: Autocomplete
		case "5649" : return 79;     // Cross-Site Scripting: Reflected
		case "10167" : return 0000;  // Password Management: Insecure Submission
		case "10210" : return 0000;  // Access Control: Unprotected Directory
		case "10237" : return 0000;  // Privacy Violation: Credit Card Number
		case "10543" : return 0000;  // Cookie Security: HTTPOnly not Set
		case "10655" : return 0000;  // Application Misconfiguration: Exposure of POST Parameters in GET Request
		case "10825" : return 0000;  // Privacy Violation: Credit Card Number
		case "10932" : return 0000;  // Poor Error Handling: Server Error Message
		case "10965" : return 0000;  // Transport Layer Protection: Insecure Transmission
		case "11293" : return 79;    // Cross-Frame Scripting
		case "11294" : return 79;    // Cross-Frame Scripting
		case "11299" : return 89;    // SQL Injection: Blind
		case "11306" : return 0000;  // Server Misconfiguration: Cache Policy
		case "11359" : return 0000;  // Server Misconfiguration: Response Headers
		case "11365" : return 0000;  // Insecure SSL: Missing Http Strict Transport
		case "11380" : return 0000;  // Often Misused: Weak SSL Certificate
		case "11395" : return 0000;  // Transport Layer Protection: Weak SSL Protocol 
	 	
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
		return 0;
	}

}
