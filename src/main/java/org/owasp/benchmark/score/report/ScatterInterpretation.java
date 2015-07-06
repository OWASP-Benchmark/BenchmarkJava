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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

public class ScatterInterpretation {

    private JFreeChart chart = null;
    private StandardChartTheme theme = null;

    public ScatterInterpretation( int height, int width) {
        display("          OWASP Benchmark Results Interpretation Guide", height, width);
    }

    private JFreeChart display(String title, int height, int width) {
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        XYSeriesCollection dataset = new XYSeriesCollection();
        chart = ChartFactory.createScatterPlot(title, "False Positive Rate", "True Positive Rate", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        String fontName = "Arial";
        DecimalFormat pctFormat = new DecimalFormat("0'%'");

        theme = (StandardChartTheme) org.jfree.chart.StandardChartTheme.createJFreeTheme();
        theme.setExtraLargeFont(new Font(fontName, Font.PLAIN, 24)); // title
        theme.setLargeFont(new Font(fontName, Font.PLAIN, 20)); // axis-title
        theme.setRegularFont(new Font(fontName, Font.PLAIN, 16));
        theme.setSmallFont(new Font(fontName, Font.PLAIN, 12));
        theme.setRangeGridlinePaint(Color.decode("#C0C0C0"));
        theme.setPlotBackgroundPaint(Color.white);
        theme.setChartBackgroundPaint(Color.white);
        theme.setGridBandPaint(Color.red);
        theme.setAxisOffset(new RectangleInsets(0, 0, 0, 0));
        theme.setBarPainter(new StandardBarPainter());
        theme.setAxisLabelPaint(Color.decode("#666666"));
        theme.apply(chart);

        XYPlot xyplot = chart.getXYPlot();
        NumberAxis rangeAxis = (NumberAxis) xyplot.getRangeAxis();
        NumberAxis domainAxis = (NumberAxis) xyplot.getDomainAxis();

        xyplot.setOutlineVisible(true);
        Stroke lightgray = new BasicStroke(0.25f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 2, 1 }, 0);

        rangeAxis.setRange(-5, 105);
        rangeAxis.setNumberFormatOverride(pctFormat);
        rangeAxis.setTickLabelPaint(Color.decode("#666666"));
        rangeAxis.setMinorTickCount(5);
        rangeAxis.setTickUnit(new NumberTickUnit(10));
        rangeAxis.setAxisLineVisible(true);
        //rangeAxis.setMinorTickMarksVisible(true);
        rangeAxis.setTickMarksVisible(true);
        rangeAxis.setLowerMargin(10);
        rangeAxis.setUpperMargin(10);
        xyplot.setRangeGridlineStroke(lightgray);
        xyplot.setRangeGridlinePaint(Color.lightGray);
        //xyplot.setRangeMinorGridlinePaint(Color.decode("#DDDDDD"));
        //xyplot.setRangeMinorGridlinesVisible(true);

        domainAxis.setRange(-5, 105);
        domainAxis.setNumberFormatOverride(pctFormat);
        domainAxis.setTickLabelPaint(Color.decode("#666666"));
        domainAxis.setMinorTickCount(5);
        domainAxis.setTickUnit(new NumberTickUnit(10));
        domainAxis.setAxisLineVisible(true);
        domainAxis.setTickMarksVisible(true);
        //domainAxis.setMinorTickMarksVisible(true);
        domainAxis.setLowerMargin(10);
        domainAxis.setUpperMargin(10);
        xyplot.setDomainGridlineStroke(lightgray);
        xyplot.setDomainGridlinePaint(Color.lightGray);
        //xyplot.setDomainMinorGridlinePaint(Color.decode("#DDDDDD"));
        //xyplot.setDomainMinorGridlinesVisible(true);

        chart.setTextAntiAlias(true);
        chart.setAntiAlias(true);
        chart.removeLegend();
        chart.setPadding(new RectangleInsets(20, 20, 20, 20));
        xyplot.getRenderer().setSeriesPaint(0, Color.decode("#4572a7"));

        // draw guessing line
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 6, 3 }, 0);
        XYLineAnnotation guessing = new XYLineAnnotation(-5, -5, 105, 105, dashed, Color.red);
        xyplot.addAnnotation(guessing);

       
        
        makePointer( xyplot, 7, 93, " Ideal vulnerability detection", TextAnchor.TOP_LEFT, 45 );

        makePointer( xyplot, 10, 10, " Tool reports nothing is vulnerable", TextAnchor.TOP_LEFT, 45 );

        makePointer( xyplot, 70, 30, " Worse than random", TextAnchor.TOP_LEFT, 45 );

        makePointer( xyplot, 90, 90, "Tool reports everything is vulnerable ", TextAnchor.BOTTOM_RIGHT, 225);

        makePointer( xyplot, 50, 50, "Tool reports vulnerabilities randomly ", TextAnchor.BOTTOM_RIGHT, 225);
       
        makeOval( xyplot, 0, 3, 20, 10, 45 );
        makeOval( xyplot, 42, 3, 20, 10, 45 );
        makeOval( xyplot, 84, 3, 20, 10, 45 );
        makeOval( xyplot, 43, 64, 20, 10, 45 );
        
        ChartPanel cp = new ChartPanel(chart, height, width, 400, 400, 1200, 1200, false, false, false, false, false, false);
        f.add(cp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        return chart;
    }
    
    // Note that rotation is for the entire G2D, so put in coordinates accordingly
    private void makeOval(XYPlot xyplot, double x, double y, double w, int h, int angle) {
        x = x * Math.sqrt(2);
        Shape oval = new Ellipse2D.Double(x, y, w, h);
        Shape diag = rotate( oval, angle );
        XYShapeAnnotation area = new XYShapeAnnotation(diag, new BasicStroke(), Color.gray );
        xyplot.addAnnotation( area );
    }

    public static Shape rotate(Shape shape, int angle)
    {
        Rectangle bounds = shape.getBounds();
        double radians = Math.toRadians( angle );
        double anchorX = bounds.width / 2;
        double anchorY = bounds.height / 2;
        AffineTransform at = AffineTransform.getRotateInstance(radians, anchorX, anchorY);
        Shape rotated = at.createTransformedShape(shape);
        return rotated;   
    }
    
    private void makePointer(XYPlot plot, double x, double y, String msg, TextAnchor anchor, int angle ) {
//        TextTitle textTitle = new TextTitle(msg, theme.getSmallFont(), Color.red, RectangleEdge.TOP, HorizontalAlignment.LEFT, VerticalAlignment.TOP, new RectangleInsets(2, 2, 2, 2));
//        XYTitleAnnotation title = new XYTitleAnnotation(x/100, y/100, textTitle, RectangleAnchor.TOP_LEFT);
//        plot.addAnnotation( title );
        
        XYPointerAnnotation pointer = new XYPointerAnnotation(msg, x, y, Math.toRadians(angle));
        pointer.setBackgroundPaint(Color.white);
        pointer.setTextAnchor(anchor);
        pointer.setArrowWidth(4);
        pointer.setArrowLength(8);
        pointer.setArrowPaint(Color.red);
        pointer.setLabelOffset(2);
        pointer.setPaint(Color.red);
        pointer.setFont(theme.getRegularFont());
        plot.addAnnotation(pointer);;
    }

    public void writeChartToFile(File f, int height, int width) throws IOException {
        FileOutputStream stream = new FileOutputStream(f);
        ChartUtilities.writeChartAsPNG(stream, chart, height, width);
        stream.close();
    }

    public static void main(String[] args) throws IOException {
        ScatterInterpretation scatter = new ScatterInterpretation(800, 800);
        scatter.writeChartToFile(new File("benchmark_guide.png"), 800, 800);
        System.exit(0);
    }
}