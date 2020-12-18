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
* @created 2020
*/

package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;

public class SonarQubeJsonReader extends Reader {

	public TestResults parse( File f ) throws Exception {

		TestResults tr = new TestResults( "SonarQube", false, TestResults.ToolType.SAST);

		// If the filename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.xml),
		// set the compute time on the score card.
		tr.setTime(f);

		String content = new String(Files.readAllBytes(Paths.get(f.getPath())));

		JSONObject obj = new JSONObject(content);
		// int version = obj.getInt( "formatVersion" );
		JSONArray arr;

		boolean hotSpotIssue = true;

		// Figure out if there are quality issues or security hotspots in the JSON file
		// Each has a different JSON format.
		try {
			arr = obj.getJSONArray("issues");
			hotSpotIssue = false;
		} catch (JSONException e) {
			try {
				arr = obj.getJSONArray("hotspots");
			} catch (JSONException e2) {
				System.out.println("ERROR: Couldn't find 'issues' or 'hotspots' element in SonarQube JSON results."
					+ " Maybe not SonarQube results file?" );
				return null;
			}
		}

		int numIssues = arr.length();
		for (int i = 0; i < numIssues; i++) {

			TestCaseResult tcr = (hotSpotIssue? parseSonarQubeHotSpotIssue( arr.getJSONObject(i) ) :
			                                    parseSonarQubeQualityIssue( arr.getJSONObject(i) ));
			if ( tcr != null ) {
				tr.put( tcr );
			}
		}

		return tr;
	}

	/** -- Example of Quality Issue JSON object
	VULNERABILITY",
	"tags":["cwe","owasp-a2","owasp-a6"],
	"component":"org.owasp:benchmark:src\/main\/java\/org\/owasp\/benchmark\/testcode\/BenchmarkTest02710.java",
	"flows":[],
	"textRange":{"endLine":63,"endOffset":34,"startOffset":28,"startLine":63},
	"debt":"5min","key":"AVvEV4Ovf4saFi7UxJTq","status":"OPEN"},

	{"severity":"CRITICAL",
	"updateDate":"2017-05-01T10:07:01-0400",
	"componentId":2777,
	"line":55,"author":"",
	"rule":"squid:S2076",
	"project":"org.owasp:benchmark",
	"effort":"30min",
	"message":"Make sure \"cmd\" is properly sanitized before use in this OS command.",
	"creationDate":"2017-05-01T10:07:01-0400",
	"type":"VULNERABILITY",
	"tags":["cwe","owasp-a1","sans-top25-insecure"],
	"component":"org.owasp:benchmark:src\/main\/java\/org\/owasp\/benchmark\/testcode\/BenchmarkTest02713.java",
	"flows":[],"textRange":{"endLine":55,"endOffset":26,"startOffset":22,"startLine":55},
	"debt":"30min","key":"AVvEV4Oyf4saFi7UxJTr","status":"OPEN"},

	**/

	// Quality Issues are normal SonarQube findings that are mostly not relevant to security
	// However, there are a small number of security issues that do show up this way so we have
	// to support both
	private TestCaseResult parseSonarQubeQualityIssue(JSONObject finding ) {
		try {
			TestCaseResult tcr = new TestCaseResult();
			String filename = null;

			filename = finding.getString("component");
			filename = filename.replaceAll( "\\\\", "/");
			filename = filename.substring( filename.lastIndexOf( '/' ) );
			if ( filename.contains( BenchmarkScore.TESTCASENAME ) ) {
				String testNumber = filename.substring( BenchmarkScore.TESTCASENAME.length() + 1,
						filename.length() - 5 );
				tcr.setNumber( Integer.parseInt( testNumber ) );
				String rule = finding.getString("rule");
				String squid = rule.substring( rule.indexOf(":") + 1 );
				if ( squid == null || squid.equals("none") ) {
					return null;
				}
				int cwe = SonarQubeReader.cweLookup(squid);
				tcr.setCWE( cwe );
				tcr.setCategory( finding.getJSONArray("tags").toString() );
				tcr.setEvidence( finding.getString("message") );
			}

			return tcr;
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

// The parseSonarQubeQualityIssue() method above relies on the SQUID # mapping method in SonarQubeReader.cweLookup()

	/** -- Example of HotSpot Issue JSON object
	"hotspots": [
	  {
		"key": "AXYEidyZsoEy1bftafT5",
		"component": "owasp-benchmark-sonarce:src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00008.java",
		"project": "owasp-benchmark-sonarce",
		"securityCategory": "sql-injection",
		"vulnerabilityProbability": "HIGH",
		"status": "TO_REVIEW",
		"line": 58,
		"message": "Ensure that string concatenation is required and safe for this SQL query.",
		"author": "dwichers@gmail.com",
		"creationDate": "2015-08-26T05:13:42+0200",
		"updateDate": "2020-11-26T12:53:38+0100"
	  },
	**/

	// Hotspot Issues are SonarQube security findings.
	private TestCaseResult parseSonarQubeHotSpotIssue(JSONObject finding ) {
		try {
			TestCaseResult tcr = new TestCaseResult();
			String filename = null;

			filename = finding.getString("component");
			filename = filename.replaceAll( "\\\\", "/"); // In case there are \ instead of / in the path
			filename = filename.substring( filename.lastIndexOf( '/' ) );
			if ( filename.contains( BenchmarkScore.TESTCASENAME ) ) {
				String testNumber = filename.substring( BenchmarkScore.TESTCASENAME.length() + 1,
						filename.length() - 5 );
				tcr.setNumber( Integer.parseInt( testNumber ) );
				String secCat = finding.getString("securityCategory");
				if ( secCat == null || secCat.equals("none") ) {
					return null;
				}
				int cwe = securityCategoryCWELookup(secCat, finding.getString("message"));
				tcr.setCWE( cwe );
				tcr.setCategory( secCat );
				tcr.setEvidence( "vulnerabilityProbability: " + finding.getString("vulnerabilityProbability") );
			}

			return tcr;
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Some of these findings are badly mapped. For example:
	 *      "securityCategory": "xss",
	 *      "message": "Make sure creating this cookie without the \"HttpOnly\" flag is safe.",
	 *  While HttpOnly is a feature to help defend against XSS, it should really be mapped to
	 *  CWE-1004: Sensitive Cookie Without 'HttpOnly' Flag. So we use the 'message' description
	 *            in some findings to move such issues to the 'right' CWE.
	 *  As such, we specifically look at the message in some cases to fix the mapping.
	 */
	public static int securityCategoryCWELookup(String secCat, String message) {
		// Not sure where to look up all the possible security categories in SonarQube, but the mappings
		// seem obvious enough.

		// Given their horrible mapping scheme, we check each message to detect whether their might be a new
		// 'message' mapped to an existing CWE (that might be wrong).
		if ( !("Make sure that using this pseudorandom number generator is safe here.".equals(message) ||
				"Ensure that string concatenation is required and safe for this SQL query.".equals(message) ||
				"Make sure creating this cookie without the \"secure\" flag is safe here.".equals(message) ||
				"Make sure that hashing data is safe here.".equals(message) ||
				"Make sure creating this cookie without the \"HttpOnly\" flag is safe.".equals(message)) )
		{
			System.out.println("WARN: Found new SonarQube HotSpot rule not seen before. Category: "
				+ secCat + " with message: '" + message + "'");
		}

		switch( secCat ) {

		case "sql-injection" : return 89;  // "Ensure that string concatenation is required and safe for this SQL query."
		case "insecure-conf" : return 614; // "Make sure creating this cookie without the \"secure\" flag is safe here."
		case "xss"           : // "Make sure creating this cookie without the \"HttpOnly\" flag is safe."
			{
				if (message != null && message.contains("HttpOnly")) return 1004;
				  else return 79; // Actual XSS CWE
			}
		case "weak-cryptography" : // "Make sure that using this pseudorandom number generator is safe here."
			{  // or "Make sure that hashing data is safe here."
				if (message != null) {
					if (message.contains("pseudorandom")) return 330;
					if (message.contains("hashing")) return 328;
					else return 0000;
				}
				  else return 327; // Actual Weak Crypto CWE
			}
		default: System.out.println( "WARN: Failed to translate SonarQube security category: " + secCat );
		}

		return -1;
	}

	// This parser relies on the SQUID # mapping method in SonarQubeReader.cweLookup()
}
