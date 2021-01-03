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
* @author Dave Wichers
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/xpathi-00/BenchmarkTest01633")
public class BenchmarkTest01633 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String[] values = request.getParameterValues("BenchmarkTest01633");
		String param;
		if (values != null && values.length > 0)
		  param = values[0];
		else param = "";

		String bar = new Test().doSomething(request, param);
		
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
			String result = xp.evaluate(expression, xmlDocument);

			response.getWriter().println(
				"Your query results are: " + result + "<br/>"
			);

		} catch (javax.xml.xpath.XPathExpressionException | javax.xml.parsers.ParserConfigurationException
				| org.xml.sax.SAXException e) {
			response.getWriter().println(
				"Error parsing XPath input: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(bar) + "'"
			);
			throw new ServletException(e);
		}
	}  // end doPost

	
    private class Test {

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a31144 = param; //assign
		StringBuilder b31144 = new StringBuilder(a31144);  // stick in stringbuilder
		b31144.append(" SafeStuff"); // append some safe content
		b31144.replace(b31144.length()-"Chars".length(),b31144.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31144 = new java.util.HashMap<String,Object>();
		map31144.put("key31144", b31144.toString()); // put in a collection
		String c31144 = (String)map31144.get("key31144"); // get it back out
		String d31144 = c31144.substring(0,c31144.length()-1); // extract most of it
		String e31144 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d31144.getBytes() ) )); // B64 encode and decode it
		String f31144 = e31144.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g31144 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g31144); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
