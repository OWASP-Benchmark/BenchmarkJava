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
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class SonarQubeReader extends Reader {
	
	public TestResults parse( File f ) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(f.getPath())));

	    JSONArray arr = new JSONArray( content );
	    
	    TestResults tr = new TestResults( "SonarQube" ,false,TestResults.ToolType.SAST);

	    tr.setTime(f);
	    
	    for (int i = 0; i < arr.length(); i++)
	    {
            TestCaseResult tcr = parseSonarQubeFinding( arr.getJSONObject(i) );
            if ( tcr != null ) {
                // System.out.println( tcr.getNumber() + " " + tcr.getName() + " -> " + tcr.getCWE() + "\t" + tcr.getEvidence() );
                tr.put( tcr );
            }
	    }
	    
		return tr;
	}
	
	private TestCaseResult parseSonarQubeFinding(JSONObject finding) {
		try {
		    TestCaseResult tcr = new TestCaseResult();    	
	        tcr.setConfidence( 5 );
	        
    		String filename = finding.getString("component");
    		filename = filename.substring( filename.lastIndexOf( '/' ) );
    		String testNumber = filename.substring( "BenchmarkTest".length() + 1, filename.length() - 5 );
    		tcr.setNumber( Integer.parseInt( testNumber ) );
    		
    		String squidNumber = finding.getString( "rule" );
    		squidNumber = squidNumber.substring( "squid:".length() );
    		tcr.setCWE( SonarQubeLegacyReader.cweLookup(squidNumber) );
    				
            tcr.setCategory( finding.getString( "message" ) );
            
            tcr.setEvidence( finding.getString( "message" ) );
        
            return tcr;
		} catch (Exception e ) {
		    // e.printStackTrace();
		    return null;
		}
	}
	

}
