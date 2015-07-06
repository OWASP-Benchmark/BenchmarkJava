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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/*
 * This class contains the actual results for a single tool against the entire Benchmark.
 */

public class TestResults {
	private String tool = "Unknown Tool";
	private String time = "Unknown";
	
	private Map<Integer, List<TestCaseResult>> map = new TreeMap<Integer, List<TestCaseResult>>();
		
	public void put( TestCaseResult tr ) {
		List<TestCaseResult> results = map.get( tr.getNumber() );
		if ( results == null ) {
			results = new ArrayList<TestCaseResult>();
			map.put( tr.getNumber(),  results );
		}
		results.add( tr );
	}
	
	public List<TestCaseResult> get( int tn ) {
		return map.get( tn );
	}

	public Set<Integer> keySet() {
		return map.keySet();
	}
	
	public String getTool() {
	    return tool;
	}
	
	public void setTool( String tool ) {
	    this.tool = tool;
	}
	

    public String getTime() {
        return time;
    }
    
    public void setTime( String elapsed ) {
        this.time = elapsed;
    }
    
    public void setTime ( File f ) {
		String filename = f.getName();
		String time = filename.substring(filename.lastIndexOf('-')+1, filename.lastIndexOf('.'));
		try {
			int seconds = Integer.parseInt(time);
		    this.setTime(this.formatTime(seconds*1000));
		} catch (Exception e) {
			this.setTime("Time not specified");
		}
    }
    
    public int totalResults() {
    	return map.size();
    }

    /**
     * Convert the time it took to compute these results into a label to add to the scorecard.
     * @param millis - compute time in milliseconds
     * @return a String label of the compute time. (e.g., 1 Days 2:55:32)
     */
    public static String formatTime(long millis)
    {
        if(millis < 0)
        {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
        if (days > 0) {
        	sb.append(days);
	        if (days > 1 )
	        	sb.append(" Days "); 
	        else sb.append(" Day ");
        }
        sb.append(hours);
        if (minutes > 9) sb.append(":"); else sb.append(":0");
        sb.append(minutes);
        if (seconds > 9) sb.append(":"); else sb.append(":0");
        sb.append(seconds);

        return(sb.toString());
    }  
    
}
