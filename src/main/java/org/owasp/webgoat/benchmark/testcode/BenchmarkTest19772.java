/**
* OWASP Benchmark Project v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
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

@WebServlet("/BenchmarkTest19772")
public class BenchmarkTest19772 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
		javax.xml.xpath.XPath xp = xpf.newXPath();
		try {
			xp.evaluate(bar, "SpecifiedContext");
		} catch (javax.xml.xpath.XPathExpressionException|java.lang.NullPointerException e) {
			// OK to swallow
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88609 = param; //assign
		StringBuilder b88609 = new StringBuilder(a88609);  // stick in stringbuilder
		b88609.append(" SafeStuff"); // append some safe content
		b88609.replace(b88609.length()-"Chars".length(),b88609.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88609 = new java.util.HashMap<String,Object>();
		map88609.put("key88609", b88609.toString()); // put in a collection
		String c88609 = (String)map88609.get("key88609"); // get it back out
		String d88609 = c88609.substring(0,c88609.length()-1); // extract most of it
		String e88609 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88609.getBytes() ) )); // B64 encode and decode it
		String f88609 = e88609.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g88609 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g88609); // reflection
	
		return bar;	
	}
}
