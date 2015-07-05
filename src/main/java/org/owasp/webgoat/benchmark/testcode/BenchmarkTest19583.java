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

@WebServlet("/BenchmarkTest19583")
public class BenchmarkTest19583 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
        try {
	    	java.util.Random numGen = java.security.SecureRandom.getInstance("SHA1PRNG");
        	boolean randNumber = numGen.nextBoolean();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Problem executing SecureRandom.nextBoolean() - TestCase");
            throw new ServletException(e);
        }

        response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextBoolean() executed");

	
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a14480 = param; //assign
		StringBuilder b14480 = new StringBuilder(a14480);  // stick in stringbuilder
		b14480.append(" SafeStuff"); // append some safe content
		b14480.replace(b14480.length()-"Chars".length(),b14480.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14480 = new java.util.HashMap<String,Object>();
		map14480.put("key14480", b14480.toString()); // put in a collection
		String c14480 = (String)map14480.get("key14480"); // get it back out
		String d14480 = c14480.substring(0,c14480.length()-1); // extract most of it
		String e14480 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14480.getBytes() ) )); // B64 encode and decode it
		String f14480 = e14480.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f14480); // reflection
	
		return bar;	
	}
}
