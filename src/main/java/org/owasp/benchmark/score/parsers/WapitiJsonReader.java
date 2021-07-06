/**
 * OWASP Benchmark Project
 *
 * <p>This file is part of the Open Web Application Security Project (OWASP) Benchmark Project For
 * details, please see <a
 * href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 *
 * <p>The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * <p>The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details.
 *
 * <p>This reader reads JSON reports from the Wapiti open source tool at:
 * https://wapiti.sourceforge.io/
 *
 * @author Sascha Knoop
 * @created 2021
 */
package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;
import org.owasp.benchmark.score.TestCaseResult;
import org.owasp.benchmark.score.TestSuiteResults;

public class WapitiJsonReader extends Reader {

    public static boolean isWapitiReport(JSONObject json) {
        try {
            return json.getJSONObject("infos").getString("version").startsWith("Wapiti");
        } catch (Exception e) {
            return false;
        }
    }

    public static TestSuiteResults parse(JSONObject json) throws Exception {
        TestSuiteResults tr = new TestSuiteResults("Wapiti", false, TestSuiteResults.ToolType.DAST);

        JSONObject vulnerabilities = json.getJSONObject("vulnerabilities");

        Map<String, Integer> categoryCweMap = new HashMap<>();

        categoryCweMap.put("CRLF Injection", 93);
        categoryCweMap.put("Cross Site Request Forgery", 352);
        categoryCweMap.put("Command execution", 78); // aka command injection
        categoryCweMap.put("Path Traversal", 22);
        categoryCweMap.put("Secure Flag cookie", 614);
        categoryCweMap.put("Blind SQL Injection", 89);
        categoryCweMap.put("SQL Injection", 89);
        categoryCweMap.put("Cross Site Scripting", 79);
        categoryCweMap.put("XML External Entity", 611);

        // Add others we don't currently care about, to make sure that all findings are considered,
        // and no new finding types are ignored
        // It is possible we'd care about some of these in the future
        categoryCweMap.put("Content Security Policy Configuration", 1021);
        categoryCweMap.put("Open Redirect", 601);
        categoryCweMap.put("Server Side Request Forgery", 918);
        categoryCweMap.put("Backup file", 0);
        categoryCweMap.put("Fingerprint web application framework", 0);
        categoryCweMap.put("Fingerprint web server", 0);
        categoryCweMap.put("Htaccess Bypass", 0);
        categoryCweMap.put("HTTP Secure Headers", 0);
        categoryCweMap.put("HttpOnly Flag cookie", 1004);
        categoryCweMap.put("Potentially dangerous file", 0);
        categoryCweMap.put("Weak credentials", 0);

        for (Map.Entry<String, Integer> entry : categoryCweMap.entrySet()) {
            String category = entry.getKey();
            Integer cwe = entry.getValue();

            // The following gets all the vulnerabilities reported for the specified category
            // JSONArray arr = vulnerabilities.getJSONArray(category);
            JSONArray arr = (JSONArray) vulnerabilities.remove(category);

            // This then goes through all those results and adds every finding of that type reported
            // within a specified test case file
            if (arr != null) {
                for (int i = 0; i < arr.length(); i++) {
                    TestCaseResult tcr = parseTestCaseResult(arr.getJSONObject(i), cwe);
                    if (tcr != null) {
                        tr.put(tcr);
                    }
                }
            }
        }

        // Now check to see if there are extra vulnerability types not yet mapped
        if (!vulnerabilities.isEmpty()) {
            for (String key : vulnerabilities.keySet()) {
                System.out.println("Mapping missing for vulnerability category: " + key);
            }
        }

        tr.setToolVersion(readVersion(json));

        return tr;
    }

    private static TestCaseResult parseTestCaseResult(JSONObject finding, Integer cwe) {
        try {
            String filename = getFilenameFromFinding(finding);

            if (filename.contains(BenchmarkScore.TESTCASENAME)) {
                TestCaseResult tcr = new TestCaseResult();
                tcr.setNumber(testNumber(filename));
                tcr.setCWE(cwe);
                return tcr;
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getFilenameFromFinding(JSONObject finding) {
        return new File(finding.getString("path")).getName();
    }

    private static int testNumber(String filename) {
        return Integer.parseInt(filename.substring(BenchmarkScore.TESTCASENAME.length() + 1));
    }

    private static String readVersion(JSONObject json) {
        return json.getJSONObject("infos").getString("version").substring("Wapiti ".length());
    }
}
