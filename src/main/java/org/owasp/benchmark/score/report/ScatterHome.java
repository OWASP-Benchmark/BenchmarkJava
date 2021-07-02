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
package org.owasp.benchmark.score.report;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.owasp.benchmark.score.BenchmarkScore;
import org.owasp.benchmark.score.Tool;
import org.owasp.benchmark.score.ToolResults;

public class ScatterHome extends ScatterPlot {
    private static char averageLabel;
    private double afr = 0;
    private double atr = 0;
    public final String focus;
    public static final char INITIAL_LABEL = 'A';

    /**
     * This calculates the summary chart across all the tools analyzed against a test suite.
     *
     * @param title - The title of the chart to be produced.
     * @param tools - The set of all tools. Each includes that tool's scoring results.
     * @param focus - The toolname to focus on. Blank or null if no tool should be emphasized.
     */
    public ScatterHome(String title, Set<Tool> tools, String focus) {
        this.focus = focus;
        display("          " + title, tools);
    }

    private JFreeChart display(String title, Set<Tool> tools) {

        // averages
        ArrayList<Double> averageCommercialFalseRates = new ArrayList<Double>();
        ArrayList<Double> averageCommercialTrueRates = new ArrayList<Double>();

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Scores");
        for (Tool toolReport : tools) {
            if (!toolReport.isCommercial()) {
                ToolResults overallResults = toolReport.getOverallResults();
                series.add(
                        overallResults.getFalsePositiveRate() * 100,
                        overallResults.getTruePositiveRate() * 100);
                if (toolReport.isCommercial()) {
                    averageCommercialFalseRates.add(overallResults.getFalsePositiveRate());
                    averageCommercialTrueRates.add(overallResults.getTruePositiveRate());
                }
            }
        }

        int commercialToolCount = 0;
        for (Tool toolReport : tools) {
            if (toolReport.isCommercial()) {
                commercialToolCount++;
                ToolResults overallResults = toolReport.getOverallResults();
                if (!BenchmarkScore.showAveOnlyMode) {
                    series.add(
                            overallResults.getFalsePositiveRate() * 100,
                            overallResults.getTruePositiveRate() * 100);
                }
                if (toolReport.isCommercial()) {
                    averageCommercialFalseRates.add(overallResults.getFalsePositiveRate());
                    averageCommercialTrueRates.add(overallResults.getTruePositiveRate());
                }
            }
        }

        for (double d : averageCommercialFalseRates) {
            afr += d;
        }
        afr = afr / averageCommercialFalseRates.size();

        for (double d : averageCommercialTrueRates) {
            atr += d;
        }
        atr = atr / averageCommercialTrueRates.size();

        if (commercialToolCount > 1
                || (BenchmarkScore.showAveOnlyMode && commercialToolCount == 1)) {
            series.add(afr * 100, atr * 100);
        }

        dataset.addSeries(series);

        chart =
                ChartFactory.createScatterPlot(
                        title,
                        "False Positive Rate",
                        "True Positive Rate",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false);
        theme.apply(chart);
        initializePlot(chart);

        XYPlot xyplot = chart.getXYPlot();
        addGenerationDate(xyplot);

        makeDataLabels(tools, xyplot);
        makeLegend(tools, 103, 100.5, dataset, xyplot);

        for (XYDataItem item : (List<XYDataItem>) series.getItems()) {
            double x = item.getX().doubleValue();
            double y = item.getY().doubleValue();
            double z = (x + y) / 2;
            XYLineAnnotation score = new XYLineAnnotation(x, y, z, z, dashed, Color.blue);
            xyplot.addAnnotation(score);
        }

        return chart;
    }

    private void makeDataLabels(Set<Tool> tools, XYPlot xyplot) {
        HashMap<Point2D, String> map = makePointList(tools);
        for (Entry<Point2D, String> e : map.entrySet()) {
            if (e.getValue() != null) {
                Point2D p = e.getKey();
                String label = sort(e.getValue());
                XYTextAnnotation annotation = new XYTextAnnotation(label, p.getX(), p.getY());
                annotation.setTextAnchor(
                        p.getX() < 3 ? TextAnchor.TOP_LEFT : TextAnchor.TOP_CENTER);
                annotation.setBackgroundPaint(Color.white);
                if (label.toCharArray()[0] == averageLabel) {
                    annotation.setPaint(Color.magenta);
                } else {
                    annotation.setPaint(Color.blue);
                }
                annotation.setFont(theme.getRegularFont());
                xyplot.addAnnotation(annotation);
            }
        }
    }

    private static String sort(String value) {
        String[] parts = value.split(",");
        Arrays.sort(parts);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            sb.append(parts[i]);
            if (i < parts.length - 1) sb.append(",");
        }
        return sb.toString();
    }

    static SecureRandom sr = new SecureRandom();
    // This method generates all the points put on the home page chart. One per tool.
    private HashMap<Point2D, String> makePointList(Set<Tool> tools) {
        HashMap<Point2D, String> map = new HashMap<Point2D, String>();
        char ch = INITIAL_LABEL;

        // make a list of all points.  Add in a tiny random to prevent exact duplicate coordinates
        // in map
        int commercialToolCount = 0;
        for (Tool r : tools) {
            if (!r.isCommercial()) {
                ToolResults or = r.getOverallResults();
                double x = or.getFalsePositiveRate() * 100 + sr.nextDouble() * .000001;
                double y =
                        or.getTruePositiveRate() * 100
                                + sr.nextDouble() * .000001
                                - 1; // this puts the label just below the point
                Point2D p = new Point2D.Double(x, y);
                String label = "" + ch;
                map.put(p, label);
                // Weak hack if there are more than 26 tools scored. This will only get us to 52.
                if (ch == 'Z') ch = 'a';
                else ch++;
            }
        }

        for (Tool r : tools) {
            if (r.isCommercial()) {
                commercialToolCount++;
                if (!BenchmarkScore.showAveOnlyMode) {
                    ToolResults or = r.getOverallResults();
                    double x = or.getFalsePositiveRate() * 100 + sr.nextDouble() * .000001;
                    double y =
                            or.getTruePositiveRate() * 100
                                    + sr.nextDouble() * .000001
                                    - 1; // this puts the label just below the point
                    Point2D p = new Point2D.Double(x, y);
                    String label = "" + ch;
                    map.put(p, label);
                    // Weak hack if there are more than 26 tools scored. This will only get us to
                    // 52.
                    if (ch == 'Z') ch = 'a';
                    else ch++;
                }
            }
        }

        if (commercialToolCount > 1
                || (BenchmarkScore.showAveOnlyMode && commercialToolCount == 1)) {
            Point2D ap =
                    new Point2D.Double(
                            afr * 100 + sr.nextDouble() * .000001,
                            atr * 100 + sr.nextDouble() * .000001 - 1);
            averageLabel = ch;
            map.put(ap, "" + ch);
        }

        dedupify(map);
        return map;
    }

    private static void dedupify(HashMap<Point2D, String> map) {
        for (Entry<Point2D, String> e1 : map.entrySet()) {
            Entry<Point2D, String> e2 = getMatch(map, e1);
            while (e2 != null) {
                StringBuilder label = new StringBuilder();
                if (e1.getValue() != null) label.append(e1.getValue());
                if (e1.getValue() != null && e2.getValue() != null) label.append(",");
                if (e2.getValue() != null) label.append(e2.getValue());
                e1.setValue(label.toString());
                e2.setValue(null);
                e2 = getMatch(map, e1);
            }
        }
    }

    private static Entry<Point2D, String> getMatch(
            HashMap<Point2D, String> map, Entry<Point2D, String> e1) {
        for (Entry<Point2D, String> e2 : map.entrySet()) {
            Double xd = Math.abs(e1.getKey().getX() - e2.getKey().getX());
            Double yd = Math.abs(e1.getKey().getY() - e2.getKey().getY());
            boolean close = xd < 1 && yd < 3;
            if (e1 != e2 && e1.getValue() != null && e2.getValue() != null && close) {
                return e2;
            }
        }
        return null;
    }

    private void makeLegend(
            Set<Tool> tools, double x, double y, XYSeriesCollection dataset, XYPlot xyplot) {
        char ch =
                INITIAL_LABEL; // This is the first label in the Key with all the tools processed by
        // this scorecard
        int i = -2; // Used to keep track of which row in the key we are processing. Helps calculate
        // the Y axis location where to put the Key entry

        boolean printedNonCommercialLabel = false;

        // non-commercial results
        for (Tool r : tools) {
            ToolResults or = r.getOverallResults();
            if (!r.isCommercial()) {
                // print non-commercial label if there is at least one non-commercial tool
                if (!printedNonCommercialLabel) {
                    XYTextAnnotation stroketext1 =
                            new XYTextAnnotation("Non-Commercial", x, y + i * -3.3);
                    stroketext1.setTextAnchor(TextAnchor.CENTER_LEFT);
                    stroketext1.setBackgroundPaint(Color.white);
                    stroketext1.setPaint(Color.black);
                    stroketext1.setFont(theme.getRegularFont());
                    xyplot.addAnnotation(stroketext1);
                    i++;
                    printedNonCommercialLabel = true;
                }

                // Special hack to make it line up better if the letter is an 'I' or 'i'
                String label = (ch == 'I' || ch == 'i' ? ch + ":   " : ch + ": ");
                // Another hack to make it line up better if the letter is a 'J' or 'j'
                label = (ch == 'J' || ch == 'j' ? ch + ":  " : label);
                double score = or.getOverallScore() * 100;
                final DecimalFormat DF = new DecimalFormat("#0.0");
                String TPR = DF.format(100 * or.getTruePositiveRate());
                if (TPR.endsWith("0"))
                    TPR = TPR.substring(0, TPR.length() - 2); // trim off .0 if it ends that way.
                String FPR = DF.format(100 * or.getFalsePositiveRate());
                if (FPR.endsWith("0")) FPR = FPR.substring(0, FPR.length() - 2);

                final String TOOL = "\u25A0 " + label + r.getToolNameAndVersion();
                XYTextAnnotation toolLabel = new XYTextAnnotation(TOOL, x, y + i * -3.3);
                toolLabel.setTextAnchor(TextAnchor.CENTER_LEFT);
                toolLabel.setBackgroundPaint(Color.white);
                toolLabel.setPaint(Color.blue);
                toolLabel.setFont(theme.getRegularFont());
                xyplot.addAnnotation(toolLabel);
                final String SCORE = Math.round(score) + "%";
                XYTextAnnotation scoreLabel = new XYTextAnnotation(SCORE, x + 53, y + i * -3.3);
                scoreLabel.setTextAnchor(TextAnchor.CENTER_RIGHT);
                scoreLabel.setBackgroundPaint(Color.white);
                scoreLabel.setPaint(Color.blue);
                scoreLabel.setFont(theme.getRegularFont());
                xyplot.addAnnotation(scoreLabel);
                final String CALC = "(" + TPR + "-" + FPR + ")";
                XYTextAnnotation calcLabel = new XYTextAnnotation(CALC, x + 59, y + i * -3.3);
                calcLabel.setTextAnchor(TextAnchor.CENTER);
                calcLabel.setBackgroundPaint(Color.white);
                calcLabel.setPaint(Color.gray);
                calcLabel.setFont(theme.getSmallFont());
                xyplot.addAnnotation(calcLabel);

                i++;
                // Weak hack if there are more than 26 tools scored. This will only get us to 52.
                if (ch == 'Z') ch = 'a';
                else ch++;
            }
        }

        // commercial tools
        double totalScore = 0;
        boolean printedCommercialLabel = false;
        int commercialToolCount = 0;

        for (Tool r : tools) {

            ToolResults or = r.getOverallResults();
            if (r.isCommercial()) {

                // print commercial label if there is at least one commercial tool
                if (!printedCommercialLabel) {
                    XYTextAnnotation stroketext =
                            new XYTextAnnotation("Commercial", x, y + i * -3.3);
                    stroketext.setTextAnchor(TextAnchor.CENTER_LEFT);
                    stroketext.setBackgroundPaint(Color.white);
                    stroketext.setPaint(Color.black);
                    stroketext.setFont(theme.getRegularFont());
                    xyplot.addAnnotation(stroketext);
                    i++;
                    printedCommercialLabel = true;
                }

                commercialToolCount++;
                // Special hack to make it line up better if the letter is an 'I' or 'i'
                String label = (ch == 'I' || ch == 'i' ? ch + ":   " : ch + ": ");
                // Another hack to make it line up better if the letter is a 'J' or 'j'
                label = (ch == 'J' || ch == 'j' ? ch + ":  " : label);
                double score = or.getOverallScore() * 100;
                if (!BenchmarkScore.showAveOnlyMode) {

                    final DecimalFormat DF = new DecimalFormat("#0.0");
                    String TPR = DF.format(100 * or.getTruePositiveRate());
                    if (TPR.endsWith("0"))
                        TPR =
                                TPR.substring(
                                        0, TPR.length() - 2); // trim off .0 if it ends that way.
                    String FPR = DF.format(100 * or.getFalsePositiveRate());
                    if (FPR.endsWith("0")) FPR = FPR.substring(0, FPR.length() - 2);

                    final String TOOL = "\u25A0 " + label + r.getToolNameAndVersion();
                    XYTextAnnotation toolLabel = new XYTextAnnotation(TOOL, x, y + i * -3.3);
                    toolLabel.setTextAnchor(TextAnchor.CENTER_LEFT);
                    toolLabel.setBackgroundPaint(Color.white);
                    toolLabel.setPaint(Color.blue);
                    toolLabel.setFont(theme.getRegularFont());
                    xyplot.addAnnotation(toolLabel);
                    final String SCORE = Math.round(score) + "%";
                    XYTextAnnotation scoreLabel = new XYTextAnnotation(SCORE, x + 53, y + i * -3.3);
                    scoreLabel.setTextAnchor(TextAnchor.CENTER_RIGHT);
                    scoreLabel.setBackgroundPaint(Color.white);
                    scoreLabel.setPaint(Color.blue);
                    scoreLabel.setFont(theme.getRegularFont());
                    xyplot.addAnnotation(scoreLabel);
                    final String CALC = "(" + TPR + "-" + FPR + ")";
                    XYTextAnnotation calcLabel = new XYTextAnnotation(CALC, x + 59, y + i * -3.3);
                    calcLabel.setTextAnchor(TextAnchor.CENTER);
                    calcLabel.setBackgroundPaint(Color.white);
                    calcLabel.setPaint(Color.gray);
                    calcLabel.setFont(theme.getSmallFont());
                    xyplot.addAnnotation(calcLabel);

                    i++;
                    // Weak hack if there are more than 26 tools scored. This will only get us to
                    // 52.
                    if (ch == 'Z') ch = 'a';
                    else ch++;
                }
                totalScore += score;
            }
            if (r.getToolName().replace(' ', '_').equalsIgnoreCase(focus)) {
                ToolResults orc = r.getOverallResults();
                Point2D focusPoint =
                        new Point2D.Double(
                                orc.getFalsePositiveRate() * 100, orc.getTruePositiveRate() * 100);
                Color green = new Color(0, 1, 0, 0.5f);
                makePoint(xyplot, focusPoint, 3, green);
            }
        }

        // commercial average
        if (commercialToolCount > 1
                || (BenchmarkScore.showAveOnlyMode && commercialToolCount == 1)) {
            double averageScore = totalScore / commercialToolCount;
            XYTextAnnotation stroketext2 =
                    new XYTextAnnotation(
                            "\u25A0 "
                                    + ch
                                    + ": Commercial Average"
                                    + " ("
                                    + Math.round(averageScore)
                                    + "%)",
                            x,
                            y + i * -3.3);
            stroketext2.setTextAnchor(TextAnchor.CENTER_LEFT);
            stroketext2.setBackgroundPaint(Color.white);
            stroketext2.setPaint(Color.magenta);
            stroketext2.setFont(theme.getRegularFont());
            xyplot.addAnnotation(stroketext2);

            Point2D averagePoint = new Point2D.Double(afr * 100, atr * 100);
            makePoint(xyplot, averagePoint, 3, Color.magenta);
        }
    }

    public static void generateComparisonChart(Set<Tool> tools, String focus, File scoreCardDir) {
        try {
            String scatterTitle =
                    BenchmarkScore.fullTestSuiteName(BenchmarkScore.TESTSUITE)
                            + (BenchmarkScore.mixedMode
                                    ? ""
                                    : " v" + BenchmarkScore.TESTSUITEVERSION)
                            + " Results Comparison";
            ScatterHome scatter = new ScatterHome(scatterTitle, tools, focus);
            scatter.writeChartToFile(new File(scoreCardDir, "toolresults_comparison.png"), 800);
        } catch (IOException e) {
            System.out.println("Couldn't generate tool results comparison chart for some reason.");
            e.printStackTrace();
        }
    }
}
