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
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class ZapReader extends Reader {

    public TestResults parse(File f) throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        InputSource is = new InputSource( new FileInputStream(f) );
        Document doc = docBuilder.parse(is);
 
        TestResults tr = new TestResults( "OWASP ZAP", false, TestResults.ToolType.DAST);
        
        // If the filename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.xml), set the compute time on the score card.
        tr.setTime(f);

        Node zap = doc.getDocumentElement();
        String version = getAttributeValue( "version", zap );
        tr.setToolVersion( version );
        
        List<Node> siteList = getNamedChildren( "site", zap );
        List<Node> alertsList = getNamedChildren( "alerts", siteList );
        List<Node> issueList = getNamedChildren( "alertitem", alertsList );
        
        for ( Node flaw : issueList ) {
            try {
                TestCaseResult tcr = parseZapIssue(flaw);
                if (tcr != null ) {
                    // System.out.println( tcr.getNumber() + " " + tcr.getName() + " -> " + tcr.getCWE() + "\t" + tcr.getEvidence() );
                    tr.put(tcr);
                }
            } catch( Exception e ) {
                // print and continue
                e.printStackTrace();
            }
        }
        return tr;
    }
    
//    <OWASPZAPReport generated="Thu, 2 Jul 2015 15:59:49" version="2.4.0">
//    <site host="localhost" name="http://localhost:8080" port="8080" ssl="false">
//        
//    <alerts>
//        
//    <alertitem>
//      <pluginid>10016</pluginid>
//      <alert>Web Browser XSS Protection Not Enabled</alert>
//      <riskcode>1</riskcode>
//      <confidence>2</confidence>
//      <riskdesc>Low (Medium)</riskdesc>
//      <desc>Web Browser XSS Protection is not enabled, or is disabled by the configuration of the 'X-XSS-Protection' HTTP response header on the web server
//        </desc>
//    <uri>http://localhost:8080/benchmark/BenchmarkTest00028.html</uri>
//      <param/>
//      <attack/>
//      <otherinfo>The X-XSS-Protection HTTP response header allows the web server to enable or disable the web browser's XSS protection mechanism. The following values would attempt to enable it: 
//      <solution>Ensure that the web browser's XSS filter is enabled, by setting the X-XSS-Protection HTTP response header to '1'.
//        </solution>
//      <otherinfo>The X-XSS-Protection HTTP response header allows the web server to enable or disable the web browser's XSS protection mechanism. The following values would attempt to enable it: 
//        X-XSS-Protection: 1; mode=block
//        </otherinfo>
//      <reference>https://www.owasp.org/index.php/XSS_(Cross_Site_Scripting)_Prevention_Cheat_Sheet
//        https://blog.veracode.com/2014/03/guidelines-for-setting-security-headers/
//        </reference>
//      <cweid>933</cweid>
//      <wascid>14</wascid>
//    </alertitem>
    
    
    
    private TestCaseResult parseZapIssue(Node flaw) throws URISyntaxException {
        TestCaseResult tcr = new TestCaseResult();
        Node rule = getNamedChild("cweid", flaw);
        if ( rule != null ) {
            tcr.setCWE( cweLookup( rule.getTextContent() ) );
        }
        
        String cat = getNamedChild("alert", flaw).getTextContent();
        tcr.setCategory( cat );
 
        String conf = getNamedChild( "confidence", flaw ).getTextContent();
        tcr.setConfidence( Integer.parseInt( conf ) );

        tcr.setEvidence( cat );

        String uri = getNamedChild( "uri", flaw ).getTextContent();
        URI url = new URI( uri );
        String testfile = url.getPath();
        testfile = testfile.substring( testfile.lastIndexOf('/') +1 );
       
        if ( testfile.startsWith( "BenchmarkTest" ) ) {
            String testno = testfile.substring("BenchmarkTest".length());
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
    
    