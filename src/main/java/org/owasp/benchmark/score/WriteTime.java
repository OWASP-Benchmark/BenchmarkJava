package org.owasp.benchmark.score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
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
		// sonar
		// mvn sonar:sonar -Dbuildtime.output.csv=true
		// spotbugs
		// mvn spotbugs:spotbugs -Dbuildtime.output.csv=true
		// -Dbuildtime.output.csv.file=classes\out.csv
		// rewrite results file name with times and version
		String toolName = "";
		String csvToolName = "";
		if (args.length < 1) {
			System.out.println("Please provide the name of the tool.\n"
			+ "Currently supported: PMD (pmd), FindBugs (findbugs), FindSecBugs (findbugs), SonarQube (sonar), and SpotBugs (spotbugs).");
		} else {
			toolName = args[0];
		}
		//System.out.println("Tool: " + toolName);

		PropertiesManager propM = new PropertiesManager();
		WriteFiles wf = new WriteFiles();
		if (toolName.contains("sonar")) { // We need to generate the results
			// file from the webService
			wf.writeSonarResults();
		}

		switch (toolName) {
			case "crawler":
				csvToolName = "exec-maven-plugin:java";
				break;
			case "findbugs":
			case "findsecbugs":
			case "spotbugs":
				csvToolName = "findbugs";
				break;
			case "pmd":
				csvToolName = "pmd";
				break;
			case "sonar":
				csvToolName = "sonar";
				break;
			default:
				System.out.println(toolName 
					+ " is not one of the supported tools for mvn validate -Ptime, provided by score/WriteTime.java");
				return;
		}

		propM.saveProperty(toolName, wf.getToolTime(csvToolName));
		propM.saveProperty("benchmark-version", wf.getbenchmarkVersion()); //
		// propM.displayProperties();

		wf.deletePreviousResults(toolName, wf.getVersionNumber(toolName),
				propM.getProperty("benchmark-version", ""));

		wf.resultsFileName(toolName,
				propM.getProperty("benchmark-version", ""),
				propM.getProperty(toolName, ""), wf.getVersionNumber(toolName));
	}
}

class WriteFiles {
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String CSV_TIMES_FILE = "out.csv";
	private static final String VERSION_FILE = "benchmark.properties";
	private static final String CONTRAST_FILE = "Benchmark_";
	private static final String FINDBUGS_FILE = "target/findbugsXml.xml";
	private static final String PMD_FILE = "target/pmd.xml";
	private static final String SONAR_FILE = "target/sonarqube.xml";
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
				case "sonar":
					return "TBD";
			}
		} catch (Exception e) {
			System.out.println("An error occurred during results file parsing: " + e.getMessage());
		}
		return "";
	}

	public static String getLine(File file, String toFind, boolean nextLine) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = "";
			while (line.equals("")) {
				line = br.readLine();
				if (line.contains(toFind)) {
					if (nextLine) {
						return br.readLine();
					} else {
						return line;
					}
				} else {
					line = "";
				}
			}
			// System.out.println(line.trim().replace(" ", ""));
		} catch (Exception e) {
			System.out.println("Error");
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				System.out.println("Can't close filereader for file: "
						+ file.getAbsolutePath() + " for some reason.");
				e.toString();
			}
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

	public void deletePreviousResults(String toolName, String toolVersion,
			String benchmarkVersion) {
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

	public void resultsFileName(String tool, String benchmarkVersion,
			String times, String toolVersion) {
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
			case "sonar":
				file = new File(SONAR_FILE);
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
				file = new File("results/" + getFindFile("results", CONTRAST_FILE + benchmarkVersion + "-Contrast"));
				if (file.exists()) {
					file.renameTo(new File("results/" + file.getName().replace(".zip", "-" + times + ".zip")));
				}
				break;
		}
	}

	public void writeSonarResults() {

		int page = 1;
		int total = 1;
		JSONArray issues = new JSONArray();
		JSONObject json = null;

		try {
			while (issues.length() < total) {
				json = new JSONObject(getSonarResults("http://localhost:9000", page));
				total = (int) json.get("total");

				JSONArray issueSubset = json.getJSONArray("issues");
				for (int i = 0; i < issueSubset.length(); i++) {
					issues.put(issueSubset.get(i));
				}
				page++;
			}

			json.put("issues", issues);

			String xml = XML.toString(json);
			java.io.FileWriter fw = new java.io.FileWriter(SONAR_FILE);
			fw.write(xml);
			fw.close();
		} catch (Exception e) {
			System.out.println("There was an error while writing SonarQube results.");
		}
	}

	public static String getSonarResults(String sonarURL, int page) {
		StringBuffer response = new StringBuffer();
		try {
			String url = sonarURL + "/api/issues/search?resolved=false&ps=500&p=" + page;
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
			System.out.println("There was an error trying to retrieve SonarQube results.");
		}
		return response.toString();
	}

	public String getToolTime(String toolName) {
		String[] results = new String[3];
		String time = null;
		List<String> lines = Utils.getLinesFromFile(Utils.getFileFromClasspath(
				CSV_TIMES_FILE, this.getClass().getClassLoader()));
		for (String i : lines) {
			if (i.contains(toolName)) {
				results = i.split(";");
				time = results[2].replaceAll("\"", "");
				// System.out.println(time.split("\\.")[0]);
				return time.split("\\.")[0];
			}
		}
		return "";
	}

	/**
	 * Gets the current version of the Benchmark from the benchmark.properties file.
	 * @return The version # (as a String). An empty string if its not defined in that file.
	 * @throws Exception
	 */
	public String getbenchmarkVersion() { // throws Exception {
		Properties benchMprops = new Properties();
		try {
			File propsFile = new File(this.getClass().getClassLoader().getResource(VERSION_FILE).toURI().getPath());
			benchMprops.load(new FileInputStream(propsFile));
			String v = benchMprops.getProperty("benchmark-version");
			if (v == null) return "";
			return v;
		} catch (IOException | URISyntaxException e) {
			System.out.println("Can't load version # from properties file.");
			e.printStackTrace();
			return "";
		}
	}
	
	private String getFindFile(String path, String name) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().startsWith(name)) {
				return listOfFiles[i].getName();
			}
		}
		return "";
	}

}
