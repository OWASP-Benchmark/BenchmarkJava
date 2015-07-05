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

@WebServlet("/BenchmarkTest16495")
public class BenchmarkTest16495 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		try {
			int r = java.security.SecureRandom.getInstance("SHA1PRNG").nextInt();
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextInt() - TestCase");
			throw new ServletException(e);
	    }
		response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a24166 = param; //assign
		StringBuilder b24166 = new StringBuilder(a24166);  // stick in stringbuilder
		b24166.append(" SafeStuff"); // append some safe content
		b24166.replace(b24166.length()-"Chars".length(),b24166.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24166 = new java.util.HashMap<String,Object>();
		map24166.put("key24166", b24166.toString()); // put in a collection
		String c24166 = (String)map24166.get("key24166"); // get it back out
		String d24166 = c24166.substring(0,c24166.length()-1); // extract most of it
		String e24166 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24166.getBytes() ) )); // B64 encode and decode it
		String f24166 = e24166.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f24166); // reflection
	
		return bar;	
	}
}
