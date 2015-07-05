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

@WebServlet("/BenchmarkTest04737")
public class BenchmarkTest04737 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a92830 = param; //assign
		StringBuilder b92830 = new StringBuilder(a92830);  // stick in stringbuilder
		b92830.append(" SafeStuff"); // append some safe content
		b92830.replace(b92830.length()-"Chars".length(),b92830.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92830 = new java.util.HashMap<String,Object>();
		map92830.put("key92830", b92830.toString()); // put in a collection
		String c92830 = (String)map92830.get("key92830"); // get it back out
		String d92830 = c92830.substring(0,c92830.length()-1); // extract most of it
		String e92830 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92830.getBytes() ) )); // B64 encode and decode it
		String f92830 = e92830.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g92830 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g92830); // reflection
		
		
		javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
		javax.xml.xpath.XPath xp = xpf.newXPath();
		try {
			xp.evaluate(bar, "SpecifiedContext");
		} catch (javax.xml.xpath.XPathExpressionException|java.lang.NullPointerException e) {
			// OK to swallow
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		}
	}
}
