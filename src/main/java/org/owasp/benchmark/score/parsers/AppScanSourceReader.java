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
* @created 2015
*/

package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class AppScanSourceReader extends Reader {

	// This is the original AppScan Source reader, when they generated ".ozasmt" files.

	public TestResults parse( File f ) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// Prevent XXE
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource( new FileInputStream(f) );
		Document doc = docBuilder.parse(is);
		
		Node root = doc.getDocumentElement();
		Map<Integer,String> vulns = parsePool( root, "StringPool", "id", "value", "Vulnerability." );
		//printPool( vulns );
		Map<Integer,String> file = parsePool( root, "FilePool", "id", "value", "" );
        Map<Integer,String> finding = parsePool( root, "FindingDataPool", "id", "vtype", "" );
        // Get the 'confidence' values for all the findings.
        Map<Integer,String> conf = parsePool( root, "FindingDataPool", "id", "conf", "" );
        // Following gets each finding's severity. Values 2, 1, 0. We tried filtering out Severity 0 or 0 & 1
        // but AppScan's score went down.
        //Map<Integer,String> sev = parsePool( root, "FindingDataPool", "id", "sev", "" );
		Map<Integer,Set<Integer>> assess = parseAssessments( root );

		TestResults tr = new TestResults( "IBM AppScan Source",true,TestResults.ToolType.SAST);

	    // <AssessmentRun name="webgoat-benchmark_3 - 5/18/15 12:01AM" version="9.0.1.0">
		String version = getAttributeValue( "version", root );
        tr.setToolVersion( version );

		List<Node> msgList = getNamedNodes( "Messages", root.getChildNodes() );
		List<Node> msgs = getNamedChildren( "Message", msgList );
		for ( Node node : msgs ) {
		    String message = node.getTextContent();
		    String prefix = "Elapsed Time - ";
		    if ( message != null && message.startsWith( prefix ) ) {
		        message = message.substring( prefix.length() );
		        tr.setTime( parseTime( message ) );
		    }
		}
		
		for ( int fileid : assess.keySet() ) {
			int tn = 0;
			String filename = file.get( fileid );
			filename = filename.replaceAll( "\\\\", "/");
			if ( filename.contains("/") ) {
				filename = filename.substring( filename.lastIndexOf('/') + 1);
			}
			if ( filename.endsWith( ".java" ) && filename.startsWith( BenchmarkScore.TESTCASENAME ) ) {
				filename = filename.substring( 0, filename.length() - 5 );
				String testnum = filename.substring( BenchmarkScore.TESTCASENAME.length() );
				tn = Integer.parseInt( testnum );
			}
			
			Set<Integer> findings = assess.get( fileid );
			for( int findingid : findings ) {
				TestCaseResult tcr = new TestCaseResult();
				tcr.setNumber( tn );
				int vid = Integer.parseInt( finding.get( findingid ) );
				String confString = conf.get( findingid );
				int confidence = Integer.parseInt( confString );
				
				String vtype = vulns.get( vid );
				tcr.setCategory( vtype );
				
				tcr.setCWE( cweLookup( vtype ) );
				tcr.setEvidence( vtype );
				tcr.setConfidence( confidence );
				
				// Exclude Confidence 3 - apparently these are "scan coverage"
				// We tried excluding Confidence 2 as well - as these are "suspect", but AppScan's score actually 
				// went down because it excludes ALL of the weak randomness findings.
				// Confidence 1 - are "definitive" findings
				if ( confidence < 3 ) {
				    tr.put(tcr);
				}
			}
		}
		return tr;
	}
	
	// e.g., 3 Hour(s) 7 Minute(s) 58 Second(s)
	private String parseTime(String message) {
	    String[] parts = message.split( "\\) ");
        String hours = parts[0].substring( 0, parts[0].indexOf(' ') ).trim();
        if ( hours.length() < 2 ) hours = "0" + hours;
        String mins = parts[1].substring( 0, parts[1].indexOf(' ') ).trim();
        if ( mins.length() < 2 ) mins = "0" + mins;
        String secs = parts[2].substring( 0, parts[2].indexOf(' ') ).trim();
        if ( secs.length() < 2 ) secs = "0" + secs;
	    return hours + ":" + mins + ":" + secs;
    }

/*    private static void printPool(Map<Integer, String> vulns) {
		for ( Map.Entry<Integer, String> e : vulns.entrySet() ) {
			System.out.println( "  " + e.getKey() + " :: " + e.getValue() );
		}		
	  }
*/
	private static int cweLookup(String vtype) {
		switch( vtype ) {
//		case "Vulnerability.AppDOS" : return 00;
//		case "Vulnerability.Authentication.Entity" : return 00;
		case "Vulnerability.Cryptography.InsecureAlgorithm" : return 327;
        case "Vulnerability.Cryptography.PoorEntropy" : return 330;
        case "Vulnerability.Cryptography.????WeakHash" : return 328;  // They don't have a weak hashing rule
//		case "Vulnerability.ErrorHandling.RevealDetails.Message" : return 00;
//		case "Vulnerability.ErrorHandling.RevealDetails.StackTrace" : return 00;
		case "Vulnerability.Injection.HttpResponseSplitting" : return 113;
		case "Vulnerability.Injection.LDAP" : return 90;
		case "Vulnerability.Injection.OS" : return 78;
		case "Vulnerability.Injection.SQL" : return 89;
		case "Vulnerability.Injection.XPath" : return 643;
//		case "Vulnerability.Malicious.DynamicCode" : return 00;
//		case "Vulnerability.Malicious.DynamicCode.Execution" : return 00;
		case "Vulnerability.PathTraversal" : return 22;
//		case "Vulnerability.Quality.TestCode" : return 00;
//		case "Vulnerability.Quality.Unsupported" : return 00;
		case "Vulnerability.SessionManagement.Cookies" : return 614;
		case "Vulnerability.Validation.EncodingRequired" : return 79;
		case "Vulnerability.Validation.Required" : return 501;
		}
	return 0;
	}

	/**
	 * Returns a list of finding_id's for each file_id 
	 * @param root
	 * @return
	 */
	private Map<Integer, Set<Integer>> parseAssessments(Node root) {
		Map<Integer,Set<Integer>> map = new TreeMap<Integer,Set<Integer>>();
		Node assess1 = getNamedNode( "Assessment", root.getChildNodes() );
		Node assess2 = getNamedNode( "Assessment", assess1.getChildNodes() );
		NodeList afiles = assess2.getChildNodes();
		for ( int i = 0; i < afiles.getLength(); i++ ) {
			Node afile = afiles.item(i);
			String fileid = getAttributeValue("file_id", afile );
			NodeList findings = afile.getChildNodes();
			for ( int j=0; j < findings.getLength(); j++ ) {
				Node finding = findings.item(j);
				if ( finding != null && finding.getNodeName().equals( "Finding" )) {
                    int findingid = Integer.parseInt(getAttributeValue( "data_id", finding ));                   
					int fileidint = Integer.parseInt( fileid);
					Set<Integer> findingSet = map.get( fileidint );
					if ( findingSet == null ) {
						findingSet = new HashSet<Integer>();
						map.put( fileidint, findingSet);
					}
					findingSet.add( findingid );
				}
			}
		}
		return map;
	}

	private Map<Integer,String> parsePool( Node root, String poolname, String keyname, String valuename, String prefix ) {
		Map<Integer,String> map = new TreeMap<Integer,String>();
		Node parent = getNamedNode( poolname, root.getChildNodes() );
		NodeList pool = parent.getChildNodes();
		for ( int i = 0; i < pool.getLength(); i++ ) {
			Node n = pool.item(i);
			String key = getAttributeValue( keyname, n );
			String value = getAttributeValue( valuename, n );
			if ( key != null && value != null && value.startsWith( prefix ) ) {
				map.put( Integer.parseInt(key), value );
			}
		}
		return map;
	}

}
