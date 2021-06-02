/**
 * OWASP Benchmark Project
 *
 * <p>This file is part of the Open Web Application Security Project (OWASP) Benchmark Project For
 * details, please see <a
 * href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 *
 * <p>The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * <p>The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details.
 *
 * @author Dave Wichers
 * @created 2015
 */
package org.owasp.benchmark.score;

public class CategoryResults {
    public final String category;
    public final double truePositiveRate;
    public final double falsePositiveRate;
    public final int total;
    public final double score;

    /**
     * The overall results for a single vulnerability category for a single tool.
     *
     * @param category - The vulnerability category.
     * @param tpr - The true positive rate
     * @param fpr - The false positive rate
     * @param total - The total number of TP, FP, TN, FN in this category
     * @param score - The tool's score in this category
     */
    public CategoryResults(String category, double tpr, double fpr, int total, double score) {
        if (Double.isNaN(fpr)) {
            throw new IllegalArgumentException(
                    "ERROR: false positive rate for category: " + category + " is NaN");
        }
        if (Double.isNaN(tpr)) {
            throw new IllegalArgumentException(
                    "ERROR: true positive rate for category: " + category + " is NaN");
        }

        this.category = category;
        this.truePositiveRate = tpr;
        this.falsePositiveRate = fpr;
        this.total = total;
        this.score = score;
    }
}
