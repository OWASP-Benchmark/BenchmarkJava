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

@WebServlet("/BenchmarkTest03478")
public class BenchmarkTest03478 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a91495 = param; //assign
		StringBuilder b91495 = new StringBuilder(a91495);  // stick in stringbuilder
		b91495.append(" SafeStuff"); // append some safe content
		b91495.replace(b91495.length()-"Chars".length(),b91495.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91495 = new java.util.HashMap<String,Object>();
		map91495.put("key91495", b91495.toString()); // put in a collection
		String c91495 = (String)map91495.get("key91495"); // get it back out
		String d91495 = c91495.substring(0,c91495.length()-1); // extract most of it
		String e91495 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91495.getBytes() ) )); // B64 encode and decode it
		String f91495 = e91495.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f91495); // reflection
		
		
		javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
		javax.xml.xpath.XPath xp = xpf.newXPath();
		try {
			xp.compile(bar);
		} catch (javax.xml.xpath.XPathExpressionException e) {
			// OK to swallow
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		}
	}
}
