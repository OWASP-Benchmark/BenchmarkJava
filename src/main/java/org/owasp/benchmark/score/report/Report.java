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
import org.owasp.benchmark.score.parsers.TestResults.ToolType;

public class Report implements Comparable<Report> {

	private final boolean isCommercial;
	private ToolType toolType;
	private String toolName = "not specified";
	private final String benchmarkVersion;
	private final Map<String, Counter> scores;
	private final OverallResults overallResults;
	private final String reportPath;
	private static int toolcount = 1;
	private final int toolNumber;
	
	// The name of the file that contains this scorecard report
	private String filename = null;
	private String focus = null;
	
	public Report(TestResults actualResults, Map<String, Counter> scores, OverallResults or, int totalResults,
			String actualResultsFileName, boolean isCommercial, ToolType toolType, String focus ) throws IOException, URISyntaxException {
		toolNumber = toolcount++;
		this.isCommercial = isCommercial;
		this.toolType = toolType;
		this.toolName = actualResults.getTool();
		this.toolType = actualResults.toolType;
		this.focus = focus;
		String version = actualResults.getToolVersion();
		if (version != null && (!BenchmarkScore.anonymousMode || !isCommercial)) {
			version = " v" + version;
		} else version = "";
		this.benchmarkVersion = actualResults.getBenchmarkVersion();

		String fullTitle = "OWASP Benchmark Scorecard for " + getToolName() + version;
		String shortTitle = "Benchmark v" + actualResults.getBenchmarkVersion() + " Scorecard for " + getToolName();
		this.filename = shortTitle.replace(' ', '_');

		this.scores = scores;
		this.overallResults = or;

		this.reportPath = BenchmarkScore.scoreCardDirName + File.separator + filename + ".html";
		File img = new File(BenchmarkScore.scoreCardDirName + File.separator + filename + ".png");
		ScatterTools graph = new ScatterTools(shortTitle, 800, or);

		if (!(BenchmarkScore.showAveOnlyMode && this.isCommercial)) {
			graph.writeChartToFile(img, 800);	
			String reportHtml = generateHtml(fullTitle, actualResults, scores, or, totalResults, img, actualResultsFileName);
			Files.write(Paths.get(reportPath), reportHtml.getBytes());
			System.out.println("Report written to: " + new File(reportPath).getAbsolutePath());
		}
	}

	/**
	 * Gets the name of the tool that produced the results for this scorecard.
	 * 
	 * @return Name of the tool.
	 */
	public String getToolName() {
		return this.toolName;
	}

	public boolean isCommercial() {
		return this.isCommercial;
	}

	public ToolType getToolType() {
		return toolType;
	}

	public String getBenchmarkVersion() {
		return this.benchmarkVersion;
	}
	
	/**
	 * Gets the name of the file that contains this scorecard.
	 * 
	 * @return Name of the file (without any path information)
	 */
	public String getFilename() {
		return this.filename;
	}

	/**
	 * Gets the overall results used to calculate this scorecard.
	 * 
	 * @return the overall results for this scorecard.
	 */
	public OverallResults getOverallResults() {
		return this.overallResults;
	}

	private String generateHtml(String title, TestResults actualResults, Map<String, Counter> scores, OverallResults or,
			int totalResults, File img, String actualResultsFileName) throws IOException, URISyntaxException {
		String template = new String(
				Files.readAllBytes(Paths.get(BenchmarkScore.pathToScorecardResources + "template.html")));

		// String template = new String(Files.readAllBytes(
		// Paths.get(this.getClass().getClassLoader()
		// .getResource("template.html")
		// .toURI())));

		String html = template;
		html = html.replace("${title}", title);
		html = html.replace("${tests}", Integer.toString(totalResults));
		html = html.replace("${time}", or.getTime());
		html = html.replace("${score}", "" + new DecimalFormat("#0.00%").format(or.getScore()));
		html = html.replace("${tool}", actualResults.getTool());
		html = html.replace("${version}", actualResults.getBenchmarkVersion());
		html = html.replace("${actualResultsFile}", actualResultsFileName);

		String imgTag = "<img align=\"middle\" src=\"" + img.getName() + "\" />";
		html = html.replace("${image}", imgTag);

		String table = generateTable(actualResults, scores, or);
		html = html.replace("${table}", table);

		return html;
	}

	private String generateTable(TestResults actualResults, Map<String, Counter> scores, OverallResults or) {
		StringBuilder sb = new StringBuilder();
		sb.append("<table class=\"table\">\n");
		sb.append("<tr>");
		sb.append("<th>Category</th>");
		sb.append("<th>TP</th>");
		sb.append("<th>FN</th>");
		sb.append("<th>TN</th>");
		sb.append("<th>FP</th>");
		sb.append("<th>Total</th>");
		sb.append("<th>TPR</th>");
		sb.append("<th>FPR</th>");
		sb.append("<th>Score</th>");
		sb.append("</tr>\n");
		Counter totals = new Counter();
		double totalTPR = 0;
		double totalFPR = 0;
		double totalScore = 0;

		for (String category : scores.keySet()) {
			
			Counter c = scores.get(category);
			OverallResult r = or.getResults(category);
			String style = "";
			
			if (Math.abs(r.truePositiveRate - r.falsePositiveRate) < .1)
				style = "class=\"danger\"";
			else if (r.truePositiveRate > .7 && r.falsePositiveRate < .3)
				style = "class=\"success\"";
			sb.append("<tr " + style + ">");
			sb.append("<td>" + category + "</td>");
			sb.append("<td>" + c.tp + "</td>");
			sb.append("<td>" + c.fn + "</td>");
			sb.append("<td>" + c.tn + "</td>");
			sb.append("<td>" + c.fp + "</td>");
			sb.append("<td>" + r.total + "</td>");
			sb.append("<td>" + new DecimalFormat("#0.00%").format(r.truePositiveRate) + "</td>");
			sb.append("<td>" + new DecimalFormat("#0.00%").format(r.falsePositiveRate) + "</td>");
			sb.append("<td>" + new DecimalFormat("#0.00%").format(r.score) + "</td>");
			sb.append("</tr>\n");
			totals.tp += c.tp;
			totals.fn += c.fn;
			totals.tn += c.tn;
			totals.fp += c.fp;
			if (!Double.isNaN(r.truePositiveRate))
				totalTPR += r.truePositiveRate;
			if (!Double.isNaN(r.falsePositiveRate))
				totalFPR += r.falsePositiveRate;
			if (!Double.isNaN(r.score))
				totalScore += r.score;
		}
		sb.append("<th>" + "Totals" + "</th>");
		sb.append("<th>" + totals.tp + "</th>");
		sb.append("<th>" + totals.fn + "</th>");
		sb.append("<th>" + totals.tn + "</th>");
		sb.append("<th>" + totals.fp + "</th>");
		int total = totals.tp + totals.fn + totals.tn + totals.fp;
		sb.append("<th>" + total + "</th>");
		double tpr = (totalTPR / scores.size());
		sb.append("<th>" + new DecimalFormat("#0.00%").format(tpr) + "</th>");
		double fpr = (totalFPR / scores.size());
		sb.append("<th>" + new DecimalFormat("#0.00%").format(fpr) + "</th>");
		double score = totalScore / scores.size();
		sb.append("<th>" + new DecimalFormat("#0.00%").format(score) + "</th>");
		sb.append("</tr>\n");
		sb.append("</table>");
				
		return sb.toString();
	}

	public int compareTo(Report r) {
		return this.getToolName().toLowerCase().compareTo(r.getToolName().toLowerCase());
	}

	public Map<String, Counter> getScores() {
		return 	this.scores;
	}
	
}
