/**
 * OWASP Benchmark Project
 *
 * This file is part of the Open Web Application Security Project (OWASP)
 * Benchmark Project For details, please see
 * <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 *
 * The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details
 *
 * @author Dave Wichers
 * @created 2015
 */

package org.owasp.benchmark.score.report;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;

public class ScatterPlot {

	// This variable is directly accessed by ScatterHome.java
    JFreeChart chart = null;
    static final StandardChartTheme theme = initializeTheme();
    static final DecimalFormat pctFormat = new DecimalFormat("0'%'");
    static final Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 6, 3 }, 0);

    public static StandardChartTheme initializeTheme() {
        String fontName = "Arial";
        StandardChartTheme theme = (StandardChartTheme) org.jfree.chart.StandardChartTheme.createJFreeTheme();
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
        return theme;
    }
    
    public void initializePlot( XYPlot xyplot ) {
        NumberAxis rangeAxis = (NumberAxis) xyplot.getRangeAxis();
        NumberAxis domainAxis = (NumberAxis) xyplot.getDomainAxis();

        rangeAxis.setRange(-9.99, 109.99);
        rangeAxis.setNumberFormatOverride(pctFormat);
        rangeAxis.setTickLabelPaint(Color.decode("#666666"));
        rangeAxis.setMinorTickCount(5);
        rangeAxis.setTickUnit(new NumberTickUnit(10));
        rangeAxis.setAxisLineVisible(true);
        rangeAxis.setMinorTickMarksVisible(true);
        rangeAxis.setTickMarksVisible(true);
        rangeAxis.setLowerMargin(10);
        rangeAxis.setUpperMargin(10);
        
        domainAxis.setRange(-5, 175);
        domainAxis.setNumberFormatOverride(pctFormat);
        domainAxis.setTickLabelPaint(Color.decode("#666666"));
        domainAxis.setMinorTickCount(5);
        domainAxis.setTickUnit(new NumberTickUnit(10));
        domainAxis.setAxisLineVisible(true);
        domainAxis.setTickMarksVisible(true);
        domainAxis.setMinorTickMarksVisible(true);
        domainAxis.setLowerMargin(10);
        domainAxis.setUpperMargin(10);
        
        xyplot.setRangeGridlineStroke(new BasicStroke());
        xyplot.setRangeGridlinePaint(Color.lightGray);
        xyplot.setRangeMinorGridlinePaint(Color.decode("#DDDDDD"));
        xyplot.setRangeMinorGridlinesVisible(true);
        xyplot.setOutlineVisible(true);
        xyplot.setDomainGridlineStroke(new BasicStroke());
        xyplot.setDomainGridlinePaint(Color.lightGray);
        xyplot.setDomainMinorGridlinePaint(Color.decode("#DDDDDD"));
        xyplot.setDomainMinorGridlinesVisible(true);
        xyplot.getRenderer().setSeriesPaint(0, Color.decode("#4572a7"));

        chart.setTextAntiAlias(true);
        chart.setAntiAlias(true);
        chart.removeLegend();
        chart.setPadding(new RectangleInsets(20, 20, 20, 20));
        
        Point2D legendLocation = new Point2D.Double( 101, -10 );
        makeRect(xyplot, legendLocation, 120, 74, Color.WHITE );
       
        Point2D triangleLocation = new Point2D.Double( 101, -10 );
        Color grey = new Color(0.1f,0.1f,0.1f,0.1f);
        makeTriangle(xyplot, triangleLocation, grey );
        
        makeGuessingLine( xyplot );
    }
    
    
    public static XYPointerAnnotation makePointer(int x, int y, String msg, TextAnchor anchor, int angle ) {
        XYPointerAnnotation pointer = new XYPointerAnnotation(msg, x, y, Math.toRadians(angle));
        pointer.setBackgroundPaint(Color.white);
        pointer.setTextAnchor(anchor);
        pointer.setArrowWidth(4);
        pointer.setArrowLength(8);
        pointer.setArrowPaint(Color.red);
        pointer.setLabelOffset(2);
        pointer.setPaint(Color.red);
        pointer.setFont(theme.getRegularFont());
        return pointer;
    }
    
    public void writeChartToFile(File f, int height) throws IOException {
        FileOutputStream stream = new FileOutputStream(f);
        ChartUtils.writeChartAsPNG(stream, chart, (int)Math.round(height*1.4), height);
        stream.close();
    }

    public static void addGenerationDate(XYPlot xyplot) {
        //add scorecard generation date
        final String pattern = "dd MMM yyyy h:mm a";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        XYTextAnnotation gendate = new XYTextAnnotation("Scorecard Generated: " + date, 0.5, -7.5);
        gendate.setTextAnchor(TextAnchor.CENTER_LEFT);
        gendate.setBackgroundPaint(Color.white);
        gendate.setPaint(Color.red);
        gendate.setFont(theme.getRegularFont());
        xyplot.addAnnotation( gendate );
    }

    public static void makePoint(XYPlot xyplot, Point2D location, double radius, Color color ) {
        double x = location.getX() - radius/2;
        double y = location.getY() - radius/2;
        Shape dot = new Ellipse2D.Double(x, y, radius, radius);
        XYShapeAnnotation area = new XYShapeAnnotation(dot, new BasicStroke(), color, color );
        xyplot.addAnnotation( area );
    }    
    
    public static void makeRect(XYPlot xyplot, Point2D location, double height, double width, Color color ) {
        Shape rect = new Rectangle2D.Double(location.getX(), location.getY(), width, height);
        XYShapeAnnotation area = new XYShapeAnnotation(rect, new BasicStroke(), color, color );
        xyplot.addAnnotation( area );
    }    

    public static void makeTriangle(XYPlot xyplot, Point2D location, Color color ) {
        Polygon p = new Polygon();
        p.addPoint(0,0);
        p.addPoint(100,0);
        p.addPoint(100,100);
        XYShapeAnnotation area = new XYShapeAnnotation(p, new BasicStroke(), color, color );
        xyplot.addAnnotation( area );
    }
    
    public static void makeGuessingLine(XYPlot xyplot) {
        // draw guessing line
        XYLineAnnotation guessing = new XYLineAnnotation(-5, -5, 100, 100, dashed, Color.red);
        xyplot.addAnnotation(guessing);

        XYPointerAnnotation worse = makePointer(80, 0, "Worse than guessing", TextAnchor.TOP_CENTER, 90);
        xyplot.addAnnotation(worse);

        XYPointerAnnotation better = makePointer(25, 100, "Better than guessing", TextAnchor.BOTTOM_CENTER, 270);
        xyplot.addAnnotation(better);

        XYTextAnnotation stroketext = new XYTextAnnotation("                     Random Guess", 88, 107);
        stroketext.setTextAnchor(TextAnchor.CENTER_RIGHT);
        stroketext.setBackgroundPaint(Color.white);
        stroketext.setPaint(Color.red);
        stroketext.setFont(theme.getRegularFont());
        xyplot.addAnnotation(stroketext);

        XYLineAnnotation strokekey = new XYLineAnnotation(58, 107, 68, 107, dashed, Color.red);
        xyplot.setBackgroundPaint(Color.white);
        xyplot.addAnnotation(strokekey);
    }
    
    // Note that rotation is for the entire G2D, so put in coordinates accordingly
    public static void makeOval(XYPlot xyplot, double x, double y, double w, int h, int angle) {
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
    
    public static void makePointer(XYPlot plot, double x, double y, String msg, TextAnchor anchor, int angle ) {
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
    
}
