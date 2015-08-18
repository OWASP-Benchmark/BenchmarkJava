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

@WebServlet("/BenchmarkTest02102")
public class BenchmarkTest02102 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a6339 = param; //assign
		StringBuilder b6339 = new StringBuilder(a6339);  // stick in stringbuilder
		b6339.append(" SafeStuff"); // append some safe content
		b6339.replace(b6339.length()-"Chars".length(),b6339.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6339 = new java.util.HashMap<String,Object>();
		map6339.put("key6339", b6339.toString()); // put in a collection
		String c6339 = (String)map6339.get("key6339"); // get it back out
		String d6339 = c6339.substring(0,c6339.length()-1); // extract most of it
		String e6339 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6339.getBytes() ) )); // B64 encode and decode it
		String f6339 = e6339.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g6339 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g6339); // reflection
	
		return bar;	
	}
}
