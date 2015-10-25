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

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class CheckmarxReader extends Reader {

    public TestResults parse(File f) throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// Prevent XXE
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        InputSource is = new InputSource(new FileInputStream(f));
        Document doc = docBuilder.parse(is);

        TestResults tr = new TestResults( "Checkmarx CxSAST",true, TestResults.ToolType.SAST );
       
        // <CxXMLResults DeepLink="http://CHECKMARX2/CxWebClient/ViewerMain.aspx?scanid=52869&amp;projectid=30265"
        // ScanStart="Monday, July 27, 2015 4:50:08 PM" Preset="Default 2014" ScanTime="13h:54m:20s"
        // LinesOfCodeScanned="1507279" FilesScanned="21075" ReportCreationTime="Tuesday, July 28, 2015 8:38:30 AM"
        // Team="CxServer" CheckmarxVersion="7.1.8 HF2" ScanComments="" ScanType="Full" SourceOrigin="LocalPath">

        Node root = doc.getDocumentElement();
        String version = getAttributeValue( "CheckmarxVersion", root );
        tr.setToolVersion( version );
        
        String time = getAttributeValue("ScanTime", root);
        tr.setTime( time );
        
        List<Node> queryList = getNamedChildren( "Query", root );

        for ( Node query : queryList ) {            
            List<Node> resultList = getNamedChildren( "Result", query );
            for ( Node result : resultList ) {
                TestCaseResult tcr = parseCheckmarxVulnerability(query, result);
                if (tcr != null ) {
                    tr.put(tcr);
                }
            }
        }
        return tr;
    }
    
    private TestCaseResult parseCheckmarxVulnerability(Node query, Node result) {
        TestCaseResult tcr = new TestCaseResult();
        // <Query id="594" cweId="89" name="SQL_Injection" group="Java_High_Risk" Severity="High"
        // Language="Java" LanguageHash="0188428345217368" LanguageChangeDate="2015-07-14T00:00:00.0000000"
        // SeverityIndex="3">

        // <Result NodeId="528692318" FileName="/org/owasp/benchmark/testcode/BenchmarkTest00026.java"
        // Status="New" Line="50" Column="29" FalsePositive="False" Severity="High" AssignToUser="" 
        // state="0" Remark=""
        // DeepLink="http://CHECKMARX2/CxWebClient/ViewerMain.aspx?scanid=52869&amp;projectid=30265&amp;pathid=2318"
        // SeverityIndex="3">
        
        String cwe = getAttributeValue("cweId", query);
        if ( cwe != null ) {
            tcr.setCWE( translate( Integer.parseInt(cwe ) ) );
        } else {
            System.out.println( "flaw: " + query );
        }
        
        String name = getAttributeValue("name", query);
        tcr.setCategory( name );
        // filter out dynamic SQL queries because they report SQL injection separately - these are just dynamic SQL
        if ( name.equals( "Dynamic_SQL_Queries" ) ) {
            return null;
        }

        tcr.setConfidence( Integer.parseInt( getAttributeValue( "SeverityIndex", result) ) );
        
        tcr.setEvidence( getAttributeValue( "name", query ) );
 
        String testcase = getAttributeValue( "FileName", result );
        testcase = testcase.substring( testcase.lastIndexOf('/') +1);
        if ( testcase.startsWith( "BenchmarkTest" ) ) {
            String testno = testcase.substring( "BenchmarkTest".length(), testcase.length() -5 );
            try {
                tcr.setNumber( Integer.parseInt( testno ) );
            } catch ( NumberFormatException e ) {
                e.printStackTrace();
            }
            return tcr;
        }
        
        return null;
    }

    private int translate(int cwe) {
        switch( cwe ) {
            case 77 :   return 78;   // command injection
            case 36 :   return 22;   // path traversal
            case 23 :   return 22;   // path traversal
            case 338:   return 330;  // weak random
        }
        return cwe;
    }
}
