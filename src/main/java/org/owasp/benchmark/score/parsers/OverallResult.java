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

public class OverallResult {
	public String category;
	public double tpr;
	public double fpr;
	public int total;
	public double score;
	
	public OverallResult( String category, double tpr, double fpr, int total, double score) {
		this.category = category;
		this.tpr = tpr;
		this.fpr = fpr;
		this.total = total;
		this.score = score;
	}

	public String getCategory() {
	    return category;
	}
	
    public double getFalsePositiveRate() {
        return fpr;
    }

    public double getTruePositiveRate() {
        return tpr;
    }

    public double getScore() {
        return score;
    }
}
