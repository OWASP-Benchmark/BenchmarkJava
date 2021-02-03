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
* @author Dave Wichers
* @created 2015
*/

package org.owasp.benchmark.score.parsers;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/*
 * This class holds the overall results for a single tool's scan of the Benchmark. It contains an OverallResult for 
 * each vulnerability category in the Benchmark. It also contains some overall results data like the overall score, 
 * and the true positive and false positive rates.
 */
public class OverallResults {

	private Map<String,OverallResult> map = new TreeMap<String,OverallResult>();
	private double score = 0;  // The overall score for this tool
	private int total = 0; // The total number of TP, FP, FN, TN across all test cases for this tool.
	
	// The overall True and False positive rates for this tool. These are values between 1 and 0.
	private double TPRate = 0;
	private double FPRate = 0;
	
	private Counter findingCounts;
	
    private String time = "Unknown";

	public void add( String category, double tpr, double fpr, int total, double score ) {
		OverallResult r = new OverallResult( category, tpr, fpr, total, score );
		map.put( category, r );
	}
	
	/**
	 * Get the overall results for a particular vulnerability category.
	 * @param category
	 * @return The OverallResult for the specified vulnerability category. Null if the category isn't found.
	 */
	public OverallResult getResults( String category) {
		return map.get(category);
	}

	/**
	 * Get the overall results for this tool across all vulnerability categories.
	 * @return A collection of the OverallResults.
	 */
	public Collection<OverallResult> getResults() {
	    return map.values();
	}

	public Collection<String> getCategories() {
	    return map.keySet();
	}
	
	/**
	 * Returns the overall score for this tool. This is the True Positive Rate - the False Positive rate.
	 * @return This tool's overall score.
	 */
    public double getScore() {
        return score;
    }

	/**
	 * Sets the overall score for this tool. This is supposed to be the True Positive Rate - the False Positive rate.
	 */
    public void setScore(double score) {
        this.score = score;
    }

	/**
	 * Returns the true positive rate for this tool.
	 * @return This tool's true positive rate.
	 */
    public double getTruePositiveRate() {
        return TPRate;
    }

	/**
	 * Sets the true positive rate for this tool.
	 */
    public void setTruePositiveRate(double rate) {
        this.TPRate = rate;
    }

	/**
	 * Returns the false positive rate for this tool.
	 * @return This tool's true positive rate.
	 */
    public double getFalsePositiveRate() {
        return FPRate;
    }

	/**
	 * Sets the false positive rate for this tool.
	 */
    public void setFalsePositiveRate(double rate) {
        this.FPRate = rate;
    }

    /**
     * Returns the total number of test cases processed with this tool.
     * @return The total.
     */
    public int getTotal() {
        return total;
    }
    
    /**
     * Set the total number of test cases processed with this tool.
     * @param The total.
     */
    public void setTotal( int total ) {
        this.total = total;
    }

    /**
     * Returns the amount of time it took to run a scan of the Benchmark with this tool.
     * @return The Benchmark scan time.
     */
    public String getTime() {
        return time;
    }

    /**
     * Set the amount of time it took to run a scan of the Benchmark with this tool.
     * @param The elapsed time.
     */
    public void setTime( String elapsed ) {
        this.time = elapsed;
    }

    public void setFindingCounts(int tp, int fp, int fn, int tn) {
    	this.findingCounts = new Counter();
    	this.findingCounts.tp = tp;
    	this.findingCounts.fp = fp;
    	this.findingCounts.fn = fn;
    	this.findingCounts.tn = tn;
    }

    public Counter getFindingCounts() {
    	return this.findingCounts;
    }

}
