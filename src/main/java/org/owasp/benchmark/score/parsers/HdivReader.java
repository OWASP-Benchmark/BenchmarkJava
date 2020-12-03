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
 * @author Joseba Ander Ruiz Ayesta
 * @created 2017
 */

package org.owasp.benchmark.score.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.owasp.benchmark.score.BenchmarkScore;

public class HdivReader extends Reader {

	Set<String> invalid = new HashSet<>();

	public static void main(final String[] args) throws Exception {
		File f = new File("hdivAgentLog.hlg");
		HdivReader cr = new HdivReader();
		System.out.println(cr.parse(f));
	}

	public TestResults parse(final File f) throws Exception {
		TestResults tr = new TestResults("Hdiv", true, TestResults.ToolType.IAST);

		BufferedReader reader = new BufferedReader(new FileReader(f));
		String firstLine = reader.readLine();
		String lastLine = "";
		String line = "";
		ArrayList<String> chunk = new ArrayList<>();
		String testNumber = "00001";
		while (line != null) {
			try {
				line = reader.readLine();
				if (line != null) {
					if (line.contains("SourceCodeVulnerability [")) {
						// ok, we're starting a new URL, so process this one and start the next chunk
						process(tr, testNumber, Arrays.asList(line));
						chunk.clear();
						testNumber = "00000";
						String fname = "/" + BenchmarkScore.TESTCASENAME;
						int idx = line.indexOf(fname);
						if (idx != -1) {
							testNumber = line.substring(idx + fname.length(), idx + fname.length() + 5);
						}
						lastLine = line;
					}
					else if (line.contains("Product version:")) {
						String version = line.substring(line.indexOf("version:")+"version:".length());
						tr.setToolVersion(version);
					}
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		reader.close();
		tr.setTime(calculateTime(firstLine, lastLine));
		return tr;
	}

	private String calculateTime(final String firstLine, final String lastLine) {
		try {
			try {
				return calculateTime(firstLine, lastLine, 0);
			} catch (ParseException e) {
				return calculateTime(firstLine, lastLine, 1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String calculateTime(final String firstLine, final String lastLine, final int timeColumn) throws ParseException {
		String start = firstLine.split(" ")[timeColumn];
		String stop = lastLine.split(" ")[timeColumn];
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss,SSS");
		Date startTime = sdf.parse(start);
		Date stopTime = sdf.parse(stop);
		long startMillis = startTime.getTime();
		long stopMillis = stopTime.getTime();
		return (stopMillis - startMillis) / 1000 + " seconds";
	}

	private void process(final TestResults tr, String testNumber, final List<String> chunk) throws Exception {
		for (String line : chunk) {
			TestCaseResult tcr = new TestCaseResult();

			String fname = "/" + BenchmarkScore.TESTCASENAME;
			int idx = line.indexOf(fname);
			if (idx != -1) {
				testNumber = line.substring(idx + fname.length(), idx + fname.length() + 5);
			}

			String type = line.substring(line.indexOf("type=") + 5, line.indexOf(',', line.indexOf("type=")));

			try {
				Type t = Type.valueOf(type);
				tcr.setCWE(t.number);
				tcr.setCategory(t.id);

				try {
					tcr.setNumber(Integer.parseInt(testNumber));
				}
				catch (NumberFormatException e) {
					System.out.println("> Parse error: " + line);
				}

				if (tcr.getCWE() != 0) {
					tr.put(tcr);
				}
			}
			catch (Exception e) {
				if (invalid.add(type)) {
					System.out.println("Invalid type:" + type);
				}
			}

		}
	}

	enum Type {

		CMD_INJECTION(78),
		INSECURE_HASHING("crypto-bad-mac", 328),
		INSECURE_CIPHER("crypto-bad-ciphers", 327),
		HEADER_INJECTION(113),
		INSECURE_COOKIE("cookie-flags-missing", 614),
		LDAP_INJECTION(90),
		NO_HTTP_ONLY_COOKIE(1004),
		PATH_TRAVERSAL(22),
		REFLECTION_INJECTION(0),
		SQL_INJECTION(89),
		STACKTRACE_LEAK(209),
		TRUST_BOUNDARY_VIOLATION(501),
		WEAK_RANDOMNESS("crypto-weak-randomness", 330),
		XPATH_INJECTION(643),
		XSS("reflected-xss", 79);

		private final int number;

		private final String id;

		private Type(final int number) {
			this.number = number;
			id = name().toLowerCase().replaceAll("_", "-");
		}

		private Type(final String id, final int number) {
			this.number = number;
			this.id = id;
		}
	}

}
