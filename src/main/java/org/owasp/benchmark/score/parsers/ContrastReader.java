/**
 * OWASP Benchmark Project
 *
 * This file is part of the Open Web Application Security Project (OWASP)
 * Benchmark Project For details, please see
 * <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
 *
 * The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
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
import java.util.List;

import org.owasp.benchmark.score.BenchmarkScore;

public class ContrastReader extends Reader {

    public static void main(String[] args) throws Exception {
        File f = new File("contrast.log");
        ContrastReader cr = new ContrastReader();
        cr.parse(f);
    }

    public TestResults parse(File f) throws Exception {
        TestResults tr = new TestResults("Contrast", true, TestResults.ToolType.IAST);

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
                    if (line.contains("J2EEController] DEBUG - >>> [URL 1]") && !line.endsWith(".html")) {
                            // ok, we're starting a new URL, so process this one and start the next chunk
                            process(tr, testNumber, chunk);
                            chunk.clear();
                            testNumber = "00000";
                            String fname = "/" + BenchmarkScore.BENCHMARKTESTNAME;
                            int idx = line.indexOf( fname );
                            if ( idx != -1 ) {
                                testNumber = line.substring(idx + fname.length(), idx + fname.length() + 5 );
                            }
                            if ( firstLine == null ) {
                                firstLine = line;
                            }
                            lastLine = line;
                    } else if (line.startsWith("<finding hash")) {
                        chunk.add(line);
                    } else if (line.contains("Agent Version:")) {
                        String version = line.substring(line.indexOf("Version:") + 8);
                        tr.setToolVersion(version.trim());
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //Last
        if(!chunk.isEmpty()){
        	// ok, we're starting a new URL, so process this one and start the next chunk
            process(tr, testNumber, chunk);
            chunk.clear();
            testNumber = "00000";
            String fname = "/" + BenchmarkScore.BENCHMARKTESTNAME;
            int idx = lastLine.indexOf( fname );
            if ( idx != -1 ) {
                testNumber = lastLine.substring(idx + fname.length(), idx + fname.length() + 5 );
            }
        }
        reader.close();
        tr.setTime(calculateTime(firstLine, lastLine));
        return tr;
    }
 
    private String calculateTime(String firstLine, String lastLine) {
        try {
            String start = firstLine.split(" ")[1];
            String stop = lastLine.split(" ")[1];
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss,SSS");
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

    private void process(TestResults tr, String testNumber, List<String> chunk) throws Exception {
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
                // System.out.println( tcr.getNumber() + "\t" + tcr.getCWE() + "\t" + tcr.getCategory() );
                tr.put(tcr);
            }
        }
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
        }
        return 0;
    }

}
