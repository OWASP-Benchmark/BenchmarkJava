/**
 * OWASP Benchmark Project
 * <p>
 * This file is part of the Open Web Application Security Project (OWASP)
 * Benchmark Project For details, please see
 * <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
 * <p>
 * The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 * <p>
 * The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details
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
import java.util.HashMap;
import java.util.List;

public class SecPointReader extends Reader {


    private static final SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-DD HH:mm:ss,SSS");

    public SecPointReader() {
        initMap();
    }

    public static void main(String[] args) throws Exception {
        File f = new File("/Users/zii/Documents/tcsec/github/benchmark/tools/Secpoint/security.log");
        SecPointReader cr = new SecPointReader();
        cr.parse(f);

    }

    public TestResults parse(File f) throws Exception {
        TestResults tr = new TestResults("Secpoint", true, TestResults.ToolType.IAST);

        BufferedReader reader = new BufferedReader(new FileReader(f));
        long startTime = 2114045364852L;
        long endTime = -335435148L;
        String line = "";
        while (line != null) {
            try {
                line = reader.readLine();
                if (line != null && line.length() > 30) {
                    if (line.contains("############# Found Vulnerability")) {
                        line = line.substring(30);
                        parseContrastFinding(tr, line);
                    }
                    if (line.contains("Agent Version:")) {
                        line = line.substring(30);
                        String version = line.substring(line.indexOf("Version:") + 8);
                        tr.setToolVersion(version.trim());
                    }
                    //get detection time
                    if (line.contains("request count") && line.contains("BenchmarkTest")) {
                        try {
                            long time = sdf.parse(line.substring(0, 30)).getTime();
                            startTime = Math.min(startTime, time);
                            endTime = Math.max(endTime, time);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        reader.close();
        tr.setTime(String.valueOf((endTime - startTime) / 1000));
        printConsoleContext(tr);

        return tr;
    }


    /**
     * @param tr
     * @param json
     * @throws Exception
     */
    private void parseContrastFinding(TestResults tr, String json) throws Exception {
        TestCaseResult tcr = new TestCaseResult();

        try {
            json = json.substring(35);
            json = json.substring(0, json.lastIndexOf(":"));

            String[] strings = json.split(":");

            String ruleId = strings[1];
            if (ruleId.equals("242")) {
                System.out.println(ruleId);
            }
            tcr.setCWE(ruleLookup(ruleId));
            tcr.setCategory(ruleId);

            String uri = strings[0];

            String testNumber = uri.substring(uri.lastIndexOf('/') + "BenchmarkTest".length() + 1);
            if (testNumber.contains(".html")) {
                int i = testNumber.indexOf(".html");
                testNumber = testNumber.substring(0, i);
            }
            tcr.setNumber(Integer.parseInt(testNumber));
            if (tcr.getCWE() != 0) {
                // System.out.println( tcr.getNumber() + "\t" + tcr.getCWE() + "\t" + tcr.getCategory() );
                tr.put(tcr);
            }
        } catch (Exception e) {
//            System.err.println("> Parse error: " + json);
            // e.printStackTrace();
        }
    }

    private static HashMap<String, String> map = new HashMap<>();

    private static int ruleLookup(String ruleId) {
        String name = map.get(ruleId);
        return cweLookup(name);
    }

    private static void initMap() {
        map.put("224", "untrusted-deserialization");
        map.put("209", "securecookie");
        map.put("225", "redos");
        map.put("212", "path-traversal");
        map.put("217", "sql-injection");
        map.put("213", "reflected-xss");
        map.put("210", "ldap-injection");
        map.put("204", "cmd-injection");
        map.put("214", "reflection-injection");
        map.put("205", "cookie-flags-missing");
        map.put("216", "nosql-injection");
        map.put("222", "xpath-injection");
        map.put("201", "ssrf");
        map.put("218", "trust-boundary-violation");
        map.put("202", "unsafe-xml-decode");
        map.put("241", "cachecontrol");
        map.put("230", "insecurehttpmethod");
        map.put("226", "cookiesensitive");
        map.put("228", "csp-missing");
        map.put("245", "clickjacking");
        map.put("236", "xxssprotectionmissing");
        map.put("244", "crossdomain");
        map.put("231", "insecureauth");
        map.put("246", "webversiondisclosure");
        map.put("243", "csrf");
        map.put("240", "sessiontimeout");
        map.put("232", "hstsdisable");
        map.put("234", "jsonp");
        map.put("235", "xcontenttype");
        map.put("233", "unsafejsp");
        map.put("242", "autocomplete");
        map.put("239", "sessionrewrite");
        map.put("229", "springautobinding");
        map.put("227", "cspdisable");
        map.put("207", "crypto-bad-mac");
        map.put("206", "crypto-bad-ciphers");
        map.put("219", "unsafe-readline");
        map.put("215", "hql-injection");
        map.put("221", "urlredirect");
        map.put("220", "urlredirect");
        map.put("253", "domxss");
        map.put("252", "dos_via_blocking_call");
        map.put("254", "improper-logout");
        map.put("260", "weakpassword");
        map.put("255", "cors");
        map.put("250", "serverrequest");
        map.put("251", "crypto-weak-randomness");
    }

    private static int cweLookup(String rule) {
        switch (rule) {
            case "cookie-flags-missing":
                return 614; // insecure cookie use
            case "sql-injection":
                return 89; // sql injection
            case "cmd-injection":
                return 78; // command injection
            case "ldap-injection":
                return 90; // ldap injection
            case "header-injection":
                return 113; // header injection
            case "hql-injection":
                return 564; // hql injection
            case "unsafe-readline":
                return 0000; // unsafe readline
            case "reflection-injection":
                return 0000; // reflection injection
            case "reflected-xss":
                return 79; // xss
            case "xpath-injection":
                return 643; // xpath injection
            case "path-traversal":
                return 22; // path traversal
            case "crypto-bad-mac":
                return 328; // weak hash
            case "crypto-weak-randomness":
                return 330; // weak random
            case "crypto-bad-ciphers":
                return 327; // weak encryption
            case "trust-boundary-violation":
                return 501; // trust boundary
            case "xxe":
                return 611; // xml entity
            case "jsonp":
                return 345;
            case "serverrequest":
                return 319;
            case "autocomplete":
                return 1111;
            case "improper-logout":
                return 2222;
            case "weakpassword":
                return 3333;
            case "urlredirect":
                return 4444;
            case "hardcode-password":
                return 5555;
            case "hardcode-key":
                return 6666;
            case "sessionrewrite":
                return 7777;
            case "domxss":
                return 8888;
            case "cors":
                return 9999;
            case "cookiesensitive":
                return 11111;
        }
        return 0;
    }


    private void printConsoleContext(TestResults tr) {
        try {

            List<String> totalList = new ArrayList<>();
            List<String> trueList = new ArrayList<>();
            List<String> falseList = new ArrayList<>();
            List<String> missList = new ArrayList<>();
            List<String> fasefalseList = new ArrayList<>();
            System.out.print(System.getProperty("user.dir"));
            BufferedReader csvReader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "/expectedresults-1.2.csv")));
            String line = "";
            while (line != null) {
                try {
                    line = csvReader.readLine();
                    if (line != null) {
                        if (line.startsWith("BenchmarkTest")) {
                            String[] starss = line.split(",");
//                        BenchmarkTest00014,xss,true,79
                            int number = Integer.parseInt(starss[0].substring(13));
                            String type = starss[1];

                            totalList.add(starss[0] + ":" + type);

                            boolean isVnlus = Boolean.parseBoolean(starss[2]);
                            int typeNumber = Integer.parseInt(starss[3]);

                            List<TestCaseResult> list = tr.get(number);

                            boolean isFound = false;
                            if (list != null && !list.isEmpty()) {
                                for (TestCaseResult testCaseResult : list) {
                                    if (testCaseResult.getCWE() == typeNumber) {
                                        isFound = true;
                                        break;
                                    }
                                }
                            }

                            // true
                            if (isVnlus && isFound) {
                                trueList.add(starss[0] + ":" + type);
                            }

                            // false positives report
                            if (!isVnlus && isFound) {
                                falseList.add(starss[0] + ":" + type);
                            }

                            // missing report
                            if (isVnlus && !isFound) {
                                missList.add(starss[0] + ":" + type);
                            }

                            if (!isVnlus && !isFound) {
                                fasefalseList.add(starss[0] + ":" + type);
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            csvReader.close();

            System.out.println("total:" + totalList.size());
            System.out.println("missing report total:" + missList.size());
            System.out.println("false positives report total:" + falseList.size());
            System.out.println("true total:" + trueList.size());
            System.out.println("false total:" + fasefalseList.size());

            System.out.println("missing report");
            for (String str : missList) {
                System.out.println(str);
            }

            System.out.println("false positives report");
            for (String str : falseList) {
                System.out.println(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
