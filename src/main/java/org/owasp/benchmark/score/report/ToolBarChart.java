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
package org.owasp.benchmark.score.report;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.DefaultCategoryDataset;
import org.owasp.benchmark.score.BenchmarkScore;
import org.owasp.benchmark.score.CategoryResults;
import org.owasp.benchmark.score.Tool;

public class ToolBarChart extends ScatterPlot {

    private static final Color BLUECOLUMN = Color.decode("#4572a7"); // Blue
    private static final Color PURPLECOLUMN = Color.decode("#7851a9"); // Royal purple

    public enum BarChartType {
        Precision,
        Recall
    }

    public static void initializePlot(
            JFreeChart chart, DefaultCategoryDataset dataset, Color toolColor) {
        CategoryPlot xyplot = chart.getCategoryPlot();
        CategoryItemRenderer renderer = xyplot.getRendererForDataset(dataset);
        renderer.setSeriesPaint(0, toolColor); // Set tool column color
        renderer.setSeriesPaint(1, new Color(190, 190, 190)); // Set gray column color
        renderer.setDefaultOutlinePaint(new Color(0, 0, 0)); // Set black column border

        NumberAxis rangeAxis = (NumberAxis) xyplot.getRangeAxis();

        rangeAxis.setRange(0, 100);
        rangeAxis.setNumberFormatOverride(pctFormat);
        rangeAxis.setTickLabelPaint(Color.decode("#666666"));
        rangeAxis.setMinorTickCount(5);
        rangeAxis.setTickUnit(new NumberTickUnit(10));
        rangeAxis.setAxisLineVisible(true);
        rangeAxis.setMinorTickMarksVisible(true);
        rangeAxis.setTickMarksVisible(true);
        rangeAxis.setLowerMargin(10);
        rangeAxis.setUpperMargin(10);

        xyplot.setRangeGridlineStroke(new BasicStroke());
        xyplot.setRangeGridlinePaint(Color.lightGray);
        xyplot.setRangeMinorGridlinePaint(Color.decode("#DDDDDD"));
        xyplot.setRangeMinorGridlinesVisible(true);
        xyplot.setOutlineVisible(true);
        xyplot.setDomainGridlineStroke(new BasicStroke());
        xyplot.setDomainGridlinePaint(Color.lightGray);

        BarRenderer brenderer = (BarRenderer) xyplot.getRenderer();
        brenderer.setItemMargin(0); // Eliminate space between bars within vuln category

        chart.setTextAntiAlias(true);
        chart.setAntiAlias(true);
        chart.setPadding(new RectangleInsets(20, 20, 0, 20));
    }

    /**
     * Create a BarChart of the specified type and store it in a file in the specified directory.
     *
     * @param tool - The tool to create the chart for.
     * @param dataset - The dataset that contains this tool's results and the results to compare it
     *     to.
     * @param type - The Type of BarChart to create.
     * @param scoreCardDir - The directory to write the created Chart file into.
     * @return The name of the file created (with no path information).
     */
    public static String createBarChart(
            Tool tool, DefaultCategoryDataset dataset, BarChartType type, File scoreCardDir) {

        JFreeChart chart =
                ChartFactory.createBarChart(
                        tool.getToolNameAndVersion()
                                + " "
                                + type.name()
                                + " Results by Weakness Class",
                        "",
                        type.name(),
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        false,
                        false);
        theme.apply(chart);

        switch (type) {
            case Precision:
                initializePlot(chart, dataset, BLUECOLUMN);
                break;
            case Recall:
                initializePlot(chart, dataset, PURPLECOLUMN);
                break;
        }

        String fileToCreate = generateBarChartFileName(tool, type);
        File barChartFile = new File(scoreCardDir, fileToCreate);
        try {
            writeChartToFile(barChartFile, chart, 800);
        } catch (IOException e) {
            System.out.println("Error writing bar chart to target file.");
            e.printStackTrace();
            return null;
        }
        return fileToCreate;
    }

    /**
     * createBarChart() uses this method to create the filenames for the generated .png files. So
     * you can invoke this again outside the class to find those files. It generates these files in
     * the scorecardDir directory.
     *
     * @param tool - The tool to generate the Bar chart for.
     * @param type - The type of Bar chart to create.
     * @return - The filename to write this type of Bar chart to.
     */
    public static String generateBarChartFileName(Tool tool, BarChartType type) {

        String filename =
                BenchmarkScore.TESTSUITE
                        + " v"
                        + tool.getTestSuiteVersion()
                        + " "
                        + type.name()
                        + " Chart for "
                        + tool.getToolNameAndVersion()
                        + ".png";
        filename = filename.replace(' ', '_');
        return filename;
    }

    /**
     * Create a jFree chart DataSet that contains the scores per category for 1 tool, and the
     * average scores across all tools.
     *
     * @param targetTool - The tool to create the chart for.
     * @param aveToolResults - The average tool results across all tools.
     * @param type - The Type of Bar Chart to create.
     * @return The created DataSet.
     */
    public static DefaultCategoryDataset createToolDataSet(
            Tool targetTool, Map<String, CategoryResults> aveToolResults, BarChartType type) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        final String TOOLNAME = targetTool.getToolNameAndVersion();

        Collection<CategoryResults> toolCatResults =
                targetTool.getOverallResults().getCategoryResults();
        for (CategoryResults catResults : toolCatResults) {

            double data = -1.0;
            switch (type) {
                case Precision:
                    data = catResults.precision;
                    break;
                case Recall:
                    data = catResults.truePositiveRate;
                    break;
            }
            dataset.addValue(
                    data * 100,
                    TOOLNAME,
                    BenchmarkScore.CATEGORIES.getByName(catResults.category).getShortName());
        }

        Collection<CategoryResults> aveCatResults = aveToolResults.values();
        for (CategoryResults catResults : aveCatResults) {

            double data = -1.0;
            switch (type) {
                case Precision:
                    data = catResults.precision;
                    break;
                case Recall:
                    data = catResults.truePositiveRate;
                    break;
            }
            dataset.addValue(
                    data * 100,
                    "Average",
                    BenchmarkScore.CATEGORIES.getByName(catResults.category).getShortName());
        }

        return dataset;
    }

    /**
     * Generate Bar charts that compare a tool's Precision and Recall results to the average of all
     * the other tools and write those charts to tool/metric specific names.
     *
     * @param tool - The Tool to create the charts for.
     * @param overallAveToolResults - A Map of each vuln category to the average CategoryResults for
     *     that category.
     */
    public static void generateComparisonCharts(
            Tool tool, Map<String, CategoryResults> overallAveToolResults, File scoreCardDir) {

        if (BenchmarkScore.includePrecision) {
            Set<String> precisionChartFilenames = new HashSet<String>();

            // Generate Precision Chart
            // First create the Dataset required for the chart
            DefaultCategoryDataset toolPrecisionData =
                    ToolBarChart.createToolDataSet(
                            tool, overallAveToolResults, ToolBarChart.BarChartType.Precision);
            // Then create the chart
            ToolBarChart.createBarChart(
                    tool, toolPrecisionData, ToolBarChart.BarChartType.Precision, scoreCardDir);

            // Generate Recall Chart
            DefaultCategoryDataset toolRecallData =
                    ToolBarChart.createToolDataSet(
                            tool, overallAveToolResults, ToolBarChart.BarChartType.Recall);
            ToolBarChart.createBarChart(
                    tool, toolRecallData, ToolBarChart.BarChartType.Recall, scoreCardDir);
        }
    }
}
