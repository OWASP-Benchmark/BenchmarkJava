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
		String content = new String(Files.readAllBytes(Paths.get(f.getPath())));

		JSONObject obj = new JSONObject(content);
		// int version = obj.getInt( "formatVersion" );
		JSONArray arr;
		try {
			arr = obj.getJSONArray("issues");
		} catch (JSONException e) {
			System.out.println("ERROR: Couldn't find 'issues' element in SonarQube JSON results."
				+ " Maybe not SonarQube results file?" );
			return null;
		}

		TestResults tr = new TestResults( "SonarJava", false, TestResults.ToolType.SAST);

		// If the filename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.xml),
		// set the compute time on the score card.
		tr.setTime(f);

		int numIssues = arr.length();
		for (int i = 0; i < numIssues; i++)
		{
			TestCaseResult tcr = parseSonarQubeFinding( arr.getJSONObject(i) );
			if ( tcr != null ) {
				tr.put( tcr );
			}
		}

		return tr;
	}

	/**
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

	private TestCaseResult parseSonarQubeFinding(JSONObject finding ) {
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

	// This parser relies on the SQUID # mapping method in SonarQubeReader.cweLookup()
}
