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

@WebServlet("/BenchmarkTest15834")
public class BenchmarkTest15834 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		try {
			java.util.Random numGen = java.security.SecureRandom.getInstance("SHA1PRNG");
        	double rand = getNextNumber(numGen);
			
	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextDouble() - TestCase");
			throw new ServletException(e);
	    }
		
		response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextDouble() executed");
	}
		double getNextNumber(java.util.Random generator) {
			return generator.nextDouble();
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71861 = param; //assign
		StringBuilder b71861 = new StringBuilder(a71861);  // stick in stringbuilder
		b71861.append(" SafeStuff"); // append some safe content
		b71861.replace(b71861.length()-"Chars".length(),b71861.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71861 = new java.util.HashMap<String,Object>();
		map71861.put("key71861", b71861.toString()); // put in a collection
		String c71861 = (String)map71861.get("key71861"); // get it back out
		String d71861 = c71861.substring(0,c71861.length()-1); // extract most of it
		String e71861 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71861.getBytes() ) )); // B64 encode and decode it
		String f71861 = e71861.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g71861 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g71861); // reflection
	
		return bar;	
	}
}
