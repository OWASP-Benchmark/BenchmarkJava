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
 * <p>This reader reads JSON reports from the Horusec open source tool at:
 * https://github.com/ZupIT/horusec
 *
 * @author Sascha Knoop
 * @created 2021
 */
package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;
import org.owasp.benchmark.score.TestCaseResult;
import org.owasp.benchmark.score.TestSuiteResults;

public class HorusecReader extends Reader {

    public static boolean isHorusecReport(final JSONObject json) {
        try {
            return json.getJSONArray("analysisVulnerabilities")
                    .getJSONObject(0)
                    .getJSONObject("vulnerabilities")
                    .has("securityTool");
        } catch (Exception e) {
            return false;
        }
    }

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public TestSuiteResults parse(JSONObject json) throws Exception {
        TestSuiteResults tr =
                new TestSuiteResults("Horusec", false, TestSuiteResults.ToolType.SAST);

        JSONArray arr = json.getJSONArray("analysisVulnerabilities");

        for (int i = 0; i < arr.length(); i++) {
            TestCaseResult tcr = parseTestCaseResult(arr.getJSONObject(i));
            if (tcr != null) {
                tr.put(tcr);
            }
        }

        tr.setToolVersion(readVersion(json));
        tr.setTime(calculateTime(json.getString("createdAt"), json.getString("finishedAt")));

        return tr;
    }

    private TestCaseResult parseTestCaseResult(JSONObject finding) {
        try {
            TestCaseResult tcr = new TestCaseResult();

            JSONObject vuln = finding.getJSONObject("vulnerabilities");

            String filename = filename(vuln);

            if (filename.contains(BenchmarkScore.TESTCASENAME)) {
                tcr.setNumber(testNumber(filename));

                tcr.setCWE(figureCwe(vuln));
            }

            return tcr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private int figureCwe(JSONObject vuln) {
        String details = vuln.getString("details");

        String cwe = fetchCweFromDetails(details);

        if (cwe == null) {
            cwe = guessCwe(details);
        }

        switch (cwe) {
            case "79":
                return 79; // xss
            case "89":
                return 89; // sql injection
            case "326":
            case "327":
                return 327; // Broken or Risky Cryptographic Algorithm
            case "328":
                return 328; // weak hash
            case "329":
                return 329; // static initialization vector for crypto
            case "330":
                return 330; // weak random
            case "502":
                if (category(details).equals("LDAP deserialization should be disabled")) {
                    return 90; // LDAP injection
                }

                return 502; // insecure deserialization
            case "611":
                return 611; // xml entity
            case "614":
                return 614; // insecure cookie use
            case "643":
                return 643; // xpath injection
            case "649":
                return 649; // obfuscation
            default:
                System.out.println(
                        "INFO: Found following CWE which we haven't seen before: " + cwe);
                return Integer.parseInt(cwe);
        }
    }

    private String fetchCweFromDetails(String details) {
        if (!details.contains("CWE")) {
            return null;
        }

        String cweTmp = details.substring(details.indexOf("CWE-") + 4);

        return cweTmp.substring(0, cweTmp.indexOf(' '));
    }

    private String guessCwe(String details) {
        switch (category(details)) {
            case "Java Crypto import":
            case "DES is considered deprecated. AES is the recommended cipher.":
                return "327";
            case "Weak block mode for Cryptographic Hash Function":
            case "Message Digest":
                return "328";
            case "Cookie without the HttpOnly flag":
                return "614";
            case "Base64 Encode":
                return "649";
            default:
                throw new RuntimeException(details);
        }
    }

    private String category(String details) {
        return details.split("\n")[0].trim();
    }

    private int testNumber(String filename) {
        return Integer.parseInt(
                filename.substring(
                        BenchmarkScore.TESTCASENAME.length() + 1,
                        filename.length() - BenchmarkScore.TESTIDLENGTH));
    }

    private String filename(JSONObject vuln) {
        return new File(vuln.getString("file")).getName();
    }

    private String calculateTime(String createdAt, String finishedAt) {
        try {
            long passedMilliseconds = unixMilliseconds(finishedAt) - unixMilliseconds(createdAt);
            return TestSuiteResults.formatTime(passedMilliseconds);
        } catch (Exception e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

    private long unixMilliseconds(String createdAt) throws ParseException {
        return sdf.parse(trimAfterDot(createdAt)).getTime();
    }

    private String trimAfterDot(String date) {
        return date.substring(0, date.indexOf('.'));
    }

    private String readVersion(JSONObject json) {
        if (json.has("version")) {
            return json.getString("version");
        } else {
            return "0.0.0";
        }
    }
}
