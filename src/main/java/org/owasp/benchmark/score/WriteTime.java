/**
 * OWASP Benchmark Project
 *
 * This file is part of the Open Web Application Security Project (OWASP)
 * Benchmark Project For details, please see
 * <a href="https://owasp.org/www-project-benchmark">https:/owasp.org/www-project-benchmark</a>.
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

package org.owasp.benchmark.score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owasp.benchmark.helpers.PropertiesManager;
import org.owasp.benchmark.helpers.Utils;
import org.owasp.benchmark.score.parsers.Reader;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class WriteTime {
	public static void main(String[] args) throws Exception {
		// findbugs
		// mvn clean compile org.codehaus.mojo:findbugs-maven-plugin:3.0.5:findbugs -Dbuildtime.output.csv=true
		// -Dbuildtime.output.csv.file=classes\out.csv
		// pmd
		// mvn pmd:pmd -Dbuildtime.output.csv=true
		// -Dbuildtime.output.csv.file=classes\out.csv
		// findbugs
		// mvn clean compile -Pfindsecbugs -Dbuildtime.output.csv=true
		// -Dbuildtime.output.csv.file=classes\out.csv
		// spotbugs
		// mvn spotbugs:spotbugs -Dbuildtime.output.csv=true
		// -Dbuildtime.output.csv.file=classes\out.csv
		// rewrite results file name with times and version
		String toolName = "";
		String csvToolName = "";
		if (args.length < 1) {
			System.out.println("Please provide the name of the tool.\n"
			+ "Currently supported: PMD (pmd), FindBugs (findbugs), FindSecBugs (findbugs), and SpotBugs (spotbugs).");
		} else {
			toolName = args[0];
		}
		//System.out.println("Tool: " + toolName);

		WriteFiles wf = new WriteFiles();

		switch (toolName) {
			case "crawler":
				csvToolName = "exec-maven-plugin:java";
				break;
			case "findbugs":
				csvToolName = "findbugs";
				break;
			case "findsecbugs":
			case "spotbugs":
				csvToolName = "spotbugs";
				break;
			case "pmd":
				csvToolName = "pmd";
				break;
			default:
				System.out.println(toolName 
					+ " is not one of the supported tools for mvn validate -Ptime, provided by score/WriteTime.java");
				return;
		}

		// We use the benchmark.properties file as a temporary place to write out the tool name and
		// execution times for these plugins tested via this main method
		PropertiesManager propM = new PropertiesManager();
		propM.saveProperty(toolName, wf.getToolTime(csvToolName));

		wf.deletePreviousResults(toolName, wf.getVersionNumber(toolName), propM.getProperty("testsuite-version", ""));

		wf.resultsFileName(toolName, propM.getProperty("testsuite-version", ""), propM.getProperty(toolName, ""),
				wf.getVersionNumber(toolName));
	}
}

class WriteFiles {
//	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String CSV_TIMES_FILE = "out.csv";
	private static final String CONTRAST_FILE = "Benchmark_";
	private static final String FINDBUGS_FILE = "target/findbugsXml.xml";
	private static final String PMD_FILE = "target/pmd.xml";
	private static final String SPOTBUGS_FILE = "target/spotbugsXml.xml";

	public String getVersionNumber(String toolName) {
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			// Prevent XXE
			docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			InputSource is = null;
			Document doc = null;
			Node root = null;

			File findbugsFile = new File(FINDBUGS_FILE); // default

			switch (toolName) {
				case "spotbugs":
					findbugsFile = new File(SPOTBUGS_FILE);
					// fall through, on purpose.
				case "findbugs":
					is = new InputSource(new FileInputStream(findbugsFile));
					doc = docBuilder.parse(is);
					root = doc.getDocumentElement();
					return Reader.getAttributeValue("version", root);
				case "findsecbugs":
					return WriteFiles
							.getLine(new File("pom.xml"), "findsecbugs-plugin", true)
							.trim().replace("<version>", "")
							.replace("</version>", "");
				case "pmd":
					is = new InputSource(new FileInputStream(new File(PMD_FILE)));
					doc = docBuilder.parse(is);
					root = doc.getDocumentElement();
					return Reader.getAttributeValue("version", root);
			}
		} catch (Exception e) {
			System.out.println("An error occurred during results file parsing: " + e.getMessage());
		}
		return "";
	}

	public static String getLine(File file, String toFind, boolean nextLine) {

		try ( BufferedReader br = new BufferedReader(new FileReader(file)) ) {
			String line = "";
			while (line.equals("")) {
				line = br.readLine();
				if (line.contains(toFind)) {
					if (nextLine) return br.readLine();
					  else return line;
				} else line = "";
			}
			// System.out.println(line.trim().replace(" ", ""));
		} catch (Exception e) {
			System.out.println("Error");
		}
		return "";
	}

	public static void listPathFiles(String path) {
		String files;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				System.out.println(files);
			}
		}
	}

	public void deletePreviousResults(String toolName, String toolVersion, String benchmarkVersion) {
		if (!toolName.equals("")) {
			File targetDir = new File("results/");
			if (targetDir.exists()) {
				File[] files = targetDir.listFiles();
				for (File file : files) {
					if (file.isFile()
							&& (file.getName().startsWith(
									"Benchmark_" + benchmarkVersion + "-"
											+ toolName + "-v" + toolVersion) && (file
									.getName().endsWith("xml")))) {
						file.delete();
					}
				}
				System.out.println("Deleted previously generated results files.");
			}
		}
	}

	public void resultsFileName(String tool, String benchmarkVersion, String times, String toolVersion) {
		String name = "results/Benchmark_" + benchmarkVersion + "-" + tool
				+ "-v" + toolVersion + "-" + times + ".xml";
		File file = null;

		File targetDir = new File("results/");
		if (!targetDir.exists()) {
			targetDir.mkdir();
		}

		// System.out.println("inside results file: "+tool);
		switch (tool) {
			case "findbugs":
				file = new File(FINDBUGS_FILE);
				if (file.exists()) {
					file.renameTo(new File(name));
				}
				break;
			case "pmd":
				file = new File(PMD_FILE);
				if (file.exists()) {
					file.renameTo(new File(name));
				}
				break;
			case "findsecbugs":  // findsecbugs now runs with spotbugs, not findbugs
			case "spotbugs":
				file = new File(SPOTBUGS_FILE);
				if (file.exists()) {
					file.renameTo(new File(name));
				}
				break;
			case "crawler":
				file = new File("results/" + findFile("results", CONTRAST_FILE + benchmarkVersion + "-Contrast"));
				if (file.exists()) {
					file.renameTo(new File("results/" + file.getName().replace(".zip", "-" + times + ".zip")));
				}
				break;
		}
	}
/*
	public static String getHttpResponse(String url, String errorMessege) {
		StringBuffer response = new StringBuffer();
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (Exception e) {
			System.out.println(errorMessege);
		}
		return response.toString();
	}
*/
	public String getToolTime(String toolName) {

		List<String> lines = Utils.getLinesFromFile(Utils.getFileFromClasspath(
				CSV_TIMES_FILE, this.getClass().getClassLoader()));
		for (String i : lines) {
			if (i.contains(toolName)) {
				String[] results = i.split(";"); // This is always expected to be a 3 element array
				String time = results[2].replaceAll("\"", "");
				// System.out.println(time.split("\\.")[0]);
				return time.split("\\.")[0];
			}
		}
		return "";
	}

	/**
	 * Find the file that starts with 'name' in the folder 'path'.
	 * @param path - The folder to look in.
	 * @param name - The name to look for
	 * @return - The first file found starting with that name, if it exists.
	 */
	private String findFile(String path, String name) {
		File[] listOfFiles = new File(path).listFiles();
		if (listOfFiles == null) System.out.println("Specified path is not an existing directory: " + path);

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().startsWith(name)) {
				return listOfFiles[i].getName();
			}
		}
		return "";
	}

}
