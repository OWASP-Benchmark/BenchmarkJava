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

import org.owasp.benchmark.score.BenchmarkScore;

/*
 * This class contains the actual results for a single tool against the entire Benchmark, or the 
 * expected results, if its initialized with the expected results file.
 */

public class TestResults {

	// The types of tools that can generate results
	public static enum ToolType {
		SAST,
		DAST,
		IAST,
		Hybrid
	}
	
	private static int nextCommercialSAST_ToolNumber = 1;
	private static int nextCommercialDAST_ToolNumber = 1;
	private static int nextCommercialIAST_ToolNumber = 1;
	
	// The version of the Benchmark these test results are for
	private String benchmarkVersion = "notSet";
	
	private String toolName = "Unknown Tool";
    private String toolVersion = null;
	private String time = "Unknown";
	public final boolean isCommercial;
	public final ToolType toolType;
	private Map<Integer, List<TestCaseResult>> map = new TreeMap<Integer, List<TestCaseResult>>();
	
	// Used to track if this tool has been anonymized
	private boolean anonymous = false;
	
	public TestResults( String toolname, boolean isCommercial, ToolType toolType) {
	    this.setTool( toolname );
	    this.isCommercial = isCommercial;
	    this.toolType = toolType;
	}
	
	// Set the Benchmark version number for this specific set of TestResults
	public void setBenchmarkVersion( String version ) {
		this.benchmarkVersion = version;
	}
	
	public String getBenchmarkVersion() {
		return this.benchmarkVersion;
	}
	
	public ToolType getToolType() {
	    return toolType;
	}
	
	public boolean isCommercial() {
	    return isCommercial;
	}
	
	public void put( TestCaseResult tcr ) {
		List<TestCaseResult> results = map.get( tcr.getNumber() );
		if ( results == null ) {
			results = new ArrayList<TestCaseResult>();
			map.put( tcr.getNumber(),  results );
		}
		results.add( tcr );
	}
	
	public List<TestCaseResult> get( int tn ) {
		return map.get( tn );
	}

	public Set<Integer> keySet() {
		return map.keySet();
	}
    
	/**
	 * Get the name of the tool. e.g., "IBM AppScan"
	 * @return Name of the tool.
	 */
    public String getTool() {
        return this.toolName;
    }

	/**
	 * Get the name of the tool and its version together. e.g., "IBM AppScan v4.2". But if the tool is commercial,
	 * and its in anonymous mode then don't include the version number as that could give away the tool.
	 * @return Name of the tool.
	 */
    public String getToolNameAndVersion() {
    	if (!anonymous && this.toolVersion != null && !"".equals(this.toolVersion) && 
    		!(BenchmarkScore.anonymousMode && this.isCommercial)) {
            return this.toolName + " v" + this.toolVersion;
    	}
        return this.toolName;
    }
    
    public String getToolVersion() {
        return toolVersion;
    }
	
    /**
     * Sets the name of the tool. e.g., "HP Fortify"
     * @param tool - Name of the tool.
     */
	public void setTool( String toolName ) {
	    this.toolName = toolName;
	}

	/**
	 * This method anonymizes the tool name based on the type of tool it is and the count of previous 
	 * tools of the same type that also have been anonymized.
	 */
	public void setAnonymous() {
		//System.out.println("Anonymizing tool: " + this.getTool() + " which is of type: " + getToolType());
		this.anonymous = true;

		switch (getToolType()) {
			case SAST : {
				if (nextCommercialSAST_ToolNumber < 10) {
					this.setTool("SAST-0" + nextCommercialSAST_ToolNumber++);
				} else this.setTool("SAST-" + nextCommercialSAST_ToolNumber++);
				break;
			}
			case DAST : {
				if (nextCommercialDAST_ToolNumber < 10) {
					this.setTool("DAST-0" + nextCommercialDAST_ToolNumber++);
				} else this.setTool("DAST-" + nextCommercialDAST_ToolNumber++);				
				break;
			}
			case IAST : {
				if (nextCommercialIAST_ToolNumber < 10) {
					this.setTool("IAST-0" + nextCommercialIAST_ToolNumber++);
				} else this.setTool("IAST-" + nextCommercialIAST_ToolNumber++);				
			}
		}
	}
	
	public void setToolVersion( String version ) {
	    this.toolVersion = version;
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
		    this.setTime(formatTime(seconds*1000));
		} catch (Exception e) {
			this.setTime("Time not specified");
		}
    }

    // We had to create a custom method for Fortify since we extract the contents of the .fpr
    // file out into a temp file whose name looks like this:
    //      Benchmark_1.1-Fortify-13121.fpr8111236727473243675.fvdl

    public void setFortifyTime ( File f ) {
		String filename = f.getName();
		// to make the same as normal filenames, strip off the '.fvdl' at the end of the filename
		filename = filename.substring (0, filename.lastIndexOf('.')-1);
		String time = filename.substring(filename.lastIndexOf('-')+1, filename.lastIndexOf('.'));
		try {
			int seconds = Integer.parseInt(time);
		    this.setTime(formatTime(seconds*1000));
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
        if (millis < 0)
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
    
    /**
     * Convert the time it took to compute these results into a label to add to the scorecard.
     * @param millis - compute time in milliseconds
     * @return a String label of the compute time. (e.g., 1 Days 2:55:32)
     */
    public static String formatTime(String millis) {

    	String result;
        try {
        	long time = Long.valueOf(millis);
        	result = formatTime(time);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Provided value must be in integer in milliseconds. Value was: " 
            	+ millis);
        }
        return result;
    }
    
    public String getShortName() {
        return this.toolName;
    }
    
}
