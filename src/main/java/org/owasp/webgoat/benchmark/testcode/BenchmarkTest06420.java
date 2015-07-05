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

@WebServlet("/BenchmarkTest06420")
public class BenchmarkTest06420 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a44032 = param; //assign
		StringBuilder b44032 = new StringBuilder(a44032);  // stick in stringbuilder
		b44032.append(" SafeStuff"); // append some safe content
		b44032.replace(b44032.length()-"Chars".length(),b44032.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44032 = new java.util.HashMap<String,Object>();
		map44032.put("key44032", b44032.toString()); // put in a collection
		String c44032 = (String)map44032.get("key44032"); // get it back out
		String d44032 = c44032.substring(0,c44032.length()-1); // extract most of it
		String e44032 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44032.getBytes() ) )); // B64 encode and decode it
		String f44032 = e44032.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f44032); // reflection
		
		
		try {
			int r = java.security.SecureRandom.getInstance("SHA1PRNG").nextInt();
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextInt() - TestCase");
			throw new ServletException(e);
	    }
		response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextInt() executed");
	}
}
