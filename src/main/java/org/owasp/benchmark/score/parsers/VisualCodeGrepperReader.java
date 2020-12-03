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
 * @author Nacho Guisado Obregon
 * @created 2020
 */

package org.owasp.benchmark.score.parsers;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owasp.benchmark.score.BenchmarkScore;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class VisualCodeGrepperReader extends Reader {

  public TestResults parse(File f) throws Exception {
    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
    // Prevent XXE
    docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
    InputSource is = new InputSource(new FileInputStream(f));
    Document doc = docBuilder.parse(is);

    TestResults tr = new TestResults("VisualCodeGrepper", false, TestResults.ToolType.SAST);

    // If the filename includes an elapsed time in seconds (e.g.,
    // TOOLNAME-seconds.xml), set the compute time on the scorecard.
    tr.setTime(f);
    NodeList nl = doc.getDocumentElement().getChildNodes();
    for (int i = 0; i < nl.getLength(); i++) {
      Node n = nl.item(i);
      if (n.getNodeName().equals("CodeIssue")) {
        TestCaseResult tcr = parseVisualCodeGrepperIssue(n);
        if (tcr != null) {
          tr.put(tcr);
        }
      }
    }

    return tr;
  }

  /**
   * Read the data from each code issue reported
   * 
   * @param n : the code issue reported
   * @return the test case result
   */
  private TestCaseResult parseVisualCodeGrepperIssue(Node n) {
    /*
     * // Here an example of how the CodeIssues looks <CodeIssue>
     *  <CodeIssue>
     *    <Priority>1</Priority>
     *    <Severity>Critical</Severity>
     *    <Title>Potential SQL Injection</Title>
     *    <Description>The application appears to allow SQL injection via a pre-prepared dynamic SQL statement. No validator plug-ins were located in the application's XML files.</Description>
     *    <FileName>C:\workspace\benchmark\src\main\java\org\owasp\benchmark\testcode\BenchmarkTest01304.java</FileName>
     *    <Line>52</Line>
     *    <CodeLine>			java.sql.PreparedStatement statement = connection.prepareStatement( sql,</CodeLine>
     *    <Checked>False</Checked>
     *    <CheckColour>LawnGreen</CheckColour>
     *  </CodeIssue>
     */

    TestCaseResult tcr = new TestCaseResult();
    String classname = getNamedChild("FileName", n).getTextContent();
    classname = (classname.substring(classname.lastIndexOf('\\') + 1)).split("\\.")[0];
    if (classname.startsWith(BenchmarkScore.TESTCASENAME)) {
      try {
        String testNumber = classname.substring(BenchmarkScore.TESTCASENAME.length());
        tcr.setNumber(Integer.parseInt(testNumber));
      } catch (Exception e) {
        // System.out.println("Error parsing node: " + n.toString() + " for classname: "
        // + classname);
        return null; // If we can't parse the test #, its not in a real test case file. e.g.,
                     // BenchmarkTesting.java
      }
    }

    Node catnode = getNamedNode("Title", n.getChildNodes());
    tcr.setCWE(figureCWE(tcr, catnode));
    tcr.setCategory(getNamedNode("Title", n.getChildNodes()).getTextContent());
    tcr.setConfidence(Integer.parseInt(getNamedNode("Priority", n.getChildNodes()).getTextContent()));
    tcr.setEvidence(getNamedNode("CodeLine", n.getChildNodes()).getTextContent());
    return tcr;
  }

  private static int figureCWE( TestCaseResult tcr, Node catnode) {
		String cat = null;
		if ( catnode != null ) {
			cat = catnode.getTextContent();
    }
    if (cat.startsWith("Cipher.getInstance(")) {
      // Weak encryption
      return 327;
    } else if (cat.startsWith("Class Contains Public Variable: ")){
      // Potential SQL Injection
      //return 89;
    }

		switch ( cat ) {
			//Cookies
      case "Poor Input Validation" : 		return 614;

			//Injections
      case "Potential SQL Injection" :          return 89;
      //case "Operation on Primitive Data Type" : return 89;

			//Command injection
			case "java.lang.Runtime.exec Gets Path from Variable" : return 78;

      // XPath Injection
      case "FileInputStream" : 		                          return 643;
      case "java.io.FileWriter" : 		                      return 643;
      case "java.io.FileReader" : 		                      return 643;
      case "FileStream Opened Without Exception Handling" : return 643;

			//Weak random
      case "java.util.Random" : 		return 330;
    
			//Path traversal
      case "java.io.File" : 		                            return 22;
      case "java.io.FileOutputStream" : 		                return 22;
      case "getResourceAsStream" : 		                      return 22;

			//XSS
      case "Potential XSS" :		    return 79;

      // Trust Boundary Violation
      case "getParameterValues" : 	return 501;
      case "getParameterNames" : 		return 501;
      case "getParameter" : 		    return 501;  

      default : return 00; //System.out.println( "Unknown vuln category for VisualCodeGrepper: " + cat );
		}		
	}
}
