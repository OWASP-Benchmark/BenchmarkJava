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
 * @author Bosko Stankovic
 * @created 2017
 */

package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ThunderScanReader extends Reader {
    
    static List<String> fileListDuplicates = new ArrayList<String>();

    public TestResults parse(File f) throws Exception {
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource fileInput = new InputSource(new FileInputStream(f));
        Document doc = dBuilder.parse(fileInput);
        
        TestResults testResults = new TestResults("ThunderScan", true, TestResults.ToolType.SAST);

        NodeList vulnTypeNodeList = doc.getElementsByTagName("VulnerabilityType");
        
        for(int i = 0; i < vulnTypeNodeList.getLength(); i++) {
            Node vulnTypeNode = vulnTypeNodeList.item(i);
            Element eElement = (Element)vulnTypeNode;
            
            String vulnerabilityType = eElement.getAttribute("Name");
            NodeList vulnerabilities = eElement.getElementsByTagName("Vulnerability");
            
            if(vulnerabilities.getLength() < 1) continue;
            
            for(int j = 0; j < vulnerabilities.getLength(); j++) {
                
                Node vulnerability = vulnerabilities.item(j);
                Element vulnElement = (Element)vulnerability;
                
                String file = vulnElement.getElementsByTagName("File").item(0).getTextContent();
                String function = vulnElement.getElementsByTagName("Function").item(0).getTextContent();
                
                if(!file.contains(BenchmarkScore.TESTCASENAME)) continue;
                if(function.matches("/printStackTrace|Cookie$|getMessage$/")) continue;
                
                TestCaseResult tcResult = parseThunderScanVulnerability(vulnElement, vulnerabilityType);
                if(tcResult != null) testResults.put(tcResult);
            }
        }
        
        return testResults;
    }
    
    private static TestCaseResult parseThunderScanVulnerability(Element vulnElement, String vulnType) {
        
        TestCaseResult tcResult = new TestCaseResult();

        int cwe = 0;
        
        @SuppressWarnings("serial")
		Map<String, Integer> vulnTypesMap = new HashMap<String, Integer>() {{
            put("SQL Injection", 89);
            put("File Disclosure", 22);
            put("JSP Page Execution", 0);
            put("Command Execution", 78);
            put("Cross Site Scripting", 79);
            put("File Manipulation", 22);
            put("HTTP Response Splitting", 0);
            put("LDAP Injection", 90);
            put("XPATH Injection", 643);
            put("Mail Relay", 0);
            put("Log Forging", 0);
            put("Misc. Dangerous Functions", 31339);
            put("Arbitrary Server Connection", 0);
            put("Dangerous File Extensions", 0);
        }};
        
        cwe = vulnTypesMap.get(vulnType);
        
        String file = vulnElement.getElementsByTagName("File").item(0).getTextContent();
        String function = vulnElement.getElementsByTagName("Function").item(0).getTextContent();
        Node functionCalls = vulnElement.getElementsByTagName("FunctionCalls").item(0);
        String line = ((Element)((Element)functionCalls).getElementsByTagName("CallStackItem").item(0)).getAttribute("Line");

        String testcase = file.substring(file.lastIndexOf('\\') + 1);
        String testNumber = testcase.substring(BenchmarkScore.TESTCASENAME.length(), testcase.length() - 5);
                
        if(cwe == 31339) {
            if(function.contains("Weak Enc")) cwe = 327;
            if(function.contains("Weak Hash")) cwe = 328;
            if(function.contains("Weak Random")) cwe = 330;
            if(function.contains("putValue") || function.contains("setAttribute")) cwe = 501;
            if(function.contains("setSecure")) cwe = 614;
        }
        
        if(cwe == 0 || cwe == 31339 || fileListDuplicates.contains(file)) return null;
        
        tcResult.setCWE(cwe);
        tcResult.setNumber(Integer.parseInt(testNumber));
        tcResult.setCategory(vulnType);
        tcResult.setConfidence(1);
        tcResult.setEvidence(line);
        
        fileListDuplicates.add(file);
        
        return tcResult;
    }
}
