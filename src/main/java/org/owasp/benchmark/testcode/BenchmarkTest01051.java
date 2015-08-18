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
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01051")
public class BenchmarkTest01051 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		javax.servlet.http.Cookie[] theCookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (theCookies != null) {
			for (javax.servlet.http.Cookie theCookie : theCookies) {
				if (theCookie.getName().equals("vector")) {
					param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = new Test().doSomething(param);
		
		try {
			java.io.FileInputStream file = new java.io.FileInputStream(org.owasp.benchmark.helpers.Utils.getFileFromClasspath("employees.xml", this.getClass().getClassLoader()));
			javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
			javax.xml.parsers.DocumentBuilder builder = builderFactory.newDocumentBuilder();
			org.w3c.dom.Document xmlDocument = builder.parse(file);
			javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
			javax.xml.xpath.XPath xp = xpf.newXPath();
			
			String expression = "/Employees/Employee[@emplid='"+bar+"']";
			
			response.getWriter().println("Your query results are: <br/>"); 
			org.w3c.dom.NodeList nodeList = (org.w3c.dom.NodeList) xp.compile(expression).evaluate(xmlDocument, javax.xml.xpath.XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				org.w3c.dom.Element value = (org.w3c.dom.Element) nodeList.item(i);
				response.getWriter().println(value.getTextContent() + "<br/>");
			}
		} catch (javax.xml.xpath.XPathExpressionException e) {
			// OK to swallow
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		} catch (javax.xml.parsers.ParserConfigurationException e) {
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		} catch (org.xml.sax.SAXException e) {
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a24399 = param; //assign
		StringBuilder b24399 = new StringBuilder(a24399);  // stick in stringbuilder
		b24399.append(" SafeStuff"); // append some safe content
		b24399.replace(b24399.length()-"Chars".length(),b24399.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24399 = new java.util.HashMap<String,Object>();
		map24399.put("key24399", b24399.toString()); // put in a collection
		String c24399 = (String)map24399.get("key24399"); // get it back out
		String d24399 = c24399.substring(0,c24399.length()-1); // extract most of it
		String e24399 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24399.getBytes() ) )); // B64 encode and decode it
		String f24399 = e24399.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g24399 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g24399); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
