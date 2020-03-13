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

public class BurpReader extends Reader {
    
    public TestResults parse(Node root) throws Exception {

        TestResults tr = new TestResults("Burp Suite Pro", true, TestResults.ToolType.DAST);

        // <issues burpVersion="1.6.24"
        // exportTime="Wed Aug 19 23:27:54 EDT 2015">

        String version = getAttributeValue("burpVersion", root);
        tr.setToolVersion(version);

        // String time = getAttributeValue("ScanTime", root);
        // tr.setTime( time );
        // TODO - fix it so you can get the time out of the Burp Results filename by default.
        // TODO - Ideally, we'd get the time out of the Burp results file, if they can provide it

        List<Node> issueList = getNamedChildren("issue", root);

        for (Node issue : issueList) {
            TestCaseResult tcr = parseBurpVulnerability(issue);
            if (tcr != null) {
//                System.out.println( tcr.getNumber() + "\t" + tcr.getCWE() + "\t" + tcr.getEvidence() );
                tr.put(tcr);
            }
        }
        return tr;
    }

    // <issue>
    // <serialNumber>5773821289236842496</serialNumber>
    // <type>2097920</type>
    // <name>Cross-site scripting (reflected)</name>
    // <host ip="127.0.0.1">https://localhost:8443</host>
    // <path><![CDATA[/benchmark/BenchmarkTest00023]]></path>
    // <location><![CDATA[/benchmark/BenchmarkTest00023 [vector parameter]]]></location>
    // <severity>High</severity>
    // <confidence>Certain</confidence>
    // <issueBackground></remediationBackground>
    // <references></references>
    // <issueDetail></issueDetail>
    // </issue>

    private TestCaseResult parseBurpVulnerability(Node issue) {
        TestCaseResult tcr = new TestCaseResult();
        String cwe = getNamedChild("type", issue).getTextContent();
        tcr.setCWE(translate(cwe));

        String name = getNamedChild("name", issue).getTextContent();
        tcr.setCategory(name);
        tcr.setEvidence(name);

        //String confidence = getNamedChild( "confidence", issue ).getTextContent();
        // tcr.setConfidence( makeIntoInt( confidence ) );

        String testcase = getNamedChild("path", issue).getTextContent();
        testcase = testcase.substring(testcase.lastIndexOf('/') + 1);
        testcase = testcase.split("\\.")[0];        
        if (testcase.startsWith(BenchmarkScore.BENCHMARKTESTNAME)) {
            String testno = testcase.substring(BenchmarkScore.BENCHMARKTESTNAME.length() );
            try {
                tcr.setNumber(Integer.parseInt(testno));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return tcr;
        }

        return null;
    }
    // https://portswigger.net/burp/help/scanner_issuetypes.html - This page lists all the issue types Burp 
    // looks for, and their customer ID #'s. There are more on this page. The following primarily lists those
    // that are currently relevant in the Benchmark.
    private int translate(String id) {
        switch (id) {
        case "1048832": return 78;   // Command Injection 
        case "1049088": return 89;   // SQL Injection
        case "1049344": return 22;   // File Path Traversal
        case "1049600": return 611;  // XXE
        case "1049856": return 90;   // LDAP Injection
        case "1050112": return 643;  // XPATH Injection
        case "1050368": return 643;  // XML Injection - Meaning what?
        case "1051392": return 22;   // File Path Manipulation - Not sure exact difference with 1049344 above
        case "2097408": return 79;   // Stored XSS
        case "2097920": return 79;   // Reflected XSS
        case "2097936": return 79;   // DOM-Based XSS (Probably want separate ID for this in the future)
        case "2098944": return 352;  // CSRF Vulnerability
        case "4194560": return 9999; // Referer Dependent Response
        case "4194576": return 9999; // X-Forwarded-For header dependency
        case "5243392": return 614;  // SSL cookie without secure flag set
        case "5244416": return 9998; // Cookie without HttpOnly flag set - There is no CWE defined for this weakness
        case "5245344": return 8888; // Clickjacking - There is no CWE # for this.
        case "5247488": return 9999; // DOM Trust Boundary Violation - Map to nothing right now.
        case "6291968": return 200;  // Information Disclosure - Email Address Disclosed 
        case "6292736": return 200;  // Information Disclosure - Credit Card # Disclosed 
        case "7340288": return 525;  // Information Exposure Through Browser Caching-Cacheable HTTPS Response
        case "8389120": return 9999; // HTML doesn't specify character set - Don't care. Map to nothing.
        case "8389632": return 9999; // Incorrect Content Type - Don't care. Map to nothing right now.
        case "8389888": return 16; // Content type is not specified
        case "5245360": return 16; // Browser cross-site scripting filter disabled
        case "4197632": return 20; // Suspicious input transformation (reflected)
        case "4197376": return 20; // Input returned in response (reflected)
        case "3146240": return 918; // External service interaction (DNS)
        
            // case "Build Misconfiguration" : return 00;
            // case "Cookie Security" : return 614;
            // case "Dead Code" : return 00;
            // case "Denial of Service" : return 00;
            // case "Header Manipulation" : return 113;
            // case "Insecure Randomness" : return 330;
            // case "J2EE Bad Practices" : return 00;
            // case "Missing Check against Null" : return 00;
            // case "Null Dereference" : return 00;
            // case "Password Management" : return 00;
            // case "Poor Error Handling" : return 00;
            // case "Poor Logging Practice" : return 00;
            // case "Poor Style" : return 00;
            // case "Resource Injection" : return 00;
            // case "System Information Leak" : return 00;
            // case "Trust Boundary Violation" : return 501;
            // case "Unreleased Resource" : return 00;
            // case "Unsafe Reflection" : return 00;
            // case "Weak Cryptographic Hash" : return 328;
            // case "Weak Encryption" : return 327;
        } // end switch(id)
        System.out.println("Unknown id: " + id);
        return -1;
    }

}
