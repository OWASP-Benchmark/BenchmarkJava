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
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class ContrastReader extends Reader {
	
	public TestResults parse( File f ) throws Exception {
        TestResults tr = new TestResults( "Contrast" ,true,TestResults.ToolType.IAST);
        
        // If the filename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.xml), set the compute time on the score card.
        tr.setTime(f);
	    
	    ZipFile zf = new ZipFile( f );
	    Enumeration<? extends ZipEntry> e = zf.entries();
	    while ( e.hasMoreElements() ) {
	        try {
    	        ZipEntry ze = e.nextElement();
    	        String name = ze.getName();
    	        name = name.substring(name.lastIndexOf('/')+1);
    	        if ( name.startsWith( "TRACE" ) && name.endsWith(".xml") ) {
    	            InputStream is = zf.getInputStream( ze );
                    TestCaseResult tcr = process( tr, is );
                    if ( tcr != null ) {
//                        System.out.println( name + "\t" + tcr.getNumber() + "\t" + tcr.getCWE() + "\t" + tcr.getCategory() );
                        tr.put( tcr );
                    }
    	        }
	        } catch( Exception ex ) {
	            ex.printStackTrace();
	        }
	    }
	    return tr;
	}
	
	private TestCaseResult process( TestResults tr, InputStream stream ) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// Prevent XXE
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource( stream );
		Document doc = docBuilder.parse(is);
        Node finding = doc.getDocumentElement();
        return parseContrastReport( finding );
	}
	
    
//  <finding hash="475418310" platform="Oracle Corporation" ruleId="cache-controls-missing">
//  <props><data>[]</data></props>
//  <events></events>
//  <request method="GET" port="0" protocol="https" version="1.0" uri="/benchmark/Crawl.html" qs="">
//  <headers>
  
	private TestCaseResult parseContrastReport(Node n) {

        TestCaseResult tcr = new TestCaseResult();
        String rule = getAttributeValue("ruleId", n);
        if ( rule != null ) {
            tcr.setCWE( cweLookup( rule ) );
        }
        
        tcr.setCategory( rule );
 
        String hash = getAttributeValue("hash", n);
        tcr.setEvidence( hash );
        
        Node request = getNamedChild( "request", n );
        String uri = getAttributeValue("uri", request );
        if ( uri != null ) {
            String testfile = uri.substring( uri.lastIndexOf('/') +1 );
            
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
        }
        return null;
    }
	
	/**
	 * Find the frame that has the TestCase package in it.
	 * org.owasp.webgoat.benchmark.sqli.Test15.doPost(Test15.java:48)
	 * 
	 * FIXME: this will have to be changed for real testcases
	 */
	private String getFrameEntry( List<Node> frames ) {
	    String text = null;
	    for ( Node frame : frames ) {
	        text = frame.getTextContent();
	        if ( text.startsWith("org.owasp.benchmark.testcode.BenchmarkTest") ) {	            
	            text = text.substring( "org.owasp.benchmark.testcode.".length() );
	            // text = text.substring( 0, text.indexOf( ".doPost" ) );
	            return text;
	        }
	    }
        return null;
	}
	
	private static int cweLookup( String rule) {
		switch( rule ) {
		case "cookie-flags-missing"      : 	return 614;  // insecure cookie use
        case "sql-injection"             :  return 89;   // sql injection
        case "cmd-injection"             :  return 78;   // command injection
        case "ldap-injection"            :  return 90;   // ldap injection
        case "header-injection"          :  return 113;  // header injection
        case "hql-injection"             :  return 0000;      // hql injection
        case "unsafe-readline"           :  return 0000;      // unsafe readline
        case "reflection-injection"      :  return 0000;      // reflection injection
        case "reflected-xss"             :  return 79;   // xss
        case "xpath-injection"           :  return 643;  // xpath injection
		case "path-traversal"            : 	return 22;   // path traversal
		case "crypto-bad-mac"            : 	return 328;  // weak hash
        case "crypto-weak-randomness"    :  return 330;  // weak random
        case "crypto-bad-ciphers"        :  return 327;  // weak encryption
        case "trust-boundary-violation"  :  return 501;  // trust boundary
        case "xxe"                       :  return 611;  // xml entity
        }
		return 0;
	}

}
