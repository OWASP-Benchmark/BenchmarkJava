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
 * @author Parthi Shah <a href="http://www.iappsecure.com">iAppSecure</a>
 * @created 2016
 *
 * This file reuses existing OWASP Benchmark Project code with Fusion Lite Insight specific changes by Parthi Shah
 */

package org.owasp.benchmark.score.parsers;

import java.util.List;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Node;

public class SnappyTickReader extends Reader {

	
	public TestResults parse( Node root ) throws Exception {
        
		// root Node is Report
		Node toolInfo = getNamedChild("ToolInfo", root);
		Node tool = getNamedChild("Tool", toolInfo);
        String toolName = getAttributeValue("Name", tool);
        TestResults tr = new TestResults(toolName, true, TestResults.ToolType.SAST);

        String version = getAttributeValue("Version", tool);
        tr.setToolVersion(version);
        
		Node projectInfo = getNamedChild("ProjectInfo", root);
		Node project = getNamedChild("Project", projectInfo);
        String duration = getAttributeValue("Duration", project);
        tr.setTime( duration );
        
        // Inside of the <VulnerabilityReport> are <Severity Level> then <VulnerabilityCollection> like so:
        //<VulnerabilityReport>
        //  <Severity Level="Critical">
        //    <VulnerabilityCollection>
        //      <Vulnerability Title="SQL Injection" CWE="89" OWASP="A1">
        //        <Description>...</Description>
        //        <Impact>...</Impact>
        //        <Remediation>...</Remediation>
        //        <FindingsList>
        //          <Finding FileName="BenchmarkTest00008.java" LineNo="59" 
        //                  CodeLine="java.sql.ResultSet rs = statement.executeQuery();" />      
        
        Node vulnReport = getNamedChild("VulnerabilityReport", root);
        
        // Loop through all the Severity nodes
        List<Node> sevLevels = getNamedChildren("Severity", vulnReport);
        
        for (Node issue : sevLevels) {
        	// There is only 1 VulnerabilityCollection per severity level
            Node vulnCollect = getNamedChild("VulnerabilityCollection", issue);
            
            // There can be multiple Vulnerability nodes per VulnerabilityCollection
            List<Node> vulnerabilities = getNamedChildren("Vulnerability", vulnCollect);
            for (Node vulnerability : vulnerabilities) {
	            String cweNum = getAttributeValue("CWE", vulnerability);
	            int findingCWE = cweLookup(cweNum);
	            // There is a single FindingsList per Vulnerability category
	            Node findingsList = getNamedChild("FindingsList", vulnerability);
	            List<Node> findings = getNamedChildren("Finding", findingsList);
	            for (Node finding : findings) {
	                String filename = getAttributeValue("FileName", finding);
	                String findingName = filename.substring(0, filename.indexOf("."));
	                if (findingCWE != 0) {
	                    int testNumber = extractTestNumber(findingName);
	                    if (testNumber != -1) {
	                        TestCaseResult tcr = new TestCaseResult();
	                        tcr.setCategory(findingName);
	                        tcr.setCWE(findingCWE);
	                        tcr.setEvidence(findingName);
	                        tcr.setNumber(testNumber);
	                        tr.put(tcr);
	                    }
	                }
	            }
            }
        }

        return tr;
    }

    private static int extractTestNumber(String testfile) {

        if ( testfile.startsWith( BenchmarkScore.TESTCASENAME ) ) {
            String testno = testfile.substring(BenchmarkScore.TESTCASENAME.length());
            try {
                return Integer.parseInt( testno );
            } catch( NumberFormatException e ) {
                System.out.println( "> Parse error " + testfile + ":: " + testno );
            }
        }
        return -1;
    }

    private static int cweLookup(String checkerKey) {

      switch (checkerKey.trim()) {

        case "1004": return 614; // HTTPOnly Flag Not Set For Cookies:insecure cookie use
        case "614":  return 614; // Cookie not Sent Over SSL:insecure cookie use
        case "78":   return 78;  // command injection
        case "89":   return 89;  // SQL injection
        case "755":  return 755; // SQL Exception Vulnerability:Info Leak
        case "258":  return 000; // "Use an empty string as a password"
        case "20":   return 20;  // "Input Validation Issue or Input Validation Required"
        case "79":   return 79;  // Malicious Scripting Attacks and xss
        case "73":   return 22;  // Path Manipulation: path traversal
        case "538":  return 22;  // File Disclosure Vulnerability:path traversal
        case "330":  return 330; // Use of java.util.Random generator function:weak random
        case "327":  return 327; // Broken Cryptography or 
                                 // Weak Encryption Insecure Mode of Operation:weak encryption
        case "328":  return 328; // Broken Hashing algorithm
        default:
           System.out.println("Found unrecognized vulnerability type in Snappy Tick results: " + checkerKey);
      }
      return 0;
    }

}
