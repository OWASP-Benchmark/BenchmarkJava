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
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.owasp.benchmark.score.CategoryResults;
import org.owasp.benchmark.score.ToolResults;

public class ScatterTools extends ScatterPlot {
    public char averageLabel;
    public double atpr, afpr;

    public ScatterTools(String title, int height, ToolResults toolResults) {
        display("          " + title, height, toolResults);
    }

    /**
     * Generate a 'Scatter' chart for one tool and return the created chart.
     *
     * @param title - Title of chart being created. This is included at top of generated chat.
     * @param height - The height of the chart to create. Width is a fixed ratio of height.
     * @param toolResults - The scores for this tool.
     * @return The generated scatter chart for this tool's results.
     */
    private JFreeChart display(String title, int height, ToolResults toolResults) {

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Scores");
        int totalTools = 0;
        double totalToolTPR = 0;
        double totalToolFPR = 0;
        for (CategoryResults r : toolResults.getCategoryResults()) {
            series.add(r.falsePositiveRate * 100, r.truePositiveRate * 100);
            totalTools++;
            totalToolTPR += r.truePositiveRate;
            totalToolFPR += r.falsePositiveRate;
        }
        atpr = totalToolTPR / totalTools;
        afpr = totalToolFPR / totalTools;

        if (toolResults.getCategoryResults().size() > 1) {
            series.add(afpr * 100, atpr * 100);
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

        makeDataLabels(toolResults, xyplot);
        makeLegend(toolResults, 103, 93, dataset, xyplot);

        XYTextAnnotation time =
                new XYTextAnnotation("Tool run time: " + toolResults.getScanTime(), 12, -5.6);
        time.setTextAnchor(TextAnchor.TOP_LEFT);
        time.setFont(theme.getRegularFont());
        time.setPaint(Color.red);
        xyplot.addAnnotation(time);

        return chart;
    }

    private void makeDataLabels(ToolResults toolResults, XYPlot xyplot) {
        HashMap<Point2D, String> map = makePointList(toolResults);
        for (Entry<Point2D, String> e : map.entrySet()) {
            if (e.getValue() != null) {
                Point2D p = e.getKey();
                String label = sort(e.getValue());
                XYTextAnnotation annotation = new XYTextAnnotation(label, p.getX(), p.getY());
                annotation.setTextAnchor(
                        p.getX() < 3 ? TextAnchor.TOP_LEFT : TextAnchor.TOP_CENTER);
                annotation.setBackgroundPaint(Color.white);
                // set color of average to black and everything else to blue
                if (averageLabel == label.toCharArray()[0]) {
                    annotation.setPaint(Color.magenta);
                } else {
                    annotation.setPaint(Color.blue);
                }
                annotation.setFont(theme.getRegularFont());
                xyplot.addAnnotation(annotation);
            }
        }
    }

    /**
     * Sort the comma separated elements of the supplied string.
     *
     * @param value - The string to sort.
     * @return A new comma separated string with the items in it in alphabetical order.
     */
    private String sort(String value) {
        String[] parts = value.split(",");
        Arrays.sort(parts);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            sb.append(parts[i]);
            if (i < parts.length - 1) sb.append(",");
        }
        return sb.toString();
    }

    SecureRandom sr = new SecureRandom();

    private HashMap<Point2D, String> makePointList(ToolResults toolResults) {
        HashMap<Point2D, String> map = new HashMap<Point2D, String>();
        char ch = ScatterHome.INITIAL_LABEL;
        int size = 0;
        // make a list of all points. Add in a tiny random to prevent exact
        // duplicate coordinates in map
        for (CategoryResults r : toolResults.getCategoryResults()) {
            size++;
            double x = r.falsePositiveRate * 100 + sr.nextDouble() * .000001;
            // this puts the label just below the point
            double y = r.truePositiveRate * 100 + sr.nextDouble() * .000001 - 1;
            Point2D p = new Point2D.Double(x, y);
            String label = "" + ch;
            map.put(p, label);
            // Weak hack if there are more than 26 tools scored. This will only get us to 52.
            if (ch == 'Z') ch = 'a';
            else ch++;
        }
        // add  average point
        if (size > 1) {
            double x = afpr * 100 + sr.nextDouble() * .000001;
            double y = atpr * 100 + sr.nextDouble() * .000001 - 1;
            Point2D p = new Point2D.Double(x, y);
            String label = "" + ch;
            averageLabel = ch;
            map.put(p, label);
        }
        dedupify(map);
        return map;
    }

    private void dedupify(HashMap<Point2D, String> map) {
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

    private Entry<Point2D, String> getMatch(
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
            ToolResults or, double x, double y, XYSeriesCollection dataset, XYPlot xyplot) {
        char ch = ScatterHome.INITIAL_LABEL;
        int i = 0;
        int toolCount = 0;
        double totalScore = 0;
        for (CategoryResults r : or.getCategoryResults()) {
            toolCount++;
            // Special hack to make it line up better if the letter is an 'I' or 'i'
            String label = (ch == 'I' || ch == 'i' ? ch + ":   " : ch + ": ");
            // Another hack to make it line up better if the letter is a 'J' or 'j'
            label = (ch == 'J' || ch == 'j' ? ch + ":  " : label);
            double score = 100 * (r.truePositiveRate - r.falsePositiveRate);
            final DecimalFormat DF = new DecimalFormat("#0.0");
            String TPR = DF.format(100 * r.truePositiveRate);
            if (TPR.endsWith("0"))
                TPR = TPR.substring(0, TPR.length() - 2); // trim off .0 if it ends that way.
            String FPR = DF.format(100 * r.falsePositiveRate);
            if (FPR.endsWith("0")) FPR = FPR.substring(0, FPR.length() - 2);
            final String CAT = "\u25A0 " + label + r.category;
            XYTextAnnotation catLabel = new XYTextAnnotation(CAT, x, y + i * -3.3);
            catLabel.setTextAnchor(TextAnchor.CENTER_LEFT);
            catLabel.setBackgroundPaint(Color.white);
            catLabel.setPaint(Color.blue);
            catLabel.setFont(theme.getRegularFont());
            xyplot.addAnnotation(catLabel);
            final String SCORE = Math.round(score) + "%";
            XYTextAnnotation scoreLabel = new XYTextAnnotation(SCORE, x + 52, y + i * -3.3);
            scoreLabel.setTextAnchor(TextAnchor.CENTER_RIGHT);
            scoreLabel.setBackgroundPaint(Color.white);
            scoreLabel.setPaint(Color.blue);
            scoreLabel.setFont(theme.getRegularFont());
            xyplot.addAnnotation(scoreLabel);
            final String CALC = "(" + TPR + "-" + FPR + ")";
            XYTextAnnotation calcLabel = new XYTextAnnotation(CALC, x + 58, y + i * -3.3);
            calcLabel.setTextAnchor(TextAnchor.CENTER);
            calcLabel.setBackgroundPaint(Color.white);
            calcLabel.setPaint(Color.gray);
            calcLabel.setFont(theme.getSmallFont());
            xyplot.addAnnotation(calcLabel);
            totalScore += score;
            i++;
            // Weak hack if there are more than 26 tools scored. This will only get us to 52.
            if (ch == 'Z') ch = 'a';
            else ch++;
        }

        if (toolCount > 1) {
            double averageScore = totalScore / toolCount;
            XYTextAnnotation stroketext =
                    new XYTextAnnotation(
                            "\u25A0 "
                                    + ch
                                    + ": Average Score for this Tool"
                                    + " ("
                                    + Math.round(averageScore)
                                    + "%)",
                            x,
                            y + i * -3.3);
            stroketext.setTextAnchor(TextAnchor.CENTER_LEFT);
            stroketext.setBackgroundPaint(Color.white);
            stroketext.setPaint(Color.magenta);
            stroketext.setFont(theme.getRegularFont());
            xyplot.addAnnotation(stroketext);

            Point2D averagePoint = new Point2D.Double(afpr * 100, atpr * 100);
            makePoint(xyplot, averagePoint, 3, Color.magenta);
        }
    }
}
