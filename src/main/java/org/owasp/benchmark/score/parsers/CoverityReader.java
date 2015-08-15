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

public class CoverityReader extends Reader {
	
	public TestResults parse( File f ) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(f.getPath())));

	    JSONObject obj = new JSONObject(content);

	    JSONArray arr = obj.getJSONArray("mergedIssues");

	    TestResults tr = new TestResults( "Coverity Code Advisor" ,true,TestResults.ToolType.SAST); // Coverity's tool is called Code Advisor or Code Advisor On Demand
	    // Fixme: See if we can figure this out from some of the files they provide
	    tr.setTime(f);
	    
	    for (int i = 0; i < arr.length(); i++)
	    {
            TestCaseResult tcr = parseCoverityFinding( arr.getJSONObject(i) );
            if ( tcr != null ) {
                tr.put( tcr );
            }
	    }
	    
		return tr;
	}
	
	private TestCaseResult parseCoverityFinding(JSONObject finding) {
		try {
		    TestCaseResult tcr = new TestCaseResult();
    	
    		String filename = finding.getJSONArray("occurrences").getJSONObject(0).getString("mainEventFilePathname");
    		filename = filename.substring( filename.lastIndexOf( '/' ) );
    		String testNumber = filename.substring( "BenchmarkTest".length() + 1, filename.length() - 5 );
    		tcr.setNumber( Integer.parseInt( testNumber ) );
    		
    		String cweNumber = finding.getString( "cweNumber" );
    		int cwe = Integer.parseInt( cweNumber );
            if ( cwe == 94 ) cwe = 643;
            if ( cwe == 36 ) cwe = 22;
            if ( cwe == 23 ) cwe = 22;
    		tcr.setCWE( cwe );
    				
            tcr.setCategory( finding.getString( "categoryDescription" ) );
            
            tcr.setEvidence( finding.getString( "longDescription" ) );
        
            // tcr.setConfidence( finding.getString( "impact" ));
        
            return tcr;
		} catch (Exception e ) {
		    // e.printStackTrace();
		    return null;
		}
	}
	

}
