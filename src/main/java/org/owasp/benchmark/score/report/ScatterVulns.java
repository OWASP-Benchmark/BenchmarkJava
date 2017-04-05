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

package org.owasp.benchmark.score.report;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;
import org.owasp.benchmark.score.BenchmarkScore;
import org.owasp.benchmark.score.parsers.OverallResult;
import org.owasp.benchmark.score.parsers.OverallResults;
import org.owasp.benchmark.score.parsers.TestResults;

public class ScatterVulns extends ScatterPlot {
    char averageLabel;
    double afr = 0;
    double atr = 0;

    // Commercial Scores
    private int commercialToolCount = 0;
    private double commercialLow = 100;
    private TestResults.ToolType commercialLowToolType = null;
    private double commercialHigh = 0;
    private TestResults.ToolType commercialHighToolType = null;
    private double commercialAve = 0;
    public final String category;
    public final String focus;

    /**
     * This calculates how all the tools did against the Benchmark in this
     * vulnerability category
     * 
     * @param title
     *            - The title of the chart to be produced.
     * @param height
     *            - Height of the chart (typically 800)
     * @param category
     *            - The vulnerability category this chart is being generated for.
     * @param toolResults
     *            - A list of each individual tool's results.
     * @param focus
     *            - A tool to emphasize in the chart.
     */
    public ScatterVulns(String title, int height, String category, Set<Report> toolResults, String focus) {
        this.category = category;
        this.focus = focus;
        display("          " + title, height, category, toolResults);
    }

    private JFreeChart display(String title, int height, String category, Set<Report> toolResults) {
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // averages
        ArrayList<Double> averageFalseRates = new ArrayList<Double>();
        ArrayList<Double> averageTrueRates = new ArrayList<Double>();

        int commercialToolCount = 0;
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Scores");

        for (Report toolReport : toolResults) {
            if (!toolReport.isCommercial()) {
                OverallResult overallResult = toolReport.getOverallResults().getResults(category);
                series.add(overallResult.falsePositiveRate * 100, overallResult.truePositiveRate * 100);
            }
        }

        for (Report toolReport : toolResults) {
            if (toolReport.isCommercial()) {
                OverallResult overallResult = toolReport.getOverallResults().getResults(category);
                if (!BenchmarkScore.showAveOnlyMode) {
                    series.add(overallResult.falsePositiveRate * 100, overallResult.truePositiveRate * 100);
                }
                commercialToolCount++;
                averageFalseRates.add(overallResult.falsePositiveRate);
                averageTrueRates.add(overallResult.truePositiveRate);
            }
        }

        for (double d : averageFalseRates) {
            afr += d;
        }
        afr = afr / averageFalseRates.size();

        for (double d : averageTrueRates) {
            atr += d;
        }
        atr = atr / averageTrueRates.size();

        if (commercialToolCount > 1 || (BenchmarkScore.showAveOnlyMode && commercialToolCount == 1)) {
            series.add(afr * 100, atr * 100);
        }

        dataset.addSeries(series);

        chart = ChartFactory.createScatterPlot(title, "False Positive Rate", "True Positive Rate", 
            dataset, PlotOrientation.VERTICAL, true, true, false);
        theme.apply(chart);

        XYPlot xyplot = chart.getXYPlot();

        initializePlot(xyplot);

        makeDataLabels(category, toolResults, xyplot);
        makeLegend(category, toolResults, 103, 100.5, dataset, xyplot);

        for (XYDataItem item : (List<XYDataItem>) series.getItems()) {
            double x = item.getX().doubleValue();
            double y = item.getY().doubleValue();
            double z = (x + y) / 2;
            XYLineAnnotation score = new XYLineAnnotation(x, y, z, z, dashed, Color.blue);
            xyplot.addAnnotation(score);
        }

        ChartPanel cp = new ChartPanel(chart, height, height, 400, 400, 1200, 1200, false, false, false, 
             false, false, false);
        f.add(cp);
        f.pack();
        f.setLocationRelativeTo(null);
        // f.setVisible(true);

        return chart;
    }

    private void makeDataLabels(String category, Set<Report> toolResults, XYPlot xyplot) {
        HashMap<Point2D, String> map = makePointList(category, toolResults);
        for (Entry<Point2D, String> e : map.entrySet()) {
            if (e.getValue() != null) {
                Point2D p = e.getKey();
                String label = sort(e.getValue());
                XYTextAnnotation annotation = new XYTextAnnotation(label, p.getX(), p.getY());
                annotation.setTextAnchor(p.getX() < 3 ? TextAnchor.TOP_LEFT : TextAnchor.TOP_CENTER);
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

    private String sort(String value) {
        String[] parts = value.split(",");
        Arrays.sort(parts);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            sb.append(parts[i]);
            if (i < parts.length - 1)
                sb.append(",");
        }
        return sb.toString();
    }

    private SecureRandom sr = new SecureRandom();

    private HashMap<Point2D, String> makePointList(String category, Set<Report> toolResults) {
        HashMap<Point2D, String> map = new HashMap<Point2D, String>();
        char ch = ScatterHome.INITIAL_LABEL;

        // make a list of all points. Add in a tiny random to prevent exact
        // duplicate coordinates in map
        int commercialToolCount = 0;

        for (Report r : toolResults) {
            if (!r.isCommercial()) {
                OverallResult or = r.getOverallResults().getResults(category);
                // this puts the label just below the point
                double x = or.falsePositiveRate * 100 + sr.nextDouble() * .000001;
                double y = or.truePositiveRate * 100 + sr.nextDouble() * .000001 - 1;
                Point2D p = new Point2D.Double(x, y);
                String label = "" + ch;
                map.put(p, label);
                // Weak hack if there are more than 26 tools scored. This will only get us to 52.
                if (ch == 'Z') ch = 'a'; else ch++;
            }
        }

        for (Report r : toolResults) {
            if (r.isCommercial()) {
                commercialToolCount++;
                if (!BenchmarkScore.showAveOnlyMode) {
                    OverallResult or = r.getOverallResults().getResults(category);
                    // this puts the label just below the point
                    double x = or.falsePositiveRate * 100 + sr.nextDouble() * .000001;
                    double y = or.truePositiveRate * 100 + sr.nextDouble() * .000001 - 1;
                    Point2D p = new Point2D.Double(x, y);
                    String label = "" + ch;
                    map.put(p, label);
                    // Weak hack if there are more than 26 tools scored. This will only get us to 52.
                    if (ch == 'Z') ch = 'a'; else ch++;
                }
            }
        }

        if (commercialToolCount > 1 || (BenchmarkScore.showAveOnlyMode && commercialToolCount == 1)) {
            Point2D ap = new Point2D.Double(afr * 100 + sr.nextDouble() * .000001, atr * 100 
               + sr.nextDouble() * .000001 - 1);
            averageLabel = ch;
            map.put(ap, "" + ch);
        }
        dedupify(map);
        return map;
    }

    private void dedupify(HashMap<Point2D, String> map) {
        for (Entry<Point2D, String> e1 : map.entrySet()) {
            Entry<Point2D, String> e2 = getMatch(map, e1);
            while (e2 != null) {
                StringBuilder label = new StringBuilder();
                if (e1.getValue() != null)
                    label.append(e1.getValue());
                if (e1.getValue() != null && e2.getValue() != null)
                    label.append(",");
                if (e2.getValue() != null)
                    label.append(e2.getValue());
                e1.setValue(label.toString());
                e2.setValue(null);
                e2 = getMatch(map, e1);
            }
        }
    }

    private Entry<Point2D, String> getMatch(HashMap<Point2D, String> map, Entry<Point2D, String> e1) {
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

    private void makeLegend(String category, Set<Report> toolResults, double x, double y,
        XYSeriesCollection dataset, XYPlot xyplot) {

        char ch = ScatterHome.INITIAL_LABEL;
        int i = -2;

        // non-commercial results
        boolean printedNonCommercialLabel = false;

        for (Report r : toolResults) {
            if (!r.isCommercial()) {
                // print non commercial label if there is at least one
                // non-commercial tool
                if (!printedNonCommercialLabel) {
                    XYTextAnnotation stroketext1 = new XYTextAnnotation("Non-Commercial", x, y + i * -3.3);
                    stroketext1.setTextAnchor(TextAnchor.CENTER_LEFT);
                    stroketext1.setBackgroundPaint(Color.white);
                    stroketext1.setPaint(Color.black);
                    stroketext1.setFont(theme.getRegularFont());
                    xyplot.addAnnotation(stroketext1);
                    i++;
                    printedNonCommercialLabel = true;
                }

                OverallResults or = r.getOverallResults();
                // Special hack to make it line up better if the letter is an 'I' or 'i'
                String label = ( ch == 'I' || ch == 'i' ? ch + ":  " : ""+ch + ": " );
                double score = or.getResults(category).score * 100;
                String msg = "\u25A0 " + label + r.getToolNameAndVersion() + " (" + Math.round(score) + "%)";
                XYTextAnnotation stroketext3 = new XYTextAnnotation(msg, x, y + i * -3.3);
                stroketext3.setTextAnchor(TextAnchor.CENTER_LEFT);
                stroketext3.setBackgroundPaint(Color.white);
                stroketext3.setPaint(r.getToolName().replace(' ','_').equalsIgnoreCase(focus) ? 
                   Color.green : Color.blue);
                stroketext3.setFont(theme.getRegularFont());
                xyplot.addAnnotation(stroketext3);
                i++;
                // Weak hack if there are more than 26 tools scored. This will only get us to 52.
                if (ch == 'Z') ch = 'a'; else ch++;
            }
        }

        // commercial tools
        boolean printedCommercialLabel = false;
        double commercialTotal = 0;

        for (Report r : toolResults) {
            OverallResults or = r.getOverallResults();
            if (r.isCommercial()) {

                // print commercial label if there is at least one commercial
                // tool
                if (!printedCommercialLabel) {
                    XYTextAnnotation stroketext4 = new XYTextAnnotation("Commercial", x, y + i * -3.3);
                    stroketext4.setTextAnchor(TextAnchor.CENTER_LEFT);
                    stroketext4.setBackgroundPaint(Color.white);
                    stroketext4.setPaint(Color.black);
                    stroketext4.setFont(theme.getRegularFont());
                    xyplot.addAnnotation(stroketext4);
                    i++;
                    printedCommercialLabel = true;
                }

                commercialToolCount++;
                double score = or.getResults(category).score * 100;
                // don't show the commercial tool results if in 'show ave only mode'
                if (!BenchmarkScore.showAveOnlyMode) {
                    // Special hack to make it line up better if the letter is an 'I' or 'i'
                    String label = ( ch == 'I' || ch == 'i' ? ch + ":  " : ""+ch + ": " );
	                String msg = "\u25A0 " + label + r.getToolNameAndVersion() + " (" + Math.round(score) + "%)";
	                XYTextAnnotation stroketext4 = new XYTextAnnotation(msg, x, y + i * -3.3);
	                stroketext4.setTextAnchor(TextAnchor.CENTER_LEFT);
	                stroketext4.setBackgroundPaint(Color.white);
	                stroketext4.setPaint(Color.blue);
	                stroketext4.setFont(theme.getRegularFont());
	                xyplot.addAnnotation(stroketext4);
	                i++;  // increment the location of the label
                    // Weak hack if there are more than 26 tools scored. This will only get us to 52.
                    if (ch == 'Z') ch = 'a'; else ch++;
                }
                commercialTotal += score;

                if (score < commercialLow) {
                    commercialLow = score;
                    commercialLowToolType = r.getToolType();
                }
                if (score > commercialHigh) {
                    commercialHigh = score;
                    commercialHighToolType = r.getToolType();
                }                
            }

            // Add color emphasis to the tool of focus
            if (r.getToolName().replace(' ','_').equalsIgnoreCase(focus)) {
                OverallResult orc = r.getOverallResults().getResults(category);
                Point2D focusPoint = new Point2D.Double(orc.falsePositiveRate * 100, orc.truePositiveRate * 100);
                Color green = new Color(0, 1, 0, 0.5f);
                makePoint(xyplot, focusPoint, 3, green);
            }
        }

        // commercial average
        if (commercialToolCount > 1 || (BenchmarkScore.showAveOnlyMode && commercialToolCount == 1)) {
            commercialAve = commercialTotal / commercialToolCount;
            XYTextAnnotation stroketext2 = new XYTextAnnotation("\u25A0 " + ch + ": Commercial Average" 
               + " (" + Math.round(commercialAve) + "%)", x, y + i * -3.3);
            stroketext2.setTextAnchor(TextAnchor.CENTER_LEFT);
            stroketext2.setBackgroundPaint(Color.white);
            stroketext2.setPaint(Color.magenta);
            stroketext2.setFont(theme.getRegularFont());
            xyplot.addAnnotation(stroketext2);

            Point2D averagePoint = new Point2D.Double(afr * 100, atr * 100);
            Color red = new Color(1, 0, 0, 0.5f);
            makePoint(xyplot, averagePoint, 3, red);
        }
    }

    public static ScatterVulns generateComparisonChart(String category, Set<Report> toolResults, String focus) {
        try {
            String scatterTitle = "OWASP Benchmark" + (BenchmarkScore.mixedMode ? " -" : " v" 
               + BenchmarkScore.benchmarkVersion) + " " + category + " Comparison";
            ScatterVulns scatter = new ScatterVulns(scatterTitle, 800, category, toolResults, focus);
            scatter.writeChartToFile(new File("scorecard/Benchmark_v" + BenchmarkScore.benchmarkVersion 
               + "_Scorecard_for_" + category.replace(' ', '_') + ".png"), 800);
            return scatter;
        } catch (IOException e) {
            System.out.println("Couldn't generate Benchmark vulnerability chart for some reason.");
            e.printStackTrace();
            return null;
        }
    }

    // FIXME -- this is all a terrible mixing of view and model
    // This should be calculated and accessed through the Results (which needs a refactor to be a better DB)
    public int getCommercialToolCount() {
        return commercialToolCount;
    }

    public int getCommercialLow() {
        return (int) Math.round(commercialLow);
    }

    public TestResults.ToolType getCommercialLowToolType() {
        return commercialLowToolType;
    }

    public int getCommercialAve() {
        return (int) Math.round(commercialAve);
    }

    public int getCommercialHigh() {
        return (int) Math.round(commercialHigh);
    }

    public TestResults.ToolType getCommercialHighToolType() {
        return commercialHighToolType;
    }
}
