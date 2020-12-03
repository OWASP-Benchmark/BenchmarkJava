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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;

public class HCLReader extends Reader {

	public static void main(String[] args) throws Exception {
		File f = new File("results/HCL-IAST.hcl");
		HCLReader cr = new HCLReader();
		cr.parse(f);
	}

	
	public TestResults parse(File f) throws Exception {
		TestResults tr = new TestResults("HCL IAST", true, TestResults.ToolType.IAST);

		BufferedReader reader = new BufferedReader(new FileReader(f));
		String firstLine = null;
		String lastLine = "";
		String line = "";
		tr.setToolVersion("1.0");
		while (line != null) {
			try {
				line = reader.readLine();
				if (line != null) {
					if (line.contains("writeVulnerabilityToFile")) {
						parseFindings(tr, line);
					} else if (line.contains("Agent Version:")) {
						String version = line.substring(line.indexOf("Version:") + 8);
						tr.setToolVersion(version.trim());
						// TODO: expand length of "00001" to match length of TESTIDLENGTH rather than exactly 5
					} else if (line.contains("[checking URL:") &&
								line.contains(BenchmarkScore.TESTCASENAME+"00001")) {
						firstLine = line;
					} else if (line.contains("[checking URL:")) {
						lastLine = line;
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		reader.close();
		tr.setTime(calculateTime(firstLine, lastLine));
		return tr;
	}


    private void parseFindings(TestResults tr, String json) throws Exception {
        TestCaseResult tcr = new TestCaseResult();
        
        try {
			String splitJson = json.substring(json.indexOf("{"));
			JSONObject obj = new JSONObject(splitJson);
			JSONObject result = obj.getJSONArray("issue-group").getJSONObject(0);
			
	        String ruleId = result.getJSONObject("issue-type").getString( "ref" );
	        tcr.setCWE(cweLookup(ruleId));
	        tcr.setCategory(ruleId);
	
	        JSONObject request = result.getJSONArray("variant-group").getJSONObject(0).getJSONObject("request");
            String uri = request.getString("uri" );
        
	        if ( uri.contains( BenchmarkScore.TESTCASENAME ) ) {
		        String testNumber = uri.substring( uri.lastIndexOf('/') + BenchmarkScore.TESTCASENAME.length() + 1 );
	            tcr.setNumber(Integer.parseInt(testNumber));
		        if (tcr.getCWE() != 0) {
		            // System.out.println( tcr.getNumber() + "\t" + tcr.getCWE() + "\t" + tcr.getCategory() );
		            tr.put(tcr);
		        }
	        }
        } catch (Exception e) {
            // System.err.println("> Parse error: " + json);
            // e.printStackTrace();
        }
    }

    
	private static int cweLookup(String rule) {
		switch (rule) {
		case "SessionManagement.Cookies":
			return 614; // insecure cookie use
		case "Injection.SQL":
			return 89; // sql injection
		case "Injection.OS":
			return 78; // command injection
		case "Injection.LDAP":
			return 90; // ldap injection
		case "CrossSiteScripting.Reflected":
			return 79; // xss
		case "Injection.XPath":
			return 643; // xpath injection
		case "PathTraversal":
			return 22; // path traversal
		case "Cryptography.Mac":
			return 328; // weak hash
		case "Cryptography.PoorEntropy":
			return 330; // weak random
		case "Cryptography.Ciphers":
			return 327; // weak encryption
		case "Validation.Required":
			return 501; // trust boundary
		}
		return 0;
	}

	private String calculateTime(String firstLine, String lastLine) {
		try {
			String start = firstLine.split(" ")[0];
			String stop = lastLine.split(" ")[0];
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
			Date startTime = sdf.parse(start);
			Date stopTime = sdf.parse(stop);
			long startMillis = startTime.getTime();
			long stopMillis = stopTime.getTime();
			long seconds = (stopMillis - startMillis) / 1000;
			return seconds + " seconds";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
