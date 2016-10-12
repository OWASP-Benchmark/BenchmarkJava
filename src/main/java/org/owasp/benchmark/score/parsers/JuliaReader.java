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
* @author Fausto Spoto <a href="http://www.juliasoft.com">Julia Srl</a>
* @created 2016
*/

package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class JuliaReader extends Reader {
	
	public TestResults parse(File f) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true); // Prevent XXE
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource(new FileInputStream(f));
		Document doc = docBuilder.parse(is);
		
		TestResults tr = new TestResults("Julia", true, TestResults.ToolType.SAST);
		
		// If the filename includes an elapsed time in seconds (e.g., TOOLNAME-seconds.xml), set the compute time on the scorecard.
		tr.setTime(f);

		String fileName = f.getName();
		String version = fileName.substring(fileName.indexOf("julia-v") + 7, fileName.lastIndexOf('-'));
		tr.setToolVersion(version);

		Node root = doc.getDocumentElement();
		NodeList nl = root.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);
			if (n.getNodeName().equals("warning"))
				tr.put(parseJuliaBug(n));
		}
		
		return tr;
	}
	
	// refactoring resilient
	private final static String prefixOfTest = org.owasp.benchmark.testcode.BenchmarkTest00001.class.getName().substring(0, org.owasp.benchmark.testcode.BenchmarkTest00001.class.getName().length() - 5);

	private TestCaseResult parseJuliaBug(Node n) {
		TestCaseResult tcr = new TestCaseResult();

		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node child = nl.item(i);
			String childName = child.getNodeName();
			if (childName.equals("className")) {
				String where = child.getTextContent();
				if (where.startsWith(prefixOfTest)) {
					String testNumber = where.substring(where.lastIndexOf('.') + 1 + "BenchmarkTest".length());
					tcr.setNumber(Integer.parseInt(testNumber));
				}
			}
			else if (childName.equals("CWEid"))
				tcr.setCWE(Integer.parseInt(child.getTextContent()));
		}

		return tcr;
	}
}

