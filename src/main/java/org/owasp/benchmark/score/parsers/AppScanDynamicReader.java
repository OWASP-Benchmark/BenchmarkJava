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

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Node;

public class AppScanDynamicReader extends Reader {
    
    public TestResults parse(Node root) throws Exception {

        TestResults tr = new TestResults("IBM AppScan", true, TestResults.ToolType.DAST);

//      <AppScanInfo>
//        <Version>9.0.1.1</Version>
//        <ServicePack />
//      </AppScanInfo>

        Node info = getNamedChild("AppScanInfo", root);
        Node version = getNamedChild( "Version", info );
        tr.setToolVersion(version.getTextContent());

//        <Summary>
//        <TotalScanDuration>14:48:40.9394530</TotalScanDuration>

        Node summary = getNamedChild("Summary", root);
        Node elapsed = getNamedChild( "TotalScanDuration", summary );
        tr.setTime(calculateTime(elapsed.getTextContent()));
        
//        <IssueType ID="SSL_CertWithBadCN" Count="1">
//        <RemediationID>fix_60280</RemediationID>
//        <advisory>
//          <name>SSL Certificate Domain Name Mismatch</name>
//          <testDescription>Infrastructure test</testDescription>
//          <threatClassification>
//            <name>Insufficient Transport Layer Protection</name>
//            <reference>http://projects.webappsec.org/Insufficient-Transport-Layer-Protection</reference>
//          </threatClassification>
//          <testTechnicalDescription>
//          </testTechnicalDescription>
//          <causes>
//            <cause>The web server or application server are configured in an insecure way</cause>
//          </causes>
//          <securityRisks>
//          </securityRisks>
//          <affectedProducts>
//            <affectedProduct>N/A</affectedProduct>
//          </affectedProducts>
//          <cwe>
//            <link target="http://cwe.mitre.org/data/definitions/297.html" id="CWE-297">297</link>
//          </cwe>
//          <xfid>
//            <link target="http://xforce.iss.net/xforce/xfdb/52881" id="52881">52881</link>
//          </xfid>
//          <references />
//          <fixRecommendations>
//            <fixRecommendation type="General">
//            </fixRecommendation>
//          </fixRecommendations>
//        </advisory>
//        <Severity>Informational</Severity>
//        <Invasive>False</Invasive>
//      </IssueType>
        
        // parse issue types list into cweMap
        Map<String,Integer> cweMap = new HashMap<String,Integer>();
        Node results = getNamedChild("Results", root);
        Node issueTypes = getNamedChild("IssueTypes", results);
        List<Node> issueTypeList = getNamedChildren("IssueType", issueTypes);
        for ( Node issueType : issueTypeList ) {
            try {
                String key = getAttributeValue( "ID", issueType );
                Node advisory = getNamedChild( "advisory", issueType );
                Node cwenode = getNamedChild( "cwe", advisory );
                Node link = getNamedChild( "link", cwenode );
                Integer cwe = Integer.parseInt( link.getTextContent() );
                cweMap.put( key, cwe );
            } catch( Exception e ) {
                // System.out.println( "Found an issueType with no CWE link: " + getAttributeValue( "ID", issueType ));
            }
        }
        
        Node issues = getNamedChild("Issues", results);
        List<Node> issueList = getNamedChildren("Issue", issues);
        for (Node issue : issueList) {
            TestCaseResult tcr = parseAppScanDynamicVulnerability(issue, cweMap);
            if (tcr != null) {
                // System.out.println( tcr.getNumber() + "\t" + tcr.getCWE() + "\t" + tcr.getEvidence() );
                tr.put(tcr);
            }
        }
        return tr;
    }


    
//  <TotalScanDuration>14:48:40.9394530</TotalScanDuration>
    private static String calculateTime(String elapsed) {
        try {
            String[] splits = elapsed.split( "[\\.:]");
            int hours = Integer.parseInt( splits[0] );
            int minutes = Integer.parseInt( splits[1] );
            int seconds = Integer.parseInt( splits[2] );
            long millis = 1000 * ( hours * 60 * 60 + minutes * 60 + seconds );
            return TestResults.formatTime( millis );
        } catch( Exception e ) {
            e.printStackTrace();
            return "Unknown";
        }
    }
    
//    <Issue IssueTypeID="attBlindSqlInjectionStrings" Noise="False">
//    <Url>https://localhost:8443/benchmark/BenchmarkTest00153</Url>
    private TestCaseResult parseAppScanDynamicVulnerability(Node issue, Map<String,Integer> cweMap ) {
        TestCaseResult tcr = new TestCaseResult();
        String cwekey = getAttributeValue("IssueTypeID", issue);
        Integer cwe = cweMap.get(cwekey);
        if ( cwe == null ) return null;
        tcr.setCWE(translate(cwe));

        tcr.setCategory(cwekey);
        tcr.setEvidence(cwekey);

        // fixme: not really confidence
        // fixme: what is "noise" attribute?
        String confidence = getNamedChild( "Severity", issue ).getTextContent();
        // tcr.setConfidence( makeIntoInt( confidence ) );

        String testcase = getNamedChild("Url", issue).getTextContent();
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

    private int translate(int id) {
        switch (id) {
            // //case "Build Misconfiguration" : return 00;
            // case "Command Injection" : return 78;
            // case "Cookie Security" : return 614;
            // case "Cross-Site Scripting" : return 79;
            // //case "Dead Code" : return 00;
            // //case "Denial of Service" : return 00;
            // case "Header Manipulation" : return 113;
            // case "Insecure Randomness" : return 330;
            // //case "J2EE Bad Practices" : return 00;
            // case "LDAP Injection" : return 90;
            // //case "Missing Check against Null" : return 00;
            // //case "Null Dereference" : return 00;
            // case "Password Management" : return 00;
            // case "Path Manipulation" : return 22;
            // //case "Poor Error Handling" : return 00;
            // //case "Poor Logging Practice" : return 00;
            // //case "Poor Style" : return 00;
            // //case "Resource Injection" : return 00;
            // case "SQL Injection" : return 89;
            // //case "System Information Leak" : return 00;
            // case "Trust Boundary Violation" : return 501;
            // //case "Unreleased Resource" : return 00;
            // //case "Unsafe Reflection" : return 00;
            // case "Weak Cryptographic Hash" : return 328;
            // case "Weak Encryption" : return 327;
            // case "XPath Injection" : return 643;
        }
        return id;
    }

}
