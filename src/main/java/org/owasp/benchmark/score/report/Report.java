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

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Map;

import org.owasp.benchmark.score.BenchmarkScore;
import org.owasp.benchmark.score.parsers.Counter;
import org.owasp.benchmark.score.parsers.OverallResult;
import org.owasp.benchmark.score.parsers.OverallResults;
import org.owasp.benchmark.score.parsers.TestResults;

public class Report implements Comparable<Report>{
	
	private String toolName = "not specified";
	private String reportPath;
	private OverallResults overallResults;
	
	// The name of the file that contains this scorecard report
	private String filename = null;
	
	public Report(TestResults actualResults, Map<String, Counter> scores, OverallResults or, 
		int totalResults, String actualResultsFileName) throws IOException, URISyntaxException {
                
        toolName = actualResults.getTool();
        String version = actualResults.getToolVersion();
        if (version != null)
        	version = " v" + version;
        else version = "";
        
        String fullTitle = "OWASP Benchmark Scorecard for " + toolName + version;
        String shortTitle = "Benchmark v" + BenchmarkScore.benchmarkVersion + " Scorecard for " + toolName;
        filename = shortTitle.replace( ' ', '_' );
        
        overallResults = or;
        
        reportPath = BenchmarkScore.scoreCardDirName + File.separator + filename + ".html";
        File img = new File( BenchmarkScore.scoreCardDirName + File.separator + filename + ".png" );
        Scatter graph = new Scatter( shortTitle, 800, 800, or);
        
        graph.writeChartToFile( img, 800, 800 );

        String reportHtml = generateHtml( fullTitle, actualResults, scores, or, totalResults, img, actualResultsFileName );
        Files.write(Paths.get( reportPath ), reportHtml.getBytes());
        System.out.println("Report written to: " + new File(reportPath).getAbsolutePath());
    }

	/**
	 * Gets the name of the tool that produced the results for this scorecard.
	 * @return Name of the tool.
	 */
	public String getToolName() {
		return toolName;
	}
	
	/**
	 * Gets the name of the file that contains this scorecard.
	 * @return Name of the file (without any path information)
	 */
	public String getFilename() {
		return filename;
	}
	
	/**
	 * Gets the overall results used to calculate this scorecard.
	 * @return the overall results for this scorecard.
	 */
	public OverallResults getOverallResults() {
		return overallResults;
	}
	
    private String generateHtml( String title, TestResults actualResults, Map<String, Counter> scores, 
    		OverallResults or, int totalResults, File img, String actualResultsFileName) throws IOException, URISyntaxException {
        String template = new String(Files.readAllBytes(Paths.get(BenchmarkScore.pathToScorecardResources + "template.html")));
    	
//    	String template = new String(Files.readAllBytes(
//                Paths.get(this.getClass().getClassLoader()
//                        .getResource("template.html")
//                        .toURI())));
    	
        String html = template;
        html = html.replace( "${title}", title );
        html = html.replace( "${tests}", Integer.toString(totalResults) );
        html = html.replace( "${time}", or.getTime() );
        html = html.replace( "${score}", ""+new DecimalFormat("#0.00%").format(or.getScore() ) );
        html = html.replace( "${tool}", actualResults.getTool() );
        html = html.replace( "${version}", BenchmarkScore.benchmarkVersion );
        html = html.replace( "${actualResultsFile}", actualResultsFileName );
        
        
        String imgTag = "<img align=\"middle\" src=\"" + img.getName() + "\" />";        
        html = html.replace( "${image}", imgTag );

        String table = generateTable( actualResults, scores, or );
        html = html.replace( "${table}", table );
        
        return html;
    }

    private String generateTable(TestResults actualResults, Map<String, Counter> scores, OverallResults or) {
        StringBuilder sb = new StringBuilder();
        sb.append( "<table class=\"table\">\n");
        sb.append( "<tr>" );
        sb.append( "<th>Category</th>");
        sb.append( "<th>TP</th>");
        sb.append( "<th>FN</th>");
        sb.append( "<th>TN</th>");
        sb.append( "<th>FP</th>");
        sb.append( "<th>Total</th>");
        sb.append( "<th>TPR</th>");
        sb.append( "<th>FPR</th>");
        sb.append( "<th>Score</th>");
        sb.append( "</tr>\n");
        Counter totals = new Counter();
        double totalTPR = 0;
        double totalFPR = 0;
        double totalScore = 0;

        for ( String category : scores.keySet() ) {
            Counter c = scores.get( category );
            OverallResult r = or.getResults(category);
            String style = "";
            if ( Math.abs( r.tpr - r.fpr ) < .1 ) style = "class=\"danger\"";
            else if ( r.tpr > .7 && r.fpr < .3 ) style = "class=\"success\"";
            sb.append( "<tr "+style+">" );
            sb.append( "<td>" + category + "</td>");
            sb.append( "<td>" + (int)c.tp + "</td>");
            sb.append( "<td>" + (int)c.fn + "</td>");
            sb.append( "<td>" + (int)c.tn + "</td>");
            sb.append( "<td>" + (int)c.fp + "</td>");
            sb.append( "<td>" + (int)r.total + "</td>");
            sb.append( "<td>" + new DecimalFormat("#0.00%").format(r.tpr) + "</td>");
            sb.append( "<td>" + new DecimalFormat("#0.00%").format(r.fpr) + "</td>");
            sb.append( "<td>" + new DecimalFormat("#0.00%").format(r.score) + "</td>");
            sb.append( "</tr>\n");
            totals.tp += c.tp;
            totals.fn += c.fn;
            totals.tn += c.tn;
            totals.fp += c.fp;
            if ( !Double.isNaN(r.tpr) ) totalTPR += r.tpr;
            if ( !Double.isNaN(r.fpr) ) totalFPR += r.fpr;
            if ( !Double.isNaN(r.score) ) totalScore += r.score;
        }
        sb.append( "<th>"+"Totals"+"</th>");
        sb.append( "<th>"+(int)totals.tp+"</th>");
        sb.append( "<th>"+(int)totals.fn+"</th>");
        sb.append( "<th>"+(int)totals.tn+"</th>");
        sb.append( "<th>"+(int)totals.fp+"</th>");
        sb.append( "<th>"+(int)(totals.tp+totals.fn+totals.tn+totals.fp)+"</th>");
        sb.append( "<th>"+new DecimalFormat("#0.00%").format(totalTPR/scores.size()) +"</th>");
        sb.append( "<th>"+new DecimalFormat("#0.00%").format(totalFPR/scores.size()) +"</th>");
        sb.append( "<th>"+new DecimalFormat("#0.00%").format(totalScore/scores.size()) +"</th>");
        sb.append( "</tr>\n");
        sb.append( "</table>");
        return sb.toString();
    }

    public int compareTo(Report r) {
    	return this.toolName.compareTo(r.toolName);
    }
}
