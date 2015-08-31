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
	public final String category;
	public final double truePositiveRate;
	public final double falsePositiveRate;
	public final int total;
	public final double score;
	
	/**
	 * The overall results for a single vulnerability category for a single tool.
	 * @param category - The vulnerability category.
	 * @param tpr - The true positive rate
	 * @param fpr - The false positive rate
	 * @param total - The total number of TP, FP, TN, FN in this category 
	 * @param score - The tool's score in this category
	 */
	public OverallResult( String category, double tpr, double fpr, int total, double score) {
		this.category = category;
		this.truePositiveRate = tpr;
		this.falsePositiveRate = fpr;
		this.total = total;
		this.score = score;
	}
	
}
