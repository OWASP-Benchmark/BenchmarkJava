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
 * @author Nacho Guisado Obregón, Dave Wichers
 * @created 2020
 */
package org.owasp.benchmark.score.parsers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;

public class SemgrepReader {
    public TestResults parse(JSONObject jsonResults) {
        TestResults tr = new TestResults("Semgrep", false, TestResults.ToolType.SAST);

        JSONArray results = jsonResults.getJSONArray("results");

        // results
        for (int i = 0; i < results.length(); i++) {
            TestCaseResult tcr = parseSemgrepFindings(results.getJSONObject(i));
            if (tcr != null) {
                tr.put(tcr);
            }
        }
        return tr;
    }

    private int translate(int cwe) {
        switch (cwe) {
            case 78:
                return 78; // command injection
            case 89:
                return 89; // sql injection
            case 90:
                return 90; // LDAP injection
            case 326:
            case 327:
            case 696:
                return 327; // Broken or Risky Cryptographic Algorithm
            case 352:
                return 352; // Cross-Site Request Forgery
            case 614:
            case 1004:
                return 614; // insecure cookie use
            default:
                System.out.println(
                        "INFO: Found following CWE which we haven't seen before: " + cwe);
                return cwe;
        }
    }

    private TestCaseResult parseSemgrepFindings(JSONObject result) {
        try {
            String className = result.getString("path");
            className = (className.substring(className.lastIndexOf('/') + 1)).split("\\.")[0];

            if (className.startsWith(BenchmarkScore.TESTCASENAME)) {
                TestCaseResult tcr = new TestCaseResult();

                JSONObject extra = result.getJSONObject("extra");
                JSONObject metadata = extra.getJSONObject("metadata");

                // CWE
                int cwe = Integer.parseInt(metadata.getString("cwe").split(":")[0].split("-")[1]);
                try {
                    cwe = translate(cwe);
                } catch (NumberFormatException ex) {
                    System.out.println("CWE # not parseable from: " + metadata.getString("cwe"));
                }

                // category
                String category = metadata.getString("owasp");

                // evidence
                String evidence = result.getString("check_id");

                tcr.setCWE(cwe);
                tcr.setCategory(category);
                tcr.setEvidence(evidence);
                tcr.setConfidence(0);

                try {
                    String testNumber = className.substring(BenchmarkScore.TESTCASENAME.length());
                    tcr.setNumber(Integer.parseInt(testNumber));
                } catch (Exception e) {
                    return null; // If we can't parse the test #, its not in a real test case file.
                    // e.g.,
                    // BenchmarkTesting.java
                }

                return tcr;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
