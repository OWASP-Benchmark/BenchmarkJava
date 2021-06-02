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
 * <p>This reader reads JSON reports from ZAP open source tool at:
 * https://github.com/zaproxy/zaproxy
 *
 * @author Sascha Knoop
 * @created 2021
 */
package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;
import org.owasp.benchmark.score.TestCaseResult;
import org.owasp.benchmark.score.TestSuiteResults;

public class ZapJsonReader extends Reader {

    private static final String[] expectedVulnerabilityKeys = {
        "sourceid", "other", "method", "evidence", "pluginId", "cweid", "confidence", "wascid"
    };

    public static boolean isZapReport(JSONObject json) {
        try {
            return hasExpectedKeys(json.getJSONArray("vulnerabilities").getJSONObject(0));
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean hasExpectedKeys(JSONObject vulnerability) {
        for (String key : expectedVulnerabilityKeys) {
            if (!vulnerability.has(key)) {
                return false;
            }
        }

        return true;
    }

    public TestSuiteResults parse(JSONObject json) throws Exception {
        TestSuiteResults tr =
                new TestSuiteResults("OWASP ZAP", false, TestSuiteResults.ToolType.DAST);

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
            TestCaseResult tcr = new TestCaseResult();

            String filename = filename(finding);

            if (filename.contains(BenchmarkScore.TESTCASENAME)) {
                tcr.setNumber(testNumber(filename));

                tcr.setCWE(figureCwe(finding));
            }

            return tcr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String filename(JSONObject finding) {
        String fullUrl = finding.getString("url");

        try {
            // get rid of everything except the test name
            return new File(new URL(fullUrl).getPath()).getName().replace(".html", "");
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private int testNumber(String filename) {
        return Integer.parseInt(filename.substring(BenchmarkScore.TESTCASENAME.length() + 1));
    }

    private int figureCwe(JSONObject finding) {
        String cwe = finding.getString("cweid");

        switch (cwe) {
            case "22":
                return 22; // path traversal
            case "79":
                return 79; // XSS
            case "89":
                return 89; // SQL injection

            default:
                System.out.println(
                        "INFO: Found following CWE which we haven't seen before: " + cwe);
                return Integer.parseInt(cwe);
        }
    }
}
