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

/* This class represents a single test case result. It documents the expected result (real), 
 * and the actual result (result).
 */

public class TestCaseResult {

	String testCaseName = "";
	int number = 0;
	boolean real = false;
	boolean result = false;
	int CWE = 0;
	String category = null;
	String evidence = null;
	int confidence = 0;
	
	
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
	
	public String toString() {
		return getNumber() + "," + getCategory() + "," + isReal() + "," + getCWE() + "," + isPassed() + "," + getEvidence() + "," + getConfidence();
	}
}
