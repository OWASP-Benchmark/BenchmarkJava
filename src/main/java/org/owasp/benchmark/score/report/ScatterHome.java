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
import org.owasp.benchmark.score.parsers.OverallResults;

public class ScatterHome extends ScatterPlot {
    private static char averageLabel;
    private double afr = 0;
    private double atr = 0;
    public final String focus;
    public static final char INITIAL_LABEL = 'A';

    
    /**
     * This calculates the summary chart across all the tools analyzed against the Benchmark.
     * @param title - The title of the chart to be produced.
     * @param height - Height of the chart (typically 800)
     * @param width - Width of the chart (typically 800)
     * @param toolResults - A list of each individual tool's results.
     */
    public ScatterHome(String title, int height, Set<Report> toolResults, String focus ) {
        this.focus = focus;
        display("          " + title, height, toolResults );
    }

    private JFreeChart display(String title, int height, Set<Report> toolResults ) {
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        //averages
        ArrayList<Double> averageCommercialFalseRates = new ArrayList<Double>();
        ArrayList<Double> averageCommercialTrueRates = new ArrayList<Double>();
        
        XYSeriesCollection dataset = new XYSeriesCollection(); 
        XYSeries series = new XYSeries("Scores");    
        for ( Report toolReport : toolResults ) {
            if ( !toolReport.isCommercial() ) {
                OverallResults overallResults = toolReport.getOverallResults();
                series.add( overallResults.getFalsePositiveRate() * 100, overallResults.getTruePositiveRate() * 100);
                if(toolReport.isCommercial()){
                    averageCommercialFalseRates.add(overallResults.getFalsePositiveRate());
                    averageCommercialTrueRates.add(overallResults.getTruePositiveRate());
                }
            }
        }
        
        int commercialToolCount = 0;
        for ( Report toolReport : toolResults ) {
            if ( toolReport.isCommercial() ) {
            	commercialToolCount++;
                OverallResults overallResults = toolReport.getOverallResults();
                if (!BenchmarkScore.showAveOnlyMode) {
                	series.add( overallResults.getFalsePositiveRate() * 100, 
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
        afr = afr/averageCommercialFalseRates.size();
        
        for (double d : averageCommercialTrueRates) {
            atr += d;
        }
        atr = atr/averageCommercialTrueRates.size();
        
        if ( commercialToolCount > 1 || (BenchmarkScore.showAveOnlyMode && commercialToolCount == 1)) {
            series.add(afr *100, atr*100);
        }
        
        dataset.addSeries(series);
        
        chart = ChartFactory.createScatterPlot(title, "False Positive Rate", "True Positive Rate", dataset, PlotOrientation.VERTICAL, true, true, false);
        theme.apply(chart);

        XYPlot xyplot = chart.getXYPlot();
        initializePlot( xyplot );
        addGenerationDate( xyplot );
        
        makeDataLabels( toolResults, xyplot );
        makeLegend( toolResults, 103, 100.5, dataset, xyplot );

        for ( XYDataItem item : (List<XYDataItem>)series.getItems() ) {
            double x = item.getX().doubleValue();
            double y = item.getY().doubleValue();
            double z = (x+y)/2;
            XYLineAnnotation score = new XYLineAnnotation(x, y, z, z, dashed, Color.blue);
            xyplot.addAnnotation(score);
        }     

        ChartPanel cp = new ChartPanel(chart, height, height, 400, 400, 1200, 1200, false, false, false, false, false, false);
        f.add(cp);
        f.pack();
        f.setLocationRelativeTo(null);
//      f.setVisible(true);
        return chart;
    }

    
    private void makeDataLabels( Set<Report> toolResults, XYPlot xyplot ) {        
        HashMap<Point2D,String> map = makePointList( toolResults );
        for (Entry<Point2D,String> e : map.entrySet() ) {
            if ( e.getValue() != null ) {
                Point2D p = e.getKey();
                String label = sort( e.getValue() );
                XYTextAnnotation annotation = new XYTextAnnotation( label, p.getX(), p.getY());
                annotation.setTextAnchor( p.getX() < 3 ? TextAnchor.TOP_LEFT : TextAnchor.TOP_CENTER);
                annotation.setBackgroundPaint(Color.white);
                if (label.toCharArray()[0] == averageLabel)
                {
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
        String[] parts = value.split( "," );
        Arrays.sort( parts );
        StringBuilder sb = new StringBuilder();
        for ( int i=0; i < parts.length; i++ ) {
            sb.append( parts[i] );
            if ( i < parts.length -1 ) sb.append( "," );
        }
        return sb.toString();
    }

    
    static SecureRandom sr = new SecureRandom();
    // This method generates all the points put on the home page chart. One per tool.
    private HashMap<Point2D, String> makePointList( Set<Report> toolResults ) {          
        HashMap<Point2D,String> map = new HashMap<Point2D, String>();
        char ch = INITIAL_LABEL;
        
        // make a list of all points.  Add in a tiny random to prevent exact duplicate coordinates in map        
        int commercialToolCount = 0;
        for (Report r : toolResults ) {
            if ( !r.isCommercial() ) {
                OverallResults or = r.getOverallResults();
                double x = or.getFalsePositiveRate() * 100 + sr.nextDouble() * .000001;
                double y = or.getTruePositiveRate() * 100 + sr.nextDouble() * .000001 - 1;   // this puts the label just below the point
                Point2D p = new Point2D.Double(x,y);
                String label = "" + ch;
                map.put( p, label );
                // Weak hack if there are more than 26 tools scored. This will only get us to 52.
                if (ch == 'Z') ch = 'a'; else ch++;
            }
        }
        
        for (Report r : toolResults ) {
            if ( r.isCommercial() ) {
                commercialToolCount++;
                if ( !BenchmarkScore.showAveOnlyMode ) {
	                OverallResults or = r.getOverallResults();
	                double x = or.getFalsePositiveRate() * 100 + sr.nextDouble() * .000001;
	                double y = or.getTruePositiveRate() * 100 + sr.nextDouble() * .000001 - 1;   // this puts the label just below the point
	                Point2D p = new Point2D.Double(x,y);
	                String label = "" + ch ;
	                map.put( p, label );
	                // Weak hack if there are more than 26 tools scored. This will only get us to 52.
	                if (ch == 'Z') ch = 'a'; else ch++;
                }
            }
        }
        
        if ( commercialToolCount > 1 || (BenchmarkScore.showAveOnlyMode && commercialToolCount == 1)) {
            Point2D ap= new Point2D.Double(afr*100 + sr.nextDouble() * .000001,atr*100 + sr.nextDouble() * .000001 - 1);
            averageLabel = ch;
            map.put(ap, "" + ch);
        }
        
        dedupify( map );
        return map;
    }

    
    private static void dedupify(HashMap<Point2D, String> map) {
        for (Entry<Point2D,String> e1 : map.entrySet() ) {
            Entry<Point2D, String> e2 = getMatch( map, e1 );
            while ( e2 != null ) {
                StringBuilder label = new StringBuilder();
                if ( e1.getValue() != null ) label.append( e1.getValue() );
                if ( e1.getValue() != null && e2.getValue() != null ) label.append( "," );
                if ( e2.getValue() != null ) label.append( e2.getValue() );
                e1.setValue( label.toString() );
                e2.setValue(null);
                e2 = getMatch( map, e1 );
            }
        }
    }

    private static Entry<Point2D, String> getMatch(HashMap<Point2D, String> map, Entry<Point2D,String> e1) {
        for ( Entry<Point2D,String> e2 : map.entrySet() ) {
            Double xd = Math.abs( e1.getKey().getX() - e2.getKey().getX() );
            Double yd = Math.abs( e1.getKey().getY() - e2.getKey().getY() );
            boolean close = xd < 1 && yd < 3;
            if ( e1 != e2 && e1.getValue() != null && e2.getValue() != null && close ) {
                return e2;
            }
        }
        return null;
    }


    private void makeLegend( Set<Report> toolResults, double x, double y, XYSeriesCollection dataset, XYPlot xyplot ) {
        char ch = INITIAL_LABEL; // This is the first label in the Key with all the tools processed by this scorecard
        int i = -2; // Used to keep track of which row in the key were are processing. Helps calculate the Y axis
        			// location where to put the Key entry
        
        boolean printedNonCommercialLabel = false;
        
        //non-commercial results
        for (Report r : toolResults ) {
            OverallResults or = r.getOverallResults();
            if( !r.isCommercial() ) {
            	// print non-commercial label if there is at least one non-commercial tool
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
            	
                // Special hack to make it line up better if the letter is an 'I' or 'i'
                String label = ( ch == 'I' || ch == 'i' ? ch + ":  " : ""+ch + ": " );
                double score = or.getScore() * 100;
                String msg = "\u25A0 " + label + r.getToolNameAndVersion() + " (" + Math.round(score) + "%)";
                XYTextAnnotation stroketext3 = new XYTextAnnotation(msg, x, y + i * -3.3);
                stroketext3.setTextAnchor(TextAnchor.CENTER_LEFT);
                stroketext3.setBackgroundPaint(Color.white);
                stroketext3.setPaint(Color.blue);
                stroketext3.setFont(theme.getRegularFont());
                xyplot.addAnnotation(stroketext3);
                i++;
                // Weak hack if there are more than 26 tools scored. This will only get us to 52.
                if (ch == 'Z') ch = 'a'; else ch++;
            }
        }
        
        //commercial tools
        double totalScore = 0;
        boolean printedCommercialLabel = false;
        int commercialToolCount = 0;
        
        for ( Report r : toolResults ) {
            
            OverallResults or = r.getOverallResults();
            if ( r.isCommercial() ) {

                // print commercial label if there is at least one commercial tool
                if ( !printedCommercialLabel ) {
                    XYTextAnnotation stroketext = new XYTextAnnotation("Commercial", x, y + i * -3.3);
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
                String label = ( ch == 'I' || ch == 'i' ? ch + ":  " : ""+ch + ": " );
                double score = or.getScore() * 100;
                if (!BenchmarkScore.showAveOnlyMode) {
	                String msg = "\u25A0 " + label + r.getToolNameAndVersion() + " (" + Math.round(score) + "%)";
	                XYTextAnnotation stroketext4 = new XYTextAnnotation(msg, x, y + i * -3.3);
	                stroketext4.setTextAnchor(TextAnchor.CENTER_LEFT);
	                stroketext4.setBackgroundPaint(Color.white);
	                stroketext4.setPaint(Color.blue);
	                stroketext4.setFont(theme.getRegularFont());
	                xyplot.addAnnotation(stroketext4);
	                i++;
	                // Weak hack if there are more than 26 tools scored. This will only get us to 52.
	                if (ch == 'Z') ch = 'a'; else ch++;
                }
                totalScore+=score;
            }           
            if ( r.getToolName().replace(' ','_').equalsIgnoreCase(focus) ) {
                OverallResults orc = r.getOverallResults();
                Point2D focusPoint = new Point2D.Double( orc.getFalsePositiveRate()*100, orc.getTruePositiveRate()*100 );
                Color green = new Color(0,1,0,0.5f);
                makePoint(xyplot, focusPoint, 3, green );
            }
        }
      
        //commercial average
        if (commercialToolCount > 1 || (BenchmarkScore.showAveOnlyMode && commercialToolCount == 1)) {
            double averageScore = totalScore/commercialToolCount;
            XYTextAnnotation stroketext2 = new XYTextAnnotation("\u25A0 " + ch 
            	+ ": Commercial Average" + " (" + Math.round(averageScore) + "%)", x, y + i * -3.3);
            stroketext2.setTextAnchor(TextAnchor.CENTER_LEFT);
            stroketext2.setBackgroundPaint(Color.white);
            stroketext2.setPaint(Color.magenta);
            stroketext2.setFont(theme.getRegularFont());            
            xyplot.addAnnotation(stroketext2);

            Point2D averagePoint = new Point2D.Double( afr*100, atr*100 );
            makePoint(xyplot, averagePoint, 3, Color.magenta );
        }       
    }

    public static void generateComparisonChart(Set<Report> toolResults, String focus ) {
    	try {
    		String scatterTitle = "OWASP Benchmark" 
    				+ (BenchmarkScore.mixedMode ? "" : " v" + BenchmarkScore.benchmarkVersion) 
            		+ " Results Comparison";
    		ScatterHome scatter = new ScatterHome(scatterTitle, 800, toolResults, focus );
            scatter.writeChartToFile(new File("scorecard/benchmark_comparison.png"), 800);    		
    	} catch (IOException e) {
    		System.out.println("Couldn't generate Benchmark comparison chart for some reason.");
    		e.printStackTrace();
    	}
    }
    
}
