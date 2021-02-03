/**
 * OWASP Benchmark Project
 * <p>
 * This file is part of the Open Web Application Security Project (OWASP)
 * Benchmark Project For details, please see
 * <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 * <p>
 * The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 * <p>
 * The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details
 *
 * @author Dave Wichers
 * @author Nipuna Weerasekara
 * @created 2021
 */

package org.owasp.benchmark.score.parsers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class CodeQLReader extends Reader {

	public TestResults parse(File f) throws Exception {
		String content = new String(Files.readAllBytes(Paths.get(f.getPath())));

		/*
		 * This parser was written against version 2.1.0 of the sarif-schema
		 * NOTE: To help understand contents of JSON file, use: http://jsonviewer.stack.hu to view it.
		 */
		JSONObject obj = new JSONObject(content);
//		String resultsFormatVersion = obj.getString( "version" ); // Might be needed in future if format changes

		JSONArray runs = obj.getJSONArray("runs");

		TestResults tr = new TestResults("CodeQL", false, TestResults.ToolType.SAST);
		// Scan time is not included in the sarif-schema. But scan time is provided on their web site next to results
		tr.setTime(f);  // This grabs the scan time out of the filename, if provided
		// e.g., Benchmark_1.2-CodeQL-v2.4.1-840.sarif, means the scan took 840 seconds.

		for (int i = 0; i < runs.length(); i++) {
			// There are 1 or more runs in each results file, one per language found (Java, JavaScript, etc.)
			JSONObject run = runs.getJSONObject(i);

			// First, set the version of LGTM used to do the scan
			JSONObject driver = run.getJSONObject("tool").getJSONObject("driver");
			tr.setToolVersion(driver.getString("semanticVersion"));

			// Then, identify all the rules that report results and which CWEs they map to
			JSONArray rules = driver.getJSONArray("rules");
			//System.out.println("Found: " + rules.length() + " rules.");
			HashMap<String, Integer> rulesUsed = parseLGTMRules(rules);
			//System.out.println("Parsed: " + rulesUsed.size() + " rules.");

			// Finally, parse out all the results
			JSONArray results = run.getJSONArray("results");
			//System.out.println("Found: " + results.length() + " results.");

			for (int j = 0; j < results.length(); j++) {
				TestCaseResult tcr = parseLGTMFinding(results.getJSONObject(j), rulesUsed); //, version );
				if (tcr != null) {
					tr.put(tcr);
				}
			}

		}

		return tr;
	}

	private static final String LGTMCWEPREFIX = "external/cwe/cwe-";
	private static final int LGTMCWEPREFIXLENGTH = LGTMCWEPREFIX.length();

	private HashMap<String, Integer> parseLGTMRules(JSONArray rulesJSON) {

		HashMap<String, Integer> rulesUsed = new HashMap<String, Integer>();

		for (int j = 0; j < rulesJSON.length(); j++) {
			JSONObject ruleJSON = rulesJSON.getJSONObject(j);

			try {
				String ruleName = ruleJSON.getString("name");
				JSONArray tags = ruleJSON.getJSONObject("properties").getJSONArray("tags");
				for (int i = 0; i < tags.length(); i++) {
					String val = tags.getString(i);
					if (val.startsWith(LGTMCWEPREFIX)) {
//						System.out.println("Rule found for CWE: " + Integer.parseInt(val.substring(LGTMCWEPREFIXLENGTH)));
//						int cwe = fixCWE( cweNumber );
						rulesUsed.put(ruleName, Integer.parseInt(val.substring(LGTMCWEPREFIXLENGTH)));
						break; // Break out of for loop because we only want to use the first CWE it is mapped to
						// currently. If they add rules where the first CWE is not the preferred one, then we need
						// to implement fixCWE() and invoke it (commented out example below)
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rulesUsed;
	}

	private TestCaseResult parseLGTMFinding(JSONObject finding, HashMap<String, Integer> rulesUsed) {
		try {
			TestCaseResult tcr = new TestCaseResult();
			String filename = null;
			JSONArray locations = finding.getJSONArray("locations");
			filename = locations.getJSONObject(0).getJSONObject("physicalLocation")
					.getJSONObject("artifactLocation").getString("uri");
			filename = filename.substring(filename.lastIndexOf('/'));
			if (filename.contains(BenchmarkScore.TESTCASENAME)) {
				String testNumber = filename.substring(BenchmarkScore.TESTCASENAME.length() + 1, filename.length() - 5);
				tcr.setNumber(Integer.parseInt(testNumber));
				String ruleId = finding.getString("ruleId");
				Integer cweForRule = rulesUsed.get(ruleId);
//				System.out.println("Found finding in: " + testNumber + " of type: " + ruleId + " CWE: " + cweForRule);
				if (cweForRule == null) {
					return null;
				}
				if (locations.length() > 1) {
					System.out.println("Unexpectedly found more than one location for finding against rule: " + ruleId);
				}
				int cwe = cweForRule.intValue();
				tcr.setCWE(cwe);
//				tcr.setCategory( props.getString( "subcategoryShortDescription" ) ); // Couldn't find any Category info in results file
				tcr.setEvidence(finding.getJSONObject("message").getString("text"));
			}
			return tcr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

/*
	private int fixCWE( String cweNumber ) {
		int cwe = Integer.parseInt( cweNumber );
		if ( cwe == 94 ) cwe = 643;
		if ( cwe == 36 ) cwe = 22;
		if ( cwe == 23 ) cwe = 22;
		return cwe;
	}
*/
}
