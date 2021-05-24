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
 * PURPOSE. See the GNU General Public License for more details
 *
 * <p>This reader reads JSON reports from https://wapiti.sourceforge.io/
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

public class WapitiJsonReader extends Reader {

    public static boolean isWapitiReport(JSONObject json) {
        try {
            return json.getJSONObject("infos").getString("version").startsWith("Wapiti");
        } catch (Exception e) {
            return false;
        }
    }

    public static TestResults parse(JSONObject json) throws Exception {
        TestResults tr = new TestResults("Wapiti", false, TestResults.ToolType.DAST);

        JSONObject vulnerabilities = json.getJSONObject("vulnerabilities");

        Map<String, Integer> categoryCweMap = new HashMap<>();

        categoryCweMap.put("CRLF Injection", 93);
        categoryCweMap.put("Cross Site Request Forgery", 352);
        categoryCweMap.put("Command execution", 78); // aka command injection
        categoryCweMap.put("Path Traversal", 22);
        categoryCweMap.put("Secure Flag cookie", 614);
        categoryCweMap.put("SQL Injection", 89);
        categoryCweMap.put("Cross Site Scripting", 79);

        for (Map.Entry<String, Integer> entry : categoryCweMap.entrySet()) {
            String category = entry.getKey();
            Integer cwe = entry.getValue();

            JSONArray arr = vulnerabilities.getJSONArray(category);

            for (int i = 0; i < arr.length(); i++) {
                TestCaseResult tcr = parseTestCaseResult(arr.getJSONObject(i), cwe);
                if (tcr != null) {
                    tr.put(tcr);
                }
            }
        }

        return tr;
    }

    private static TestCaseResult parseTestCaseResult(JSONObject finding, Integer cwe) {
        try {
            TestCaseResult tcr = new TestCaseResult();

            String filename = filename(finding);

            if (filename.contains(BenchmarkScore.TESTCASENAME)) {
                tcr.setNumber(testNumber(filename));
                tcr.setCWE(cwe);
            }

            return tcr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String filename(JSONObject finding) {
        return new File(finding.getString("path")).getName();
    }

    private static int testNumber(String filename) {
        return Integer.parseInt(filename.substring(BenchmarkScore.TESTCASENAME.length() + 1));
    }
}
