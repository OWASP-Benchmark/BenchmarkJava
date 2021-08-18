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
 * @author Dave Wichers
 * @author Nipuna Weerasekara
 * @created 2021
 */
package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;
import org.owasp.benchmark.score.TestCaseResult;
import org.owasp.benchmark.score.TestSuiteResults;

public class CodeQLReader extends Reader {

    public TestSuiteResults parse(File f) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(f.getPath())));

        /*
         * This parser was written against version 2.1.0 of the sarif-schema
         * NOTE: To help understand contents of JSON file, use: http://jsonviewer.stack.hu to view it.
         */
        JSONObject obj = new JSONObject(content);
        // String resultsFormatVersion = obj.getString( "version" ); // Might be needed in future
        // if format changes

        JSONArray runs = obj.getJSONArray("runs");

        TestSuiteResults tr = new TestSuiteResults("CodeQL", false, TestSuiteResults.ToolType.SAST);
        // Scan time is not included in the sarif-schema. But scan time is provided on their web
        // site next to results
        tr.setTime(f); // This grabs the scan time out of the filename, if provided
        // e.g., Benchmark_1.2-CodeQL-v2.4.1-840.sarif, means the scan took 840 seconds.

        for (int i = 0; i < runs.length(); i++) {
            // There are 1 or more runs in each results file, one per language found (Java,
            // JavaScript, etc.)
            JSONObject run = runs.getJSONObject(i);

            // First, set the version of LGTM used to do the scan
            JSONObject driver = run.getJSONObject("tool").getJSONObject("driver");
            tr.setToolVersion(driver.getString("semanticVersion"));

            // Then, identify all the rules that report results and which CWEs they map to
            JSONArray rules = driver.getJSONArray("rules");
            // System.out.println("Found: " + rules.length() + " rules.");
            HashMap<String, Integer> rulesUsed = parseLGTMRules(rules);
            // System.out.println("Parsed: " + rulesUsed.size() + " rules.");

            // Finally, parse out all the results
            JSONArray results = run.getJSONArray("results");
            // System.out.println("Found: " + results.length() + " results.");

            for (int j = 0; j < results.length(); j++) {
                TestCaseResult tcr =
                        parseLGTMFinding(results.getJSONObject(j), rulesUsed); // , version );
                if (tcr != null) {
                    tr.put(tcr);
                }
            }
        }

        return tr;
    }

    private static final String LGTMCWEPREFIX = "external/cwe/cwe-";
    private static final int LGTMCWEPREFIXLENGTH = LGTMCWEPREFIX.length();

    private HashMap<String, Integer> parseLGTMRules(JSONArray rulesJSON) {

        HashMap<String, Integer> rulesUsed = new HashMap<String, Integer>();

        for (int j = 0; j < rulesJSON.length(); j++) {
            JSONObject ruleJSON = rulesJSON.getJSONObject(j);

            try {
                String ruleName = ruleJSON.getString("name");
                JSONArray tags = ruleJSON.getJSONObject("properties").getJSONArray("tags");
                for (int i = 0; i < tags.length(); i++) {
                    String val = tags.getString(i);
                    if (val.startsWith(LGTMCWEPREFIX)) {
                        // NOTE: If you try to map the rules here, you have to map EVERY rule in the
                        // current ruleset, even though many of those rules won't have results. So
                        // instead we map them later when there is actually a finding by that rule.
                        rulesUsed.put(
                                ruleName, Integer.parseInt(val.substring(LGTMCWEPREFIXLENGTH)));
                        break; // Break out of for loop because we only want to use the first CWE it
                        // is mapped to currently. If they add rules where the first CWE is
                        // not the preferred one, then we need to implement fixCWE() and
                        // invoke it (commented out example below)
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rulesUsed;
    }

    private TestCaseResult parseLGTMFinding(
            JSONObject finding, HashMap<String, Integer> rulesUsed) {
        try {
            TestCaseResult tcr = new TestCaseResult();
            String filename = null;
            JSONArray locations = finding.getJSONArray("locations");
            filename =
                    locations
                            .getJSONObject(0)
                            .getJSONObject("physicalLocation")
                            .getJSONObject("artifactLocation")
                            .getString("uri");
            filename = filename.substring(filename.lastIndexOf('/') + 1);
            if (filename.startsWith(BenchmarkScore.TESTCASENAME)) {
                String testNumber =
                        filename.substring(
                                BenchmarkScore.TESTCASENAME.length(), filename.lastIndexOf('.'));
                tcr.setNumber(Integer.parseInt(testNumber));
                String ruleId = finding.getString("ruleId");
                Integer cweForRule = rulesUsed.get(ruleId);
                // System.out.println("Found finding in: " + testNumber + " of type: " + ruleId +
                // " CWE: " + cweForRule);
                if (cweForRule == null) {
                    switch (ruleId) {
                        case "java/inefficient-empty-string-test":
                        case "java/missing-override-annotation":
                        case "java/non-static-nested-class":
                            break; // We've seen these before and they're OK, so don't print warning

                        default:

                            // The parseLGTMRules() method strips out rules that don't have a CWE.
                            // So this error can happen. As such, we filter out the ones we've seen.
                            System.out.println(
                                    "WARNING: finding found for ruleId: "
                                            + ruleId
                                            + " with no CWE mapping");
                    }
                    return null;
                }
                if (locations.length() > 1) {
                    System.out.println(
                            "WARNING: Unexpectedly found more than one location for finding against rule: "
                                    + ruleId);
                }
                int cwe = mapCWE(cweForRule);
                tcr.setCWE(cwe);
                // tcr.setCategory( props.getString( "subcategoryShortDescription" ) ); //
                // Couldn't find any Category info in results file
                tcr.setEvidence(finding.getJSONObject("message").getString("text"));
            }
            return tcr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private int mapCWE(Integer cweNumber) {

        switch (cweNumber) {
                // These are properly mapped by default
            case 22: // java/path-injection and zipslip
            case 78: // java/command-line-injection
            case 79: // java/xss
            case 89: // java/sql-injection and similar sqli rules
            case 90: // java/ldap-injection
            case 327: // java/weak-cryptographic-algorithm
            case 611: // java/xxe
            case 614: // java/insecure-cookie
            case 643: // java/xml/xpath-injection
                return cweNumber.intValue(); // Return CWE as is

                // These rules we care about, but have to map to the CWE we expect
            case 335: // java/predictable-seed - This mapping improves the tool's score
                return 330; // Weak Random

                /*
                 * These rules exist in the java-code-scanning.qls query set, but we don't see findings
                 * for them in Benchmark currently. They are left here in case we do see them in the
                 * future to make it easier to support them.
                // These rules we care about, but have to map to the CWE we expect
                    case 338: // java/jhipster-prng
                        return 330; // Weak Random
                    case 347: // java/missing-jwt-signature-check - TODO - Does this affect score?
                        return 327; // Weak Crypto

                    // These rules we don't care about now, but we return their CWE value anyway in case
                    // we care in the future
                    case 94: // java/insecure-bean-validation and many others
                    case 190: // java/implicit-cast-in-compound-assignment
                    case 197: // java/tainted-numeric-cast
                    case 297: // java/unsafe-hostname-verification
                    case 300: // java/maven/non-https-url
                    case 315: // java/cleartext-storage-in-cookie
                    case 352: // java/spring-disabled-csrf-protection
                    case 502: // java/unsafe-deserialization
                    case 601: // java/unvalidated-url-redirection
                    case 732: // java/world-writable-file-read
                    case 807: // java/tainted-permissions-check
                    case 917: // java/ognl-injection
                    case 918: // java/ssrf
                    case 1104: // java/maven/dependency-upon-bintray
                */

            case 113: // java/http-response-splitting
            case 134: // java/tainted-format-string
            case 209: // java/stack-trace-exposure
            case 404: // java/TODO
            case 561: // java/TODO
            case 570: // java/TODO
            case 685: // java/TODO
                return cweNumber.intValue(); // Return CWE as is
            default:
                System.out.println(
                        "CodeQL parser encountered new unmapped vulnerability type: " + cweNumber);
        }
        return 0; // Not mapped to anything
    }
}
