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

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/*
 * This class holds all the test results for a single tool's scan of a test suite. It contains CategoryResults for
 * each vulnerability category in the test suite. It also contains some overall results data like the overall score,
 * and the true positive and false positive rates.
 */
public class ToolResults {

    // A map of the category name to the results for each category for a specific tool.
    private Map<String, CategoryResults> categoryResultsMap =
            new TreeMap<String, CategoryResults>();
    private double score =
            0; // The overall score for this tool. Autocalculated when TPR or FPR changed.
    private int total =
            0; // The total number of TP, FP, FN, TN across all test cases for this tool.

    // The overall rates for this tool. These are values between 1 and 0, except maybe F-Score.
    private double precision = 0; // TP / (TP + FP)
    private double TPRate = 0; // TPR is also Recall (TP / (TP + FN))
    private double FPRate = 0;
    private double FScore =
            0; // 2 * precision * TPR / (Precision + TPR). Autocalculated when values changed.

    private TP_FN_TN_FP_Counts findingCounts;

    private String time = "Unknown";

    /**
     * Add the results for a specific category to the results for this tool. Note that this add()
     * does not automatically update any of the overall results for this tool. You must do that
     * yourself via the setters for this class.
     *
     * @param category - The vuln category.
     * @param precision - Precision score in this category.
     * @param tpr - True Positive Rate in this category.
     * @param fpr - False Positive Rate in this category.
     * @param total - Total number of results in this category.
     */
    public void add(String category, double precision, double tpr, double fpr, int total) {
        CategoryResults r = new CategoryResults(category, precision, tpr, fpr, total);
        categoryResultsMap.put(category, r);
    }

    /**
     * Get the results for a particular vulnerability category.
     *
     * @param category
     * @return The OverallResult for the specified vulnerability category. Null if the category
     *     isn't found.
     */
    public CategoryResults getCategoryResults(String category) {
        return this.categoryResultsMap.get(category);
    }

    /**
     * Get the results for this tool across all vulnerability categories.
     *
     * @return A collection of the OverallResults.
     */
    public Collection<CategoryResults> getCategoryResults() {
        return this.categoryResultsMap.values();
    }

    public Collection<String> getCategories() {
        return this.categoryResultsMap.keySet();
    }

    /**
     * Returns the overall score for this tool. This is the True Positive Rate - the False Positive
     * rate.
     *
     * @return This tool's overall score.
     */
    public double getOverallScore() {
        return this.score;
    }

    /**
     * Returns the overall F-score for this tool. Calculated as: 2 * precision * TPR / (Precision +
     * TPR)
     *
     * @return This tool's overall F-score.
     */
    public double getFScore() {
        return this.FScore;
    }

    /**
     * Returns the true positive rate for this tool.
     *
     * @return This tool's true positive rate.
     */
    public double getPrecision() {
        return this.precision;
    }

    /** Sets the precision for this tool, and updates F-Score. */
    public void setPrecision(double precision) {
        // Update the F-Score since it depends on precision and TPR.
        double fscore = 2 * precision * this.TPRate / (precision + this.TPRate);
        if (Double.isNaN(fscore)) {
            this.FScore = 0.0;
        } else this.FScore = fscore;
        this.precision = precision;
    }

    /**
     * Returns the true positive rate for this tool.
     *
     * @return This tool's true positive rate.
     */
    public double getTruePositiveRate() {
        return this.TPRate;
    }

    /** Sets the true positive rate for this tool, updates F-Score, and updates overall score. */
    public void setTruePositiveRate(double rate) {
        // Update the F-Score since it depends on precision and TPR.
        double fscore = 2 * this.precision * rate / (this.precision + rate);
        if (Double.isNaN(fscore)) {
            this.FScore = 0.0;
        } else this.FScore = fscore;
        this.TPRate = rate;

        // Also update score
        this.score = rate - this.FPRate;
    }

    /**
     * Returns the false positive rate for this tool.
     *
     * @return This tool's true positive rate.
     */
    public double getFalsePositiveRate() {
        return this.FPRate;
    }

    /** Sets the false positive rate for this tool, and updates overall score. */
    public void setFalsePositiveRate(double rate) {
        this.FPRate = rate;
        // Also update score
        this.score = this.TPRate - rate;
    }

    /**
     * Returns the total number of test cases processed with this tool.
     *
     * @return The total.
     */
    public int getTotalTestCases() {
        return this.total;
    }

    /**
     * Set the total number of test cases processed with this tool.
     *
     * @param The total.
     */
    public void setTotalTestCases(int total) {
        this.total = total;
    }

    /**
     * Returns the amount of time it took to run a scan of the Benchmark with this tool.
     *
     * @return The Benchmark scan time.
     */
    public String getScanTime() {
        return this.time;
    }

    /**
     * Set the amount of time it took to run a scan of the Benchmark with this tool.
     *
     * @param The elapsed time.
     */
    public void setScanTime(String elapsed) {
        this.time = elapsed;
    }

    public void setFindingCounts(int tp, int fp, int fn, int tn) {
        this.findingCounts = new TP_FN_TN_FP_Counts();
        this.findingCounts.tp = tp;
        this.findingCounts.fp = fp;
        this.findingCounts.fn = fn;
        this.findingCounts.tn = tn;
    }

    public TP_FN_TN_FP_Counts getFindingCounts() {
        return this.findingCounts;
    }
}
