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

@WebServlet("/BenchmarkTest06141")
public class BenchmarkTest06141 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a95212 = param; //assign
		StringBuilder b95212 = new StringBuilder(a95212);  // stick in stringbuilder
		b95212.append(" SafeStuff"); // append some safe content
		b95212.replace(b95212.length()-"Chars".length(),b95212.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95212 = new java.util.HashMap<String,Object>();
		map95212.put("key95212", b95212.toString()); // put in a collection
		String c95212 = (String)map95212.get("key95212"); // get it back out
		String d95212 = c95212.substring(0,c95212.length()-1); // extract most of it
		String e95212 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95212.getBytes() ) )); // B64 encode and decode it
		String f95212 = e95212.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g95212 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g95212); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}
}
