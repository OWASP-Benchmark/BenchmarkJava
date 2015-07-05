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

@WebServlet("/BenchmarkTest16974")
public class BenchmarkTest16974 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a73507 = param; //assign
		StringBuilder b73507 = new StringBuilder(a73507);  // stick in stringbuilder
		b73507.append(" SafeStuff"); // append some safe content
		b73507.replace(b73507.length()-"Chars".length(),b73507.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73507 = new java.util.HashMap<String,Object>();
		map73507.put("key73507", b73507.toString()); // put in a collection
		String c73507 = (String)map73507.get("key73507"); // get it back out
		String d73507 = c73507.substring(0,c73507.length()-1); // extract most of it
		String e73507 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73507.getBytes() ) )); // B64 encode and decode it
		String f73507 = e73507.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f73507); // reflection
	
		return bar;	
	}
}
