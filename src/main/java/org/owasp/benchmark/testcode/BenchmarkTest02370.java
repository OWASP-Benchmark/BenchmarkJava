/**
* OWASP Benchmark Project v1.2
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Nick Sanidas
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/xpathi-00/BenchmarkTest02370")
public class BenchmarkTest02370 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String param = "";
		boolean flag = true;
		java.util.Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements() && flag) {
			String name = (String) names.nextElement();		    	
			String[] values = request.getParameterValues(name);
			if (values != null) {
				for(int i=0;i<values.length && flag; i++){
					String value = values[i];
					if (value.equals("BenchmarkTest02370")) {
						param = name;
					    flag = false;
					}
				}
			}
		}

		String bar = doSomething(request, param);
		
		try {
			java.io.FileInputStream file = new java.io.FileInputStream(org.owasp.benchmark.helpers.Utils.getFileFromClasspath("employees.xml", this.getClass().getClassLoader()));
			javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
			// Prevent XXE
			builderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			javax.xml.parsers.DocumentBuilder builder = builderFactory.newDocumentBuilder();
			org.w3c.dom.Document xmlDocument = builder.parse(file);
			javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
			javax.xml.xpath.XPath xp = xpf.newXPath();

			String expression = "/Employees/Employee[@emplid='"+bar+"']";
			org.w3c.dom.NodeList nodeList = (org.w3c.dom.NodeList) xp.compile(expression).evaluate(xmlDocument, javax.xml.xpath.XPathConstants.NODESET);

			response.getWriter().println(
				"Your query results are: <br/>"
			);
 
			for (int i = 0; i < nodeList.getLength(); i++) {
				org.w3c.dom.Element value = (org.w3c.dom.Element) nodeList.item(i);
				response.getWriter().println(
					value.getTextContent() + "<br/>"
				);
			}
		} catch (javax.xml.xpath.XPathExpressionException | javax.xml.parsers.ParserConfigurationException
				| org.xml.sax.SAXException e) {
			response.getWriter().println(
				"Error parsing XPath input: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(bar) + "'"
			);
			throw new ServletException(e);
		}
	}  // end doPost
	
		
	private static String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		String bar = "alsosafe";
		if (param != null) {
			java.util.List<String> valuesList = new java.util.ArrayList<String>( );
			valuesList.add("safe");
			valuesList.add( param );
			valuesList.add( "moresafe" );
			
			valuesList.remove(0); // remove the 1st safe value
			
			bar = valuesList.get(1); // get the last 'safe' value
		}
	
		return bar;	
	}
}
