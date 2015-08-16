/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02144")
public class BenchmarkTest02144 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("vector");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		try {
			java.io.FileInputStream file = new java.io.FileInputStream(org.owasp.benchmark.helpers.Utils.getFileFromClasspath("employees.xml", this.getClass().getClassLoader()));
			javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
			javax.xml.parsers.DocumentBuilder builder = builderFactory.newDocumentBuilder();
			org.w3c.dom.Document xmlDocument = builder.parse(file);
			javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
			javax.xml.xpath.XPath xp = xpf.newXPath();
			
			response.getWriter().println("Your query results are: <br/>"); 
			String expression = "/Employees/Employee[@emplid='"+bar+"']";
			response.getWriter().println(xp.evaluate(expression, xmlDocument) + "<br/>");
			
		} catch (javax.xml.xpath.XPathExpressionException e) {
			// OK to swallow
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		} catch (javax.xml.parsers.ParserConfigurationException e) {
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		} catch (org.xml.sax.SAXException e) {
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a96985 = param; //assign
		StringBuilder b96985 = new StringBuilder(a96985);  // stick in stringbuilder
		b96985.append(" SafeStuff"); // append some safe content
		b96985.replace(b96985.length()-"Chars".length(),b96985.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map96985 = new java.util.HashMap<String,Object>();
		map96985.put("key96985", b96985.toString()); // put in a collection
		String c96985 = (String)map96985.get("key96985"); // get it back out
		String d96985 = c96985.substring(0,c96985.length()-1); // extract most of it
		String e96985 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d96985.getBytes() ) )); // B64 encode and decode it
		String f96985 = e96985.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g96985 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g96985); // reflection
	
		return bar;	
	}
}
