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
 * @created 2021
 */

package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owasp.benchmark.score.BenchmarkScore;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class CrashtestReader extends Reader {

// <testsuites name="" tests="16553" disabled="0" errors="5" failures="440" time="128361">
//   <testsuite name="Crashtest Security Suite" tests="16553" disabled="0" errors="5" failures="440" skipped="0" time="128361">
//	 <testcase classname="ssl.crashtest.cloud" name="Transport Layer Security (TLS/SSL) (1)">
//	   <failure message="TLS 1.1 is offered by the server. This version of TLS is deprecated. You should use TLS 1.2 or TLS 1.3" type="high"/>

	public TestResults parse(File f) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// Prevent XXE
		docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		InputSource is = new InputSource( new FileInputStream(f) );
		Document doc = docBuilder.parse(is);

		TestResults tr = new TestResults( "Crashtest Security", false, TestResults.ToolType.DAST);

		Node crashtest = doc.getDocumentElement();
		String time = crashtest.getAttributes().getNamedItem("time").getNodeValue();
		// They provide the time in seconds but formatTime expects milliseconds
		tr.setTime(TestResults.formatTime(time + "000"));
		Node testsuite = getNamedChild( "testsuite", crashtest );
//		tr.setToolVersion( version );

		List<Node> issueList = getNamedChildren( "testcase", testsuite );

		for ( Node issue : issueList ) {
			try {
				TestCaseResult tcr = parseCrashtestIssue(issue);
				if (tcr != null ) {
					tr.put(tcr);
				}
			} catch( Exception e ) {
				// print and continue
				e.printStackTrace();
			}
		}
		return tr;
	}

//	 Example real finding:
//	 <testcase classname="commandinjection.crashtest.cloud" name="Command Injection (1)">
//	   <failure message="Found command injection in GET parameter 'BenchmarkTest00407' for 
//		 URL 'https://vespiary.de:8443/benchmark/cmdi-00/BenchmarkTest00407',
//		 with payload '; echo crashtest-security$((12*12))'" type="critical"/>
//	 </testcase>
//  Example empty finding:
//	 <testcase classname="xxe.crashtest.cloud" name="XML External Entity (XXE) (2740)"/>

	private TestCaseResult parseCrashtestIssue(Node testcase) throws URISyntaxException {
		TestCaseResult tcr = new TestCaseResult();
		Node failure = getNamedChild("failure", testcase);
		if ( failure == null ) return null; // No finding found

		String testCaseType = testcase.getAttributes().getNamedItem("classname").getNodeValue();

		int cwe = cweLookup( testCaseType );
		tcr.setCWE(cwe);
		if ( cwe != -1) {
			String message = failure.getAttributes().getNamedItem("message").getNodeValue();

			// Parse testcase # from URL:
// message="Found command injection in GET parameter 'BenchmarkTest00407' for 
//			 URL 'https://vespiary.de:8443/benchmark/cmdi-00/BenchmarkTest00407',
//			 with payload '; echo crashtest-security$((12*12))'"

			String URLStart = "URL '";
			int startOfUrl = message.indexOf(URLStart);
			if (startOfUrl == -1) {
				// Try again looking for this:
				// Found possible XSS vulnerability in the referer
				// on site 'vespiary.de:8443/benchmark/xss-02/BenchmarkTest01181' with ...
				URLStart = "on site '";
				startOfUrl = message.indexOf(URLStart);
				if (startOfUrl == -1) {
					// And again for: on site vespiary.de:8443/benchmark/xss-02/BenchmarkTest01181. The ...
					URLStart = "on site ";
					startOfUrl = message.indexOf(URLStart);
					if (startOfUrl == -1) {
						if ( !message.equals("Failed") ) {
							System.out.println("Couldn't find URL in Crashtest finding message: " + message);
						}
						return null;
					}
				}
			}
			message = message.substring(startOfUrl + URLStart.length());
			String uri = message.substring(0, message.indexOf('\''));

			// They are inconsistent in display URLs. Some include https:// in front, some don't.
			// Some are also wrapped in single quotes. Some are not.
			if ( !uri.startsWith("http") ) {
				uri = "https://" + uri;
				// HACK to remove rest of line when URL is missing trailing ' for findings like:
				// on site vespiary.de:8443/benchmark/xss-00/BenchmarkTest00030. The GET parameter ...
				// on site vespiary.de:8443/benchmark/xss-00/BenchmarkTest00030. The POST parameter ...
				final String HACKSTRING = ". The ";
				if (uri.contains(HACKSTRING)) {
					uri = uri.substring(0,uri.indexOf(HACKSTRING));
				}
			}

			URI url = new URI( uri );
			String testfile = url.getPath();
			testfile = testfile.substring( testfile.lastIndexOf('/') +1 );

			if ( testfile.startsWith( BenchmarkScore.TESTCASENAME ) ) {
				String testno = testfile.substring(BenchmarkScore.TESTCASENAME.length());
				if ( testno.endsWith( ".html" ) ) {
					testno = testno.substring(0, testno.length() -5 );
				}
				try {
					tcr.setNumber( Integer.parseInt( testno ) );
					return tcr;
				} catch( NumberFormatException e ) {
					System.out.println("URI is: " + uri + " for message: " + message);
					System.out.println( "> Parse error " + testfile + ":: " + testno );
				}
			}
		
		}
		return null;
	}
 
	/**
	 * Map Crashtest rule to CWE from testcase:
	 * e.g., <testcase classname="xxe.crashtest.cloud" name="XML External Entity (XXE) (2740)"/>
	 * @param the Crashtest classname
	 * @return CWE number or -1 if we don't care about this test type
	 */
	private int cweLookup(String classname) {

		switch (classname) {
			case "commandinjection.crashtest.cloud" : return 78;
			case "sqlinjection.crashtest.cloud" :     return 89;
			case "xss.crashtest.cloud" :              return 79;
			case "xxe.crashtest.cloud" :              return 611;

			case "portscan.crashtest.cloud" :
			case "ssl.crashtest.cloud" :

				return -1;

			default:
				System.out.println("Unrecognized Crashtest rule: " + classname);
				return -1;
		}
	}

}
