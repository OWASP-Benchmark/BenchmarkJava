/**
* OWASP Benchmark Project
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Marcos P
* @created 2018
*/

package org.owasp.benchmark.score.parsers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FaastReader extends Reader {

    public TestResults parse( File f ) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(f.getPath())));
        JSONArray obj = new JSONArray(content);
        TestResults tr = new TestResults( "Faast - Telefonica Cyber Security", true, TestResults.ToolType.DAST);
        tr.setTime(f);
        for (int i = 0; i < obj.length(); i++) {
            TestCaseResult tcr = parseFaastFinding(obj.getJSONObject(i));
            tr.put(tcr);
        }
        return tr;
    }

    private TestCaseResult parseFaastFinding(JSONObject finding) {
        TestCaseResult tcr = new TestCaseResult();
        String url = "";
        int cwe = 0;
        String testNumber = "";
        String category = "";
        for (Object o : finding.keySet()) {
            String key = (String) o;
            if (key.matches("CWE")) {
                cwe = (Integer)finding.get(key);
            } else if (key.matches("Resources")) {
                JSONArray res_obj = (JSONArray) finding.get(key);
                for (int i = 0; i < res_obj.length(); i++) {

                    JSONObject jsonResObj = res_obj.getJSONObject(i);
                    for (Object res_json : jsonResObj.keySet()) {
                        String keyres = (String) res_json;
                        if (keyres.matches("Value")) {
                            url = (String) jsonResObj.get(keyres);
                            testNumber = getTestCase(url);
                            category = getCategory(url);
                        }
                    }
                }
            }

        }

        if ( url.contains( BenchmarkScore.TESTCASENAME ) ) {
            tcr.setNumber( Integer.parseInt( testNumber ) );
            tcr.setCWE( cwe );
            tcr.setCategory( category );
            return tcr;
        }

        return null;
    }

    private String getCategory(String url) {
        //TODO: Use APPNAME constant rather than 'benchmark' here.
        String flag = "benchmark/";
        int locator_start  = url.lastIndexOf(flag)+flag.length();
        int locator_end = url.lastIndexOf("/"+BenchmarkScore.TESTCASENAME);
        return url.substring(locator_start,locator_end);
    }

    private String getTestCase(String url) {
        int locator = url.lastIndexOf(BenchmarkScore.TESTCASENAME)+BenchmarkScore.TESTCASENAME.length();
        return url.substring( locator , locator+5);
    }
}
