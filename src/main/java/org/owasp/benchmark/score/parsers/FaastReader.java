package org.owasp.benchmark.score.parsers;

import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FaastReader extends Reader{

    public TestResults parse( File f ) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(f.getPath())));
        JSONArray obj = new JSONArray(content);
        TestResults tr = new TestResults( "Faast - Telefonica Cyber Security" ,true,TestResults.ToolType.DAST);
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
            if (key.matches("CWE")){
                cwe = (Integer)finding.get(key);
            }else if(key.matches("Resources")){
                JSONArray res_obj = (JSONArray) finding.get(key);
                for (int i = 0; i < res_obj.length(); i++) {

                    JSONObject jsonResObj = res_obj.getJSONObject(i);
                    for (Object res_json : jsonResObj.keySet()) {
                        String keyres = (String) res_json;
                        if(keyres.matches("Value")){
                            url = (String) jsonResObj.get(keyres);
                            testNumber = getTestCase(url);
                            category = getCategory(url);
                        }
                    }
                }
            }

        }
        if ( url.contains( BenchmarkScore.BENCHMARKTESTNAME ) ) {
            tcr.setNumber( Integer.parseInt( testNumber ) );
            tcr.setCWE( cwe );
            tcr.setCategory( category );
            return tcr;
        }else{
            return null;
        }

    }

    private String getCategory(String url){
        String flag = "benchmark/";
        int locator_start  = url.lastIndexOf(flag)+flag.length();
        int locator_end = url.lastIndexOf("/"+BenchmarkScore.BENCHMARKTESTNAME);
        return url.substring(locator_start,locator_end);
    }

    private String getTestCase(String url){
        int locator = url.lastIndexOf(BenchmarkScore.BENCHMARKTESTNAME)+BenchmarkScore.BENCHMARKTESTNAME.length();
        return url.substring( locator , locator+5);
    }
}
