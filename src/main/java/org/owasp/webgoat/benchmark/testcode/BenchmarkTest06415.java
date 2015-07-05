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

@WebServlet("/BenchmarkTest06415")
public class BenchmarkTest06415 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a86109 = param; //assign
		StringBuilder b86109 = new StringBuilder(a86109);  // stick in stringbuilder
		b86109.append(" SafeStuff"); // append some safe content
		b86109.replace(b86109.length()-"Chars".length(),b86109.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86109 = new java.util.HashMap<String,Object>();
		map86109.put("key86109", b86109.toString()); // put in a collection
		String c86109 = (String)map86109.get("key86109"); // get it back out
		String d86109 = c86109.substring(0,c86109.length()-1); // extract most of it
		String e86109 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86109.getBytes() ) )); // B64 encode and decode it
		String f86109 = e86109.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g86109 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g86109); // reflection
		
		
		try {
			int randNumber = java.security.SecureRandom.getInstance("SHA1PRNG").nextInt(99);
	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextInt(int) - TestCase");
			throw new ServletException(e);
	    }		
		response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextInt(int) executed");
	}
}
