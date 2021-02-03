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

/* This class represents a single test case result. It documents the expected result (real), 
 * and the actual result (result).
 */

public class TestCaseResult {

	private String testCaseName = "";
	private int number = 0;
	private boolean real = false;
	private boolean result = false;
	private int CWE = 0;
	private String category = null;
	private String evidence = null;
	private int confidence = 0;
	
	// optional attributes
	private String source = null;
	private String dataflow = null;
	private String sink = null;
	
	/*
	 *  Set the name of the test case (E.g., BenchmarkTest00001). This is frequently only used for 
	 *  expected results, not actual results. Expected to actual can be correlated by the test number.
	 */
	public void setTestCaseName (String name) {
		this.testCaseName = name;
	}
	
	/*
	 * The name of the test case. E.g., BenchmarkTest00001
	 */
	public String getName() {
		return testCaseName;
	}
	
	public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public int getNumber() { 
		return number;
	}
	
	public void setNumber( int number ) {
		this.number = number;
	}
	
	public boolean isReal() {
		return real;
	}

	public void setReal(boolean real) {
		this.real = real;
	}

	public boolean isPassed() {
		return result;
	}

	public void setPassed(boolean result) {
		this.result = result;
	}

	public int getCWE() {
		return CWE;
	}

	public void setCWE(int cwe) {
		this.CWE = cwe;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEvidence() {
		return evidence;
	}
	
	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}
	
	public String getSource() {
		return this.source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}

	public String getDataFlow() {
		return this.dataflow;
	}
	
	public void setDataFlow(String dataflow) {
		this.dataflow = dataflow;
	}

	public String getSink() {
		return this.sink;
	}
	
	public void setSink(String sink) {
		this.sink = sink;
	}

	public String toString() {
		return getNumber() + "," + getCategory() + "," + isReal() + "," + getCWE() + "," + isPassed() + "," + getEvidence() + "," + getConfidence();
	}
}
