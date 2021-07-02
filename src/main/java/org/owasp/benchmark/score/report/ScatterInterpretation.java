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
 * PURPOSE. See the GNU General Public License for more details
 *
 * @author Dave Wichers
 * @created 2015
 */
package org.owasp.benchmark.score.report;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.xy.XYSeriesCollection;
import org.owasp.benchmark.score.BenchmarkScore;

public class ScatterInterpretation extends ScatterPlot {

    public ScatterInterpretation(int height) {
        display(
                "          "
                        + BenchmarkScore.fullTestSuiteName(BenchmarkScore.TESTSUITE)
                        + " Results Interpretation Guide",
                height);
    }

    private JFreeChart display(String title, int height) {

        XYSeriesCollection dataset = new XYSeriesCollection();
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

        makePointer(xyplot, 7, 93, " Ideal vulnerability detection", TextAnchor.TOP_LEFT, 45);
        makePointer(xyplot, 10, 10, " Tool reports nothing is vulnerable", TextAnchor.TOP_LEFT, 45);
        // makePointer( xyplot, 70, 30, " Worse than random", TextAnchor.TOP_LEFT, 45 );
        makePointer(
                xyplot, 90, 90, "Tool reports everything is vulnerable ", TextAnchor.TOP_LEFT, 45);
        makePointer(
                xyplot, 50, 50, "Tool reports vulnerabilities randomly ", TextAnchor.TOP_LEFT, 45);

        makeOval(xyplot, 0, 3, 20, 10, 45);
        makeOval(xyplot, 42, 3, 20, 10, 45);
        makeOval(xyplot, 84, 3, 20, 10, 45);
        makeOval(xyplot, 43, 64, 20, 10, 45);

        return chart;
    }

    public static void main(String[] args) throws IOException {
        ScatterInterpretation scatter = new ScatterInterpretation(800);
        scatter.writeChartToFile(new File("testsuite_guide.png"), 800);
        System.exit(0);
    }
}
