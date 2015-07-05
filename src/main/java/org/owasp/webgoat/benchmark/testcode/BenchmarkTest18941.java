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

@WebServlet("/BenchmarkTest18941")
public class BenchmarkTest18941 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
	    try {
		    java.util.Random numGen = java.security.SecureRandom.getInstance("SHA1PRNG");
		
		    // Get 40 random bytes
		    byte[] randomBytes = new byte[40];
		    getNextNumber(numGen, randomBytes);
			response.getWriter().println("Random bytes are: " + new String(randomBytes));
				    
	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextBytes() - TestCase");
			throw new ServletException(e);
	    } finally {
			response.getWriter().println("Randomness Test java.security.SecureRandom.nextBytes(byte[]) executed");	    
	    }
	}
	    	
	void getNextNumber(java.util.Random generator, byte[] barray) {
		generator.nextBytes(barray);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a22302 = param; //assign
		StringBuilder b22302 = new StringBuilder(a22302);  // stick in stringbuilder
		b22302.append(" SafeStuff"); // append some safe content
		b22302.replace(b22302.length()-"Chars".length(),b22302.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map22302 = new java.util.HashMap<String,Object>();
		map22302.put("key22302", b22302.toString()); // put in a collection
		String c22302 = (String)map22302.get("key22302"); // get it back out
		String d22302 = c22302.substring(0,c22302.length()-1); // extract most of it
		String e22302 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d22302.getBytes() ) )); // B64 encode and decode it
		String f22302 = e22302.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f22302); // reflection
	
		return bar;	
	}
}
