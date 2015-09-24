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

import org.w3c.dom.Document;
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
        if (testcase.startsWith("BenchmarkTest")) {
            String testno = testcase.substring("BenchmarkTest".length() );
            try {
                tcr.setNumber(Integer.parseInt(testno));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return tcr;
        }

        return null;
    }

    private int translate(String id) {
        switch (id) {
        case "2097920": return 79;   // XSS
        case "5247488": return 9999; // DOM Trust Boundary Violation - Map to nothing right now.
        case "1048832": return 78;   // Command Injection 
        case "1051392": return 22;   // Path Manipulation
        case "5243392": return 614;  // SSL cookie without secure flag set
        case "5244416": return 9998; // cookie without HttpOnly flag set - There is no CWE defined for this weakness
        case "1050112": return 643;  // XPATH injection
        case "1049344": return 22;   // Path Manipulation
        case "1049088": return 89;   // SQL injection
        case "6291968": return 200;  // Information Disclosure - Email Address Disclosed 
        case "6292736": return 200;  // Information Disclosure - Credit Card # Disclosed 
        case "7340288": return 525;  // Information Exposure Through Browser Caching-Cacheable HTTPS Response
        case "5245344": return 8888; // Clickjacking - There is no CWE # for this.
        case "8389632": return 9999; // Incorrect Content Type - Don't care. Map to nothing right now.
        case "2098944": return 352;  // CSRF Vulnerability
        case "8389120": return 9999; // HTML doesn't specify character set - Don't care. Map to nothing.
                
            // //case "Build Misconfiguration" : return 00;
            // case "Cookie Security" : return 614;
            // //case "Dead Code" : return 00;
            // //case "Denial of Service" : return 00;
            // case "Header Manipulation" : return 113;
            // case "Insecure Randomness" : return 330;
            // //case "J2EE Bad Practices" : return 00;
            // case "LDAP Injection" : return 90;
            // //case "Missing Check against Null" : return 00;
            // //case "Null Dereference" : return 00;
            // case "Password Management" : return 00;
            // //case "Poor Error Handling" : return 00;
            // //case "Poor Logging Practice" : return 00;
            // //case "Poor Style" : return 00;
            // //case "Resource Injection" : return 00;
            // //case "System Information Leak" : return 00;
            // case "Trust Boundary Violation" : return 501;
            // //case "Unreleased Resource" : return 00;
            // //case "Unsafe Reflection" : return 00;
            // case "Weak Cryptographic Hash" : return 328;
            // case "Weak Encryption" : return 327;
        }
        System.out.println("Unknown id: " + id);
        return -1;
    }

}
