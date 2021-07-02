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
 * @created 2021
 */
package org.owasp.benchmark.score;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Map;
import org.owasp.benchmark.score.TestSuiteResults.ToolType;
import org.owasp.benchmark.score.report.ScatterTools;
import org.owasp.benchmark.score.report.ToolBarChart;
import org.owasp.benchmark.score.report.ToolReport;

public class Tool implements Comparable<Tool> {

    /*
     * This class contains all the details for a specific tool, including all the results scored for the tool.
     * A side effect of creating an instance of Tool is that the HTML report for this tool, and the .csv actual results files
     * are both created to support scorecard generation.
     */

    private final boolean isCommercial;
    private final ToolType toolType;
    private String toolName = "not specified";
    private final String toolNameAndVersion;
    private final String testSuiteVersion;
    private final Map<String, TP_FN_TN_FP_Counts> scores; // This tool's scores per category.
    private final TestSuiteResults actualResults;
    private final ToolResults overallResults; // The scored results for this tool.
    private final String actualResultsFileName; // Name of this tool's .csv computed results file

    // The name of the file that contains this tool's scorecard, without the file extension
    private String scorecardFilename = null;

    public Tool(
            TestSuiteResults actualResults,
            Map<String, TP_FN_TN_FP_Counts> scores,
            ToolResults toolResults,
            String actualCSVResultsFileName,
            boolean isCommercial)
            throws IOException, URISyntaxException {

        this.isCommercial = isCommercial;
        this.toolType = actualResults.toolType;
        this.toolName = actualResults.getToolName();
        this.toolNameAndVersion = actualResults.getToolNameAndVersion();
        this.testSuiteVersion = actualResults.getTestSuiteVersion();

        this.scores = scores;
        this.actualResults = actualResults;
        this.overallResults = toolResults;
        this.actualResultsFileName = actualCSVResultsFileName;

        this.scorecardFilename =
                BenchmarkScore.TESTSUITE
                        + " v"
                        + this.testSuiteVersion
                        + " Scorecard for "
                        + this.toolNameAndVersion;
        this.scorecardFilename = scorecardFilename.replace(' ', '_');
    }

    void generateScorecard(Map<String, CategoryResults> overallAveToolResults, File scoreCardDir) {

        // Generate the HTML scorecard for this tool
        if (!(BenchmarkScore.showAveOnlyMode && this.isCommercial)) {

            // Generate and save the Scatter Chart for this tool
            String shortTitle =
                    BenchmarkScore.TESTSUITE
                            + " v"
                            + this.testSuiteVersion
                            + " Scorecard for "
                            + this.toolName;
            ScatterTools graph = new ScatterTools(shortTitle, 800, this.overallResults);

            File img = new File(scoreCardDir, scorecardFilename + ".png");
            try {
                graph.writeChartToFile(img, 800);
            } catch (IOException e) {
                System.out.println("Error saving tool Scatter chart to disk!");
                e.printStackTrace();
            }

            // Generate the Precision/Recall charts for this tool
            ToolBarChart.generateComparisonCharts(this, overallAveToolResults, scoreCardDir);

            String reportPath =
                    scoreCardDir.getAbsolutePath() + File.separator + scorecardFilename + ".html";
            String fullTitle =
                    BenchmarkScore.fullTestSuiteName(BenchmarkScore.TESTSUITE)
                            + " Scorecard for "
                            + this.toolNameAndVersion;
            // If not in anonymous mode OR the tool is not commercial, add the type at the end of
            // the name. It's not added to anonymous commercial tools, because it would be
            // redundant.
            if (!BenchmarkScore.anonymousMode || !this.isCommercial) {
                fullTitle += " (" + this.toolType + ")";
            }

            String reportHtml;
            try {
                reportHtml =
                        ToolReport.generateHtml(
                                this,
                                fullTitle,
                                img,
                                this.actualResultsFileName,
                                overallAveToolResults);
                Files.write(new File(reportPath).toPath(), reportHtml.getBytes());
                System.out.println("Scorecard written to: " + reportPath);
            } catch (Exception e) {
                System.out.println("Error creating and/or saving tool HTML scorecard!");
                e.printStackTrace();
            }
        }
    }

    /**
     * Gets the name of this tool.
     *
     * @return Name of the tool.
     */
    public String getToolName() {
        return this.toolName;
    }

    public String getToolNameAndVersion() {
        return this.toolNameAndVersion;
    }

    public boolean isCommercial() {
        return this.isCommercial;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public String getTestSuiteVersion() {
        return this.testSuiteVersion;
    }

    /**
     * Gets the name of the file that contains the generated HTML scorecard for this tool.
     *
     * @return Name of the file (without any path information and the file extension)
     */
    public String getScorecardFilename() {
        return this.scorecardFilename;
    }

    /**
     * Gets the actual unscored results for this tool.
     *
     * @return the actual results for this tool.
     */
    public TestSuiteResults getActualResults() {
        return this.actualResults;
    }

    /**
     * Gets the scored results for this tool.
     *
     * @return the overall results for this tool.
     */
    public ToolResults getOverallResults() {
        return this.overallResults;
    }

    /**
     * Compares the name and version of this tool, to the name and version of the supplied tool.
     * Used to sort Tools by tool name and version.
     */
    public int compareTo(Tool r) {
        return this.getToolNameAndVersion()
                .toLowerCase()
                .compareTo(r.getToolNameAndVersion().toLowerCase());
    }

    public Map<String, TP_FN_TN_FP_Counts> getScores() {
        return this.scores;
    }
}
