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

@WebServlet("/BenchmarkTest20263")
public class BenchmarkTest20263 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
		String a26634 = param; //assign
		StringBuilder b26634 = new StringBuilder(a26634);  // stick in stringbuilder
		b26634.append(" SafeStuff"); // append some safe content
		b26634.replace(b26634.length()-"Chars".length(),b26634.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26634 = new java.util.HashMap<String,Object>();
		map26634.put("key26634", b26634.toString()); // put in a collection
		String c26634 = (String)map26634.get("key26634"); // get it back out
		String d26634 = c26634.substring(0,c26634.length()-1); // extract most of it
		String e26634 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26634.getBytes() ) )); // B64 encode and decode it
		String f26634 = e26634.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g26634 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g26634); // reflection
	
		return bar;	
	}
}
