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
 * <p>This reader reads JSON reports from https://github.com/insidersec/insider
 *
 * @author Sascha Knoop
 * @created 2021
 */
package org.owasp.benchmark.score.parsers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;

public class InsiderReader {

    private static final String[] expectedVulnerabilityKeys = {
        "cvss", "cwe", "line", "class", "vul_id", "method", "column", "description"
    };

    public static boolean isInsiderReport(final JSONObject json) {
        return json.has("vulnerabilities")
                && hasExpectedKeys(json.getJSONArray("vulnerabilities").getJSONObject(0));
    }

    private static boolean hasExpectedKeys(JSONObject vulnerability) {
        for (String key : expectedVulnerabilityKeys) {
            if (!vulnerability.has(key)) {
                return false;
            }
        }

        return true;
    }

    public TestResults parse(JSONObject json) throws Exception {
        TestResults tr = new TestResults("Insider", false, TestResults.ToolType.SAST);

        JSONArray arr = json.getJSONArray("vulnerabilities");

        for (int i = 0; i < arr.length(); i++) {
            TestCaseResult tcr = parseTestCaseResult(arr.getJSONObject(i));
            if (tcr != null) {
                tr.put(tcr);
            }
        }

        return tr;
    }

    private TestCaseResult parseTestCaseResult(JSONObject finding) {
        try {
            String filename = filename(finding);

            if (filename.contains(BenchmarkScore.TESTCASENAME)) {
                TestCaseResult tcr = new TestCaseResult();

                tcr.setNumber(testNumber(filename));
                int cwe = cweNumber(finding);
                tcr.setCWE(cwe);

                return tcr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private int cweNumber(JSONObject finding) {
        String cwe = finding.getString("cwe").substring(4);

        switch (cwe) {
            case "78":
                return 78; // command injection
            case "326":
            case "327":
                return 327; // weak encryption DES
            case "330":
                return 330; // weak random
            case "532":
                return 532; // sensitive log

            default:
                System.out.println(
                        "INFO: Found following CWE which we haven't seen before: " + cwe);
                return Integer.parseInt(cwe);
        }
    }

    private int testNumber(String filename) {
        return Integer.parseInt(
                filename.substring(
                        BenchmarkScore.TESTCASENAME.length() + 1, filename.length() - 5));
    }

    private String filename(JSONObject vuln) {
        String className = vuln.getString("class");
        return className.substring(0, className.indexOf(' '));
    }
}
