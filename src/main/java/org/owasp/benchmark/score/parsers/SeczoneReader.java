/**
 * OWASP Benchmark Project
 *
 * <p>This file is part of the Open Web Application Security Project (OWASP) Benchmark Project For
 * details, please see <a
 * href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
 *
 * <p>The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * <p>The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details
 *
 * @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
 * @created 2015
 */
package org.owasp.benchmark.score.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.owasp.benchmark.score.BenchmarkScore;
import org.owasp.benchmark.score.TestCaseResult;
import org.owasp.benchmark.score.TestSuiteResults;

public class SeczoneReader extends Reader {

    public static void main(String[] args) throws Exception {
        File f = new File("seczone.log");
        SeczoneReader cr = new SeczoneReader();
        cr.parse(f);
    }

    public TestSuiteResults parse(File f) throws Exception {
        TestSuiteResults tr =
                new TestSuiteResults("VulHunter", true, TestSuiteResults.ToolType.IAST);

        BufferedReader reader = new BufferedReader(new FileReader(f));
        String firstLine = null;
        String lastLine = "";
        String line = "";
        ArrayList<String> chunk = new ArrayList<String>();
        String testNumber = "00001";
        while (line != null) {
            try {
                line = reader.readLine();
                if (line != null) {
                    if (firstLine == null) firstLine = line;
                    lastLine = line;
                    if (line.contains("Accept Request URL====>>") && !line.endsWith(".html")) {
                        // ok, we're starting a new URL, so process this one and start the next
                        // chunk
                        parseVulHunterFinding(tr, testNumber, chunk);
                        chunk.clear();
                        testNumber = "00000";
                        String fname = "/" + BenchmarkScore.TESTCASENAME;
                        int idx = line.indexOf(fname);
                        if (idx != -1) {
                            testNumber =
                                    line.substring(idx + fname.length(), idx + fname.length() + 5);
                        }
                    } else if (line.contains("Report BUG===>>>")) {
                        chunk.add(line);
                    } else if (line.contains("get engine jar")) {
                        String versionLine =
                                line.substring(line.indexOf("\\engine-") + "\\engine-".length());
                        String version = versionLine.substring(0, versionLine.indexOf(".jar"));
                        tr.setToolVersion(version);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        // Last
        if (!chunk.isEmpty()) {
            // ok, we're starting a new URL, so process this one and start the next chunk
            parseVulHunterFinding(tr, testNumber, chunk);
            chunk.clear();
            testNumber = "00000";
            String fname = "/" + BenchmarkScore.TESTCASENAME;
            int idx = lastLine.indexOf(fname);
            if (idx != -1) {
                testNumber = lastLine.substring(idx + fname.length(), idx + fname.length() + 5);
            }
        }
        reader.close();
        tr.setTime(calculateTime(firstLine, lastLine));
        return tr;
    }

    private String calculateTime(String firstLine, String lastLine) {
        // Lines start with: PID_8772 | 2020-12-11 19:00:51.370 INFO ...
        try {
            String start = firstLine.split(" ")[3];
            String stop = lastLine.split(" ")[3];
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            Date startTime = sdf.parse(start);
            Date stopTime = sdf.parse(stop);
            long startMillis = startTime.getTime();
            long stopMillis = stopTime.getTime();
            return ((stopMillis - startMillis) / 1000) + " seconds";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void parseVulHunterFinding(TestSuiteResults tr, String testNumber, List<String> chunk)
            throws Exception {
        for (String line : chunk) {
            TestCaseResult tcr = new TestCaseResult();

            String ruleid = line.substring(line.indexOf("ruleId=\"") + 8, line.length() - 2);
            tcr.setCWE(cweLookup(ruleid));
            tcr.setCategory(ruleid);

            try {
                tcr.setNumber(Integer.parseInt(testNumber));
            } catch (NumberFormatException e) {
                System.out.println("> Parse error: " + line);
            }

            if (tcr.getCWE() != 0) {
                // System.out.println( tcr.getNumber() + "\t" + tcr.getCWE() + "\t" +
                // tcr.getCategory() );
                tr.put(tcr);
            }
        }
    }

    private static int cweLookup(String rule) {
        switch (rule) {
            case "cmd-injection": // 12432
                return 78; // command injection
            case "cookie-injection":
                return 0000; // What is this exactly?
            case "content-type-missing":
                return 0000; // Don't care
            case "cookie-missing-httponly":
                return 1004; // insecure cookie use
            case "cookie-missing-secure":
                return 614; // insecure cookie use
            case "crypto-bad-ciphers":
                return 327; // weak encryption
            case "crypto-bad-mac":
                return 328; // weak hash
            case "crypto-weak-randomness":
                return 330; // weak random
            case "csrf":
                return 352; // csrf
            case "header-injection":
                return 113; // header injection
            case "hql-injection":
                return 564; // hql injection
            case "hsts":
                return 319; // CWE-319: Cleartext Transmission of Sensitive Information
            case "ldap-injection":
                return 90; // ldap injection
            case "path-traversal": // 19703
                return 22; // path traversal
            case "reflected-xss": // 21290
                return 79; // xss
            case "reflection-injection":
                return 0000; // reflection injection
            case "referrer-policy-missing":
                return 0000; // Don't care
            case "sensitive-data-flow-tracking":
                return 0000; // Don't care
            case "sensitive-data-response-tracking":
                return 0000; // Don't care
            case "sql-injection": // 20501
                return 89; // sql injection
            case "trust-boundary-violation":
                return 501; // trust boundary
            case "unsafe-readline":
                return 0000; // unsafe readline
            case "unsafe-web-service-call":
                return 0000; // Not sure what this is.
            case "weak-password-db-connection":
                return 0000; // Don't care
            case "x-xss-protection-header-disabled":
                return 0000; // Don't care
            case "xcontenttype-header-missing":
                return 0000; // Don't care
            case "xpath-injection":
                return 643; // xpath injection
            case "xxe":
                return 611; // xml entity
            default:
                System.out.println("WARNING: VulHunter-Unrecognized finding type: " + rule);
        }
        return 0;
    }
}
