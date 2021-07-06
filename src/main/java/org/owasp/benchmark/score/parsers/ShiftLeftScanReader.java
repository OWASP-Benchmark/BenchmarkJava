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
 * <p>This reader reads JSON reports from the open source version of ShiftLeft Scan at:
 * https://github.com/ShiftLeftSecurity/sast-scan. ShiftLeft has a commercial version of this tool
 * as well.
 *
 * @author Sascha Knoop
 * @created 2021
 */
package org.owasp.benchmark.score.parsers;

import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;
import org.owasp.benchmark.score.TestCaseResult;
import org.owasp.benchmark.score.TestSuiteResults;

public class ShiftLeftScanReader {

    public static boolean isShiftLeftScanReport(final String content) {
        return content.contains("@ShiftLeft/sast-scan");
    }

    public TestSuiteResults parse(final String content) throws Exception {
        String[] lines = content.split("\n");

        JSONObject javaSourceAnalyzer = new JSONObject(lines[0]);
        JSONObject classFileAnalyzer = new JSONObject(lines[1]);

        // false indicates this is an open source/free tool.
        TestSuiteResults tr =
                new TestSuiteResults("ShiftLeft Scan", false, TestSuiteResults.ToolType.SAST);

        parseAndAddResults(tr, javaSourceAnalyzer);
        parseAndAddResults(tr, classFileAnalyzer);

        tr.setToolVersion(readVersion(javaSourceAnalyzer));

        return tr;
    }

    private String readVersion(JSONObject javaSourceAnalyzer) {
        return javaSourceAnalyzer
                .getJSONObject("tool")
                .getJSONObject("driver")
                .getString("version")
                .replace("-scan", "");
    }

    private void parseAndAddResults(TestSuiteResults tr, JSONObject analyzerResults) {
        JSONArray arr = analyzerResults.getJSONArray("results");

        for (int i = 0; i < arr.length(); i++) {
            TestCaseResult tcr = parseTestCaseResult(arr.getJSONObject(i));

            if (tcr != null) {
                tr.put(tcr);
            }
        }
    }

    private TestCaseResult parseTestCaseResult(JSONObject finding) {
        try {
            String filename = filename(finding);

            if (filename.contains(BenchmarkScore.TESTCASENAME)) {
                TestCaseResult tcr = new TestCaseResult();

                tcr.setNumber(testNumber(filename));
                tcr.setCWE(cweNumber(finding));

                return tcr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String filename(JSONObject finding) {
        JSONArray locations = finding.getJSONArray("locations");

        if (locations.length() != 1) {
            throw new RuntimeException(finding.toString());
        }

        return new File(
                        locations
                                .getJSONObject(0)
                                .getJSONObject("physicalLocation")
                                .getJSONObject("artifactLocation")
                                .getString("uri"))
                .getName();
    }

    private int cweNumber(JSONObject finding) {
        String ruleId = finding.getString("ruleId");

        switch (ruleId) {
            case "PATH_TRAVERSAL_IN":
            case "PATH_TRAVERSAL_OUT":
            case "PT_RELATIVE_PATH_TRAVERSAL":
            case "PT_ABSOLUTE_PATH_TRAVERSAL":
                return 22;
            case "COMMAND_INJECTION":
                return 78;
            case "HTTP_RESPONSE_SPLITTING":
                return 113;
            case "XSS_SERVLET":
            case "HRS_REQUEST_PARAMETER_TO_COOKIE":
            case "XSS_REQUEST_PARAMETER_TO_SERVLET_WRITER":
                return 79;
            case "SQL_INJECTION_JDBC":
            case "SQL_INJECTION_SPRING_JDBC":
            case "SQL_NONCONSTANT_STRING_PASSED_TO_EXECUTE":
            case "SQL_PREPARED_STATEMENT_GENERATED_FROM_NONCONSTANT_STRING":
                return 89;
            case "LDAP_INJECTION":
                return 90;
            case "PADDING_ORACLE":
                return 209;
            case "DES_USAGE":
            case "CIPHER_INTEGRITY":
                return 327;
            case "WEAK_MESSAGE_DIGEST_MD5":
            case "WEAK_MESSAGE_DIGEST_SHA1":
                return 328;
            case "STATIC_IV":
                return 329;
            case "PREDICTABLE_RANDOM":
                return 330;
            case "TRUST_BOUNDARY_VIOLATION":
                return 501;
            case "HTTPONLY_COOKIE":
                return 1004;
            case "INSECURE_COOKIE":
                return 614;
            case "XPATH_INJECTION":
                return 643;

            default:
                System.out.println(
                        "INFO: Found following ruleId which we haven't seen before: " + ruleId);
                return -1;
        }
    }

    private int testNumber(String filename) {
        return Integer.parseInt(
                filename.substring(
                        BenchmarkScore.TESTCASENAME.length() + 1,
                        filename.length() - BenchmarkScore.TESTIDLENGTH));
    }
}
