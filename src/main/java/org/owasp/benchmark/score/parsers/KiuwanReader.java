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
* @created 2019
*/

package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;

public class KiuwanReader extends Reader {
	
	public TestResults parse( File f ) throws Exception {
		String content = new String(Files.readAllBytes(Paths.get(f.getPath())));

		/*
		 * This parser was written against the .threadfix schema as defined here:
		 * https://denimgroup.atlassian.net/wiki/spaces/TDOC/pages/496009270/ThreadFix+File+Format
		 * 
		 * To make any JSON file more readable: python -m json.tool file.json > prettyjson.txt
		 */
		JSONObject obj = new JSONObject(content);
//		String resultsFormatVersion = obj.getString( "version" ); // Note: no threadfix version info included in format.

		JSONArray findings = obj.getJSONArray("findings");
		JSONObject metadata = obj.getJSONObject("metadata");
		
		String source = obj.getString("source");

		TestResults tr = new TestResults(source, true, TestResults.ToolType.SAST);
		
		// Scan time is included in the threadfix schema: "metadata/Kiuwan-AnalysisDuration"
		if (null != metadata) {
			String analysisDuration = metadata.getString("Kiuwan-AnalysisDuration");
			if (null != analysisDuration) {
				tr.setTime(analysisDuration);
			}
		}

		// Set the version of Kiuwan used to do the scan: "metadata/Kiuwan-EngineVersion"
		if (null != metadata) {
			String engineVersion = metadata.getString("Kiuwan-EngineVersion");
			if (null != engineVersion) {
				tr.setToolVersion(engineVersion);
			}
		}

		//System.out.println("Found: " + findings.length() + " findings.");
		for (int i = 0; i < findings.length(); i++)
		{
			JSONObject finding = findings.getJSONObject(i);
			
			TestCaseResult tcr = parseKiuwanFinding( finding );
			if ( tcr != null ) {
				tr.put( tcr );
			}					
		}
		
		return tr;
	}

	private TestCaseResult parseKiuwanFinding(JSONObject finding) {
		try {
			TestCaseResult tcr = new TestCaseResult();
			JSONObject staticDetails = finding.getJSONObject("staticDetails");		
			JSONArray dataFlow = staticDetails.getJSONArray("dataFlow");	
			int propagationPathLength = dataFlow.length()-1;
			String filename = dataFlow.getJSONObject(propagationPathLength).getString("file");
			filename = filename.substring( filename.lastIndexOf( '/' ) );
			if ( filename.contains( BenchmarkScore.TESTCASENAME ) ) {
				String testNumber = filename.substring( BenchmarkScore.TESTCASENAME.length() + 1, filename.length() - 5 );
				tcr.setNumber( Integer.parseInt( testNumber ) );
				
				int cwe = -1;
				try {
					JSONArray mappings = finding.getJSONArray("mappings");
					for (int i = 0; i < mappings.length(); i++) {
						String val = mappings.getJSONObject(i).getString("mappingType");
						if (val.equalsIgnoreCase("CWE")) {
							// fixCWE maps the supplied CWE to the one we use, if necessary
							cwe = fixCWE( mappings.getJSONObject(i).getString("value") );
							break;
						}
					}
					
				} catch (Exception e ) {
					e.printStackTrace();
				}

				if (cwe != -1) {
					//System.out.println("Found finding in: " + testNumber + " of cwe type: " + cwe);					
					tcr.setCWE( cwe );
					tcr.setCategory( finding.getString("summary") );
					tcr.setEvidence( finding.getString("scannerDetail") );
				} //else System.out.println("ERROR: Finding in: " + testNumber + " included no CWE number.");

			}
			return tcr;
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	private int fixCWE( String cweNumber ) {
		int cwe = Integer.parseInt( cweNumber );
		if ( cwe == 564 ) cwe = 89; // SQLi
		if ( cwe == 77 ) cwe = 78;  // Command Injection
		return cwe;
	}
}
