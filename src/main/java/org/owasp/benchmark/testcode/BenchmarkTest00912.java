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

@WebServlet("/BenchmarkTest00912")
public class BenchmarkTest00912 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("vector");
		
		
		// Chain a bunch of propagators in sequence
		String a36886 = param; //assign
		StringBuilder b36886 = new StringBuilder(a36886);  // stick in stringbuilder
		b36886.append(" SafeStuff"); // append some safe content
		b36886.replace(b36886.length()-"Chars".length(),b36886.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map36886 = new java.util.HashMap<String,Object>();
		map36886.put("key36886", b36886.toString()); // put in a collection
		String c36886 = (String)map36886.get("key36886"); // get it back out
		String d36886 = c36886.substring(0,c36886.length()-1); // extract most of it
		String e36886 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d36886.getBytes() ) )); // B64 encode and decode it
		String f36886 = e36886.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g36886 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g36886); // reflection
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length);
		}
	}
}
