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

@WebServlet("/BenchmarkTest20067")
public class BenchmarkTest20067 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a96092 = param; //assign
		StringBuilder b96092 = new StringBuilder(a96092);  // stick in stringbuilder
		b96092.append(" SafeStuff"); // append some safe content
		b96092.replace(b96092.length()-"Chars".length(),b96092.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map96092 = new java.util.HashMap<String,Object>();
		map96092.put("key96092", b96092.toString()); // put in a collection
		String c96092 = (String)map96092.get("key96092"); // get it back out
		String d96092 = c96092.substring(0,c96092.length()-1); // extract most of it
		String e96092 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d96092.getBytes() ) )); // B64 encode and decode it
		String f96092 = e96092.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g96092 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g96092); // reflection
	
		return bar;	
	}
}
