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
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class ArachniReader extends Reader {

//    <report xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="https://raw.githubusercontent.com/Arachni/arachni/v2.0dev/components/reporters/xml/schema.xsd">
//    <version>2.0dev</version>
//    <start_datetime>2015-08-17T14:21:14+03:00</start_datetime>
//    <finish_datetime>2015-08-17T14:44:14+03:00</finish_datetime>
//    <sitemap>    
    
    
    public TestResults parse(File f) throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// Prevent XXE
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        InputSource is = new InputSource( new FileInputStream(f) );
        Document doc = docBuilder.parse(is);
 
        TestResults tr = new TestResults( "Arachni", false, TestResults.ToolType.DAST);
        
        Node arachni = doc.getDocumentElement();
        String version = getNamedChild( "version", arachni ).getTextContent();
        tr.setToolVersion( version );
        
        String start = getNamedChild( "start_datetime", arachni ).getTextContent();
        String stop = getNamedChild( "finish_datetime", arachni ).getTextContent();
        tr.setTime( calculateTime( start, stop ));

        Node issues = getNamedChild( "issues", arachni );
        List<Node> issueList = getNamedChildren( "issue", issues );
        
        for ( Node issue : issueList ) {
            try {
                TestCaseResult tcr = parseArachniIssue(issue);
                if (tcr != null ) {
//                 System.out.println( tcr.getNumber() + " " + tcr.getName() + " -> " + tcr.getCWE() + "\t" + tcr.getEvidence() );
                    tr.put(tcr);
                }
            } catch( Exception e ) {
                // print and continue
                e.printStackTrace();
            }
        }
        return tr;
    }
    
//    <issue>
//    <name>Cross-Site Scripting (XSS)</name>
//    <description>
//Client-side scripts are used extensively by modern web applications.
//</description>
//    <remedy_guidance>
//</remedy_guidance>
//    <remedy_code/>
//    <severity>high</severity>
//    <check>
//      <name>XSS</name>
//      <description>
//Injects an HTML element into page inputs and then parses the HTML markup of
//</description>
//      <author>Tasos "Zapotek" Laskos &lt;tasos.laskos@arachni-scanner.com&gt; </author>
//      <version>0.4.4</version>
//      <shortname>xss</shortname>
//    </check>
//    <cwe>79</cwe>
//    <digest>3396861445</digest>
//    <references>
//    </references>
//    <vector>
//      <class>Arachni::Element::Form</class>
//      <type>form</type>
//      <url>https://127.0.0.2:8443/benchmark/BenchmarkTest00397.html</url>
//      <action>https://127.0.0.2:8443/benchmark/BenchmarkTest00397</action>
//      <source>/form&gt;</source>
//      <method>post</method>
//      <affected_input_name>vector</affected_input_name>
//      <inputs>
//        <input name="vector" value="Singing"/>
//        <input name="foo" value="bar"/>
//      </inputs>
//    </vector>
//  </issue>
    
    // 2015-08-17T14:21:14+03:00    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    private String calculateTime(String submitted, String published) {
        try {
            long start = sdf.parse( submitted ).getTime();
            long finish = sdf.parse( published ).getTime();
            return TestResults.formatTime( finish - start );
        } catch( Exception e ) {
            e.printStackTrace();
            return "Unknown";
        }
    }
    
    
    
    private TestCaseResult parseArachniIssue(Node flaw) throws URISyntaxException {
        TestCaseResult tcr = new TestCaseResult();
        Node rule = getNamedChild("cwe", flaw);
        if ( rule != null ) {
            tcr.setCWE( cweLookup( rule.getTextContent() ) );
        }
        
        String cat = getNamedChild("name", flaw).getTextContent();
        tcr.setCategory( cat );

        // not used
        String conf = getNamedChild( "severity", flaw ).getTextContent();
        
        // confidence not available
        // tcr.setConfidence( Integer.parseInt( conf ) );

        tcr.setEvidence( cat );

        Node vector = getNamedChild( "vector", flaw );
        String uri = getNamedChild( "url", vector ).getTextContent();
        URI url = new URI( uri );
        String testfile = url.getPath();
        testfile = testfile.substring( testfile.lastIndexOf('/') +1 );
       
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

    
    private int cweLookup(String orig) {   
        
        switch( orig ) {       
        }
        
        return Integer.parseInt( orig );
    }
    
}
    
    