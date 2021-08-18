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
 * @author Dave Wichers
 * @created 2015
 */
package org.owasp.benchmark.score.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;
import org.owasp.benchmark.score.TestCaseResult;
import org.owasp.benchmark.score.TestSuiteResults;

public class ContrastReader extends Reader {

    static final String NODEFINDINGLINEINDICATOR = "contrast:rules:sinks - ";
    static final String NODEAGENTVERSIONLINEINDICATOR = "contrast:contrast-init - agent v";

    public static void main(String[] args) throws Exception {
        File f = new File("results/Benchmark_1.2-Contrast.log");
        ContrastReader cr = new ContrastReader();
        cr.parse(f);
    }

    public TestSuiteResults parse(File f) throws Exception {
        TestSuiteResults tr =
                new TestSuiteResults("Contrast", true, TestSuiteResults.ToolType.IAST);

        BufferedReader reader = new BufferedReader(new FileReader(f));
        // This use of repeat() allows test case IDs to be different lengths for different
        // test suites.
        String FIRSTLINEINDICATOR =
                BenchmarkScore.TESTCASENAME
                        + StringUtils.repeat("0", BenchmarkScore.TESTIDLENGTH - 1)
                        + "1";
        String firstLine = null;
        String lastLine = "";
        String line = "";
        while (line != null) {
            try {
                line = reader.readLine();
                if (line != null) {
                    if (line.startsWith("{\"hash\":")) {
                        parseContrastJavaFinding(tr, line);
                    } else if (line.contains(NODEFINDINGLINEINDICATOR)) {
                        parseContrastNodeFinding(tr, line);
                    } // Agent Version check for Java
                    else if (line.contains("Agent Version:")) {
                        String version =
                                line.substring(line.indexOf("Version:") + "Version:".length());
                        tr.setToolVersion(version.trim());
                    } // Agent Version check for Node
                    else if (line.contains(NODEAGENTVERSIONLINEINDICATOR)) {
                        String version =
                                line.substring(
                                        line.indexOf(NODEAGENTVERSIONLINEINDICATOR)
                                                + NODEAGENTVERSIONLINEINDICATOR.length(),
                                        line.indexOf(','));
                        tr.setToolVersion(version);
                    } // First line check for Java
                    else if (line.contains("DEBUG - >>> [URL")
                            && line.contains(FIRSTLINEINDICATOR)) {
                        firstLine = line;
                    } // First line check for Node
                    else if (line.contains("Received request ")
                            && line.contains(FIRSTLINEINDICATOR)) {
                        firstLine = line;
                    } else if (line.contains("DEBUG - >>>") || line.contains("Received request ")) {
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

    private void parseContrastNodeFinding(TestSuiteResults tr, String line) throws Exception {

        // Node findings look like:
        // debug: 2021-05-12T21:00:46.118Z 12631 contrast:rules:sinks - crypto-bad-mac:
        // /julietjs/sqli-00/JulietJSTest00001
        // However, there are similar lines like this we have to avoid:
        // debug: 2021-05-12T21:00:30.487Z 12631 contrast:rules:sinks - loading provider for
        // hardcoded-password

        if (line.contains("loading provider")) return;

        int i = line.indexOf(NODEFINDINGLINEINDICATOR);
        if (i < 0) {
            System.out.println(
                    "Bug in Contrast Parser. "
                            + NODEFINDINGLINEINDICATOR
                            + " not found in line: "
                            + line);
            return;
        }

        line = line.substring(i + NODEFINDINGLINEINDICATOR.length());
        String[] elements = line.split(":");

        TestCaseResult tcr = new TestCaseResult();
        tcr.setCWE(cweLookup(elements[0]));
        tcr.setCategory(elements[0]);

        if (tcr.getCWE() != 0 && elements[1].contains(BenchmarkScore.TESTCASENAME)) {
            String testNumber =
                    elements[1].substring(
                            elements[1].lastIndexOf('/')
                                    + BenchmarkScore.TESTCASENAME.length()
                                    + 1);
            // Contrast detects potential vulns when requesting .html pages through certain Node
            // frameworks. Ignore those if they are detected.
            if (!testNumber.endsWith(".html"))
                try {
                    tcr.setNumber(Integer.parseInt(testNumber));
                    tr.put(tcr);
                } catch (Exception e) {
                    // There are a few crypto related findings not associated
                    // with a request, so ignore errors associated with those.
                    if (line.contains("crypto-bad-ciphers")
                            || line.contains("crypto-bad-mac")
                            || line.contains("crypto-weak-randomness")) {
                        // do nothing
                    } else {
                        System.err.println("Contrast Node Results Parse error for: " + line);
                        e.printStackTrace();
                    }
                }
        }
    }

    private void parseContrastJavaFinding(TestSuiteResults tr, String json) throws Exception {

        TestCaseResult tcr = new TestCaseResult();

        try {
            JSONObject obj = new JSONObject(json);
            String ruleId = obj.getString("ruleId");
            tcr.setCWE(cweLookup(ruleId));
            tcr.setCategory(ruleId);

            JSONObject request = obj.getJSONObject("request");
            String uri = request.getString("uri");

            if (tcr.getCWE() != 0 && uri.contains(BenchmarkScore.TESTCASENAME)) {
                // Normal uri's look like: "uri":"/benchmark/cmdi-00/BenchmarkTest00215", but for
                // web services, they can look like:
                // "uri":"/benchmark/rest/xxe-00/BenchmarkTest03915/send"
                String testNumberStr =
                        uri.substring(
                                uri.indexOf(BenchmarkScore.TESTCASENAME)
                                        + BenchmarkScore.TESTCASENAME.length());
                // At this point testNumber could contain '00215', or '03915/send'
                int slashIndex = testNumberStr.indexOf('/');
                if (slashIndex > 0) {
                    testNumberStr = testNumberStr.substring(0, slashIndex);
                }
                tcr.setNumber(Integer.parseInt(testNumberStr));
                // System.out.println( tcr.getNumber() + "\t" + tcr.getCWE() + "\t" +
                // tcr.getCategory() );
                tr.put(tcr);
            }
        } catch (Exception e) {
            // There are a few crypto related findings not associated with
            // a request, so ignore findings associated with those.
            if (json.contains("\"ruleId\":\"crypto-bad-ciphers\"")
                    || json.contains("\"ruleId\":\"crypto-bad-mac\"")
                    || json.contains("\"ruleId\":\"crypto-weak-randomness\"")) {
                // do nothing
            } else {
                System.err.println("Contrast Java Results Parse error for: " + json);
                e.printStackTrace();
            }
        }
    }

    private static int cweLookup(String rule) {
        switch (rule) {
            case "cache-controls-missing":
                return 525; // Web Browser Cache Containing Sensitive Info
            case "clickjacking-control-missing":
                return 1021; // Improper Restriction of Rendered UI Layers (i.e., Clickjacking)
            case "cmd-injection":
                return 78; // command injection
            case "cookie-flags-missing":
                return 614; // insecure cookie use
            case "crypto-bad-ciphers":
                return 327; // weak encryption
            case "crypto-bad-mac":
                return 328; // weak hash
            case "crypto-weak-randomness":
                return 330; // weak random
            case "csp-header-insecure":
                return 0000; // Don't care
            case "csp-header-missing":
                return 0000; // Don't care
            case "header-injection":
                return 113; // header injection
            case "hql-injection":
                return 564; // hql injection
            case "hsts-header-missing":
                return 319; // CWE-319: Cleartext Transmission of Sensitive Information
            case "ldap-injection":
                return 90; // ldap injection
            case "nosql-injection":
                return 89; // nosql injection
            case "path-traversal":
                return 22; // path traversal
            case "reflected-xss":
                return 79; // xss
            case "reflection-injection":
                return 0000; // reflection injection
            case "redos":
                return 400; // regex denial of service - CWE-400: Uncontrolled Resource Consumption
            case "sql-injection":
                return 89; // sql injection
            case "trust-boundary-violation":
                return 501; // trust boundary
            case "unsafe-readline":
                return 0000; // unsafe readline
            case "xcontenttype-header-missing":
                return 0000; // Don't care
            case "xpath-injection":
                return 643; // xpath injection
            case "xxe":
                return 611; // xml entity
            default:
                System.out.println("WARNING: Contrast-Unrecognized finding type: " + rule);
        }

        return 0;
    }

    private String calculateTime(String firstLine, String lastLine) {
        try {
            String start = firstLine.split(" ")[1];
            String stop = lastLine.split(" ")[1];
            SimpleDateFormat sdf;
            if (start.endsWith("Z")) {
                // Node log format: "2021-05-12T21:00:46.095Z"
                sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            } else sdf = new SimpleDateFormat("HH:mm:ss,SSS"); // Java log format
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
