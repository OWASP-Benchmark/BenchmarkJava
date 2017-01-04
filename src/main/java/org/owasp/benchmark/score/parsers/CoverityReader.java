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

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.owasp.benchmark.score.BenchmarkScore;

public class CoverityReader extends Reader {

	public TestResults parse( File f ) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(f.getPath())));

	    JSONObject obj = new JSONObject(content);
	    int version = obj.getInt( "formatVersion" );

	    String key = version == 3 ? "issues" : "mergedIssues";
	    JSONArray arr = obj.getJSONArray(key);

	    TestResults tr = new TestResults( "Coverity Code Advisor" ,true,TestResults.ToolType.SAST); // Coverity's tool is called Code Advisor or Code Advisor On Demand
	    // Fixme: See if we can figure this out from some of the files they provide
	    tr.setTime(f);
	    
	    for (int i = 0; i < arr.length(); i++)
	    {
            TestCaseResult tcr = parseCoverityFinding( arr.getJSONObject(i), version );
            if ( tcr != null ) {
                tr.put( tcr );
            }
	    }
	    
		return tr;
	}

	
	private TestCaseResult parseCoverityFinding(JSONObject finding, int version) {
		try {
		    TestCaseResult tcr = new TestCaseResult();
		    String filename = null;
		    
		    if ( version == 3 ) {
                filename = finding.getString("mainEventFilePathname");
	            filename = filename.replaceAll( "\\\\", "/");
	            filename = filename.substring( filename.lastIndexOf( '/' ) );
	            if ( filename.contains( BenchmarkScore.BENCHMARKTESTNAME ) ) {
	                String testNumber = filename.substring( BenchmarkScore.BENCHMARKTESTNAME.length() + 1, filename.length() - 5 );
	                tcr.setNumber( Integer.parseInt( testNumber ) );
	                JSONObject props = finding.getJSONObject("checkerProperties");
	                String cweNumber = props.getString( "cweCategory" );
	                if ( cweNumber == null || cweNumber.equals ("none" ) ) {
	                    return null;
	                }
	                int cwe = fixCWE( cweNumber );
	                tcr.setCWE( cwe );
	                tcr.setCategory( props.getString( "subcategoryShortDescription" ) );
	                tcr.setEvidence( props.getString( "subcategoryLongDescription" ) );	            
	                // tcr.setConfidence( finding.getString( "impact" ));
	            }
		    }
	            
		    // I believe this is for version == 1
	        else {
                filename = finding.getJSONArray("occurrences").getJSONObject(0).getString("mainEventFilePathname");
                filename = filename.replaceAll( "\\\\", "/");
                filename = filename.substring( filename.lastIndexOf( '/' ) );
                if ( filename.contains( BenchmarkScore.BENCHMARKTESTNAME ) ) {
                    String testNumber = filename.substring( BenchmarkScore.BENCHMARKTESTNAME.length() + 1, filename.length() - 5 );
                    tcr.setNumber( Integer.parseInt( testNumber ) );
                    if ( finding.isNull( "cweNumber" ) ) {
                        return null;
                    }
    		        String cweNumber = finding.getString( "cweNumber" );
		            int cwe = fixCWE( cweNumber );
    	            tcr.setCWE( cwe );
    	            tcr.setCategory( finding.getString( "categoryDescription" ) );
    	            tcr.setEvidence( finding.getString( "longDescription" ) );        
    	            // tcr.setConfidence( finding.getString( "impact" ));
                }
		    }
            return tcr;
		} catch (Exception e ) {
		    e.printStackTrace();
		}
        return null;
	}
	
	private int fixCWE( String cweNumber ) {
        int cwe = Integer.parseInt( cweNumber );
        if ( cwe == 94 ) cwe = 643;
        if ( cwe == 36 ) cwe = 22;
        if ( cwe == 23 ) cwe = 22;
        return cwe;
	}
	
}
