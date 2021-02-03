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
 * @author Christian Lopez <a href="https://www.qualys.com/">Qualys</a>
 * @created 2019
 */

package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.util.List;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Node;

public class QualysWASReader extends Reader {

    // filename passed in so we can extract the scan time if it is included in the filename
    // root of XML doc passed in so we can parse the results
    public TestResults parse(File f, Node root) throws Exception {

        TestResults tr = new TestResults("Qualys WAS", true, TestResults.ToolType.DAST);

	// If the fliename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.xml) set the compute time on the scorecard.
	tr.setTime(f);
	// TODO: Parse out start/end time to calculate scan time from results file.

        // <APPENDIX>
        //     <SCAN_LIST>
        //         <SCAN>
        //             <NAME>Web Application Vulnerability Scan - OWASP Benchmark tool - 2019-05-15</NAME>
        //             <REFERENCE>was/1557936890220.1078424</REFERENCE>
        //             <START_DATE>15 May 2019 06:16PM GMT+0200</START_DATE>
        //             <END_DATE>16 May 2019 01:04AM GMT+0200</END_DATE>
        //             <MODE>Vulnerability</MODE>
        //             <PROGRESSION_NUMBER>1</PROGRESSION_NUMBER>
        //             <TYPE>Manual</TYPE>
        //             <WEB_APPLICATION>OWASP Benchmark tool</WEB_APPLICATION>
        //             <AUTHENTICATION_RECORD>None</AUTHENTICATION_RECORD>
        //             <PROFILE>owasp-benchmark-categories</PROFILE>
        //             <SCANNER>External (IP: X.X.X.X, Scanner: 11.2.34-1, WAS: 6.7.28-1, Signatures: 2.4.603-3)</SCANNER>
        //             <STATUS>Finished</STATUS>
        //             <AUTHENTICATION_STATUS>No Authentication specified</AUTHENTICATION_STATUS>
        //         </SCAN>
        //     </SCAN_LIST>

        List<Node> appendix = getNamedChildren("APPENDIX", root);
        List<Node> scanList = getNamedChildren("SCAN_LIST", appendix);
        List<Node> scan = getNamedChildren( "SCAN", scanList);

        String version = getNamedChild("PROFILE", scan.get(0)).getTextContent();  // There is only one (1) node
        tr.setToolVersion(version);

        // <VULNERABILITY>
        //     <ID>79308561</ID>
        //     <DETECTION_ID>2229440</DETECTION_ID>
        //     <QID>150123</QID>
        //     <URL>https://localhost:8443/benchmark/weakrand-04/BenchmarkTest02012</URL>
        //     <AJAX>false</AJAX>
        //     <AUTHENTICATION>Not Required</AUTHENTICATION>
        //     <DETECTION_DATE>15 May 2019 06:16PM GMT+0200</DETECTION_DATE>
        //     <PAYLOADS>
        //         <PAYLOAD>
        //             <NUM>1</NUM>
        //             <PAYLOAD>N/A</PAYLOAD>
        //             <REQUEST>
        //                 <METHOD>GET</METHOD>
        //                 <URL>https://localhost:8443/benchmark/weakrand-04/BenchmarkTest02012</URL>
        //                 <HEADERS/>
        //             </REQUEST>
        //             <RESPONSE>
        //                 <CONTENTS base64="true">REDACTED</CONTENTS>
        //             </RESPONSE>
        //         </PAYLOAD>
        //     </PAYLOADS>
        //     <IGNORED>false</IGNORED>
        // </VULNERABILITY>

        List<Node> resultsList = getNamedChildren( "RESULTS", root );
        List<Node> vulnerabilityList = getNamedChildren( "VULNERABILITY_LIST", resultsList );
        List<Node> issueList = getNamedChildren( "VULNERABILITY", vulnerabilityList );

        for (Node issue : issueList) {
            TestCaseResult tcr = parseQualysVulnerability(issue);
            if (tcr != null) {
                tr.put(tcr);
            }
        }
        return tr;
    }

    private TestCaseResult parseQualysVulnerability(Node issue) {
        TestCaseResult tcr = new TestCaseResult();
        String cwe = getNamedChild("QID", issue).getTextContent();
        tcr.setCWE(translate_cwe(cwe));

        String name = getNamedChild("QID", issue).getTextContent();
        tcr.setCategory(translate_name(name));
        tcr.setEvidence(translate_name(name));

        String testcase = getNamedChild("URL", issue).getTextContent();

        // <URL>https://localhost:8443/benchmark/weakrand-04/BenchmarkTest02012</URL>
        // <URL><![CDATA[https://localhost:8443/benchmark/cmdi-00/BenchmarkTest00815?username=John&password=password&BenchmarkTest00815=(23.0231*213.759)]]></URL>

        testcase = testcase.substring(testcase.lastIndexOf('/') + 1);
        testcase = testcase.split("\\.")[0];
        testcase = testcase.split("\\?")[0];

        if (testcase.startsWith(BenchmarkScore.TESTCASENAME)) {
            String testno = testcase.substring(BenchmarkScore.TESTCASENAME.length() );
            try {
                tcr.setNumber(Integer.parseInt(testno));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return tcr;
        }
        return null;
    }

    private int translate_cwe(String id) {
        switch (id) {
            case "150001": return 79;	// Reflected Cross-Site Scripting (XSS) Vulnerabilities
            case "150003": return 89;	// SQL Injection
            case "150009": return 9999;	// Links Crawled
            case "150010": return 9999;	// External Links Discovered
            case "150012": return 89;	// Blind SQL Injection
            case "150018": return 9999;	// Connection Error Occurred During Web Application Scan
            case "150021": return 9999;	// Scan Diagnostics
            case "150022": return 209;	// Verbose Error Message
            case "150028": return 9999;	// Cookies Collected
            case "150033": return 9999;	// Credit Card Number Pattern Identified In HTML
            case "150042": return 9999;	// Server Returns HTTP 500 Message For Request
            case "150046": return 79;	// Reflected Cross-Site Scripting (XSS) in HTTP Header
            case "150054": return 9999;	// Email Addresses Collected
            case "150055": return 78;	// PHP Command Injection
            case "150079": return 772;	// Slow HTTP headers vulnerability
            case "150081": return 693;	// X-Frame-Options header is not set
            case "150084": return 79;	// Unencoded characters 
            case "150085": return 772;	// Slow HTTP POST vulnerability
            case "150086": return 9999;	// Server accepts unnecessarily large POST request body
            case "150104": return 9999;	// Form Contains Email Address Field
            case "150115": return 9999;	// Authentication Form found
            case "150122": return 614;	// Cookie Does Not Contain The "secure" Attribute
            case "150123": return 1004;	// Cookie Does Not Contain The "HTTPOnly" Attribute
            case "150124": return 451;	// Clickjacking - Framable Page
            case "150126": return 9999;	// Links With High Resource Consumption
            case "150135": return 9999;	// HTTP Strict Transport Security (HSTS) header missing/misconfigured.
            case "150148": return 9999;	// AJAX Links Crawled
            case "150152": return 9999;	// Forms Crawled
            case "150162": return 937;	// Use of JavaScript Library with Known Vulnerability
            case "150172": return 9999;	// Requests Crawled
            case "150176": return 9999;	// JavaScript Libraries Detected
            case "150202": return 9999;	// Missing header: X-Content-Type-Options
            case "150204": return 9999;	// Missing header: X-XSS-Protection
            case "150205": return 9999;	// Misconfigured header: X-XSS-Protection
            case "150206": return 9999;	// Content-Security-Policy Not Implemented
            case "150251": return 643;	// Blind XPath Injection
            case "123456": return 6666;
        } // end switch(id)
        System.out.println("Unknown id: " + id);
        return -1;
    }

    // Qualys does not provide the NAME of the vulnerabilities in the VULNERABILITY node. These are available in <QID_LIST> node.
    // TODO: instead of adding the titles in the translate_name(), parse the <QID_LIST> node to get that information.

    private String translate_name(String id) {
        switch (id) {
            case "150001": return "Reflected Cross-Site Scripting (XSS) Vulnerabilities";
            case "150003": return "SQL Injection";
            case "150009": return "Links Crawled";
            case "150010": return "External Links Discovered";
            case "150012": return "Blind SQL Injection";
            case "150018": return "Connection Error Occurred During Web Application Scan";
            case "150021": return "Scan Diagnostics";
            case "150022": return "Verbose Error Message";
            case "150028": return "Cookies Collected";
            case "150033": return "Credit Card Number Pattern Identified In HTML";
            case "150042": return "Server Returns HTTP 500 Message For Request";
            case "150046": return "Reflected Cross-Site Scripting (XSS) in HTTP Header";
            case "150054": return "Email Addresses Collected";
            case "150055": return "PHP Command Injection";
            case "150079": return "Slow HTTP headers vulnerability";
            case "150081": return "X-Frame-Options header is not set";
            case "150084": return "Unencoded characters ";
            case "150085": return "Slow HTTP POST vulnerability";
            case "150086": return "Server accepts unnecessarily large POST request body";
            case "150104": return "Form Contains Email Address Field";
            case "150115": return "Authentication Form found";
            case "150122": return "Cookie Does Not Contain The secure Attribute";
            case "150123": return "Cookie Does Not Contain The HTTPOnly Attribute";
            case "150124": return "Clickjacking - Framable Page";
            case "150126": return "Links With High Resource Consumption";
            case "150135": return "HTTP Strict Transport Security (HSTS) header missing/misconfigured.";
            case "150148": return "AJAX Links Crawled";
            case "150152": return "Forms Crawled";
            case "150162": return "Use of JavaScript Library with Known Vulnerability";
            case "150172": return "Requests Crawled";
            case "150176": return "JavaScript Libraries Detected";
            case "150202": return "Missing header: X-Content-Type-Options";
            case "150204": return "Missing header: X-XSS-Protection";
            case "150205": return "Misconfigured header: X-XSS-Protection";
            case "150206": return "Content-Security-Policy Not Implemented";
            case "150251": return "Blind XPath Injection";
        } // end switch(id)
        System.out.println("Unknown id: " + id);
        return id;
    }

}
