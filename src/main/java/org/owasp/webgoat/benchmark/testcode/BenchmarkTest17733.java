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

@WebServlet("/BenchmarkTest17733")
public class BenchmarkTest17733 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = doSomething(param);
		
		try {
			float rand = java.security.SecureRandom.getInstance("SHA1PRNG").nextFloat();
	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextFloat() - TestCase");
			throw new ServletException(e);
	    }		
		response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextFloat() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a33811 = param; //assign
		StringBuilder b33811 = new StringBuilder(a33811);  // stick in stringbuilder
		b33811.append(" SafeStuff"); // append some safe content
		b33811.replace(b33811.length()-"Chars".length(),b33811.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map33811 = new java.util.HashMap<String,Object>();
		map33811.put("key33811", b33811.toString()); // put in a collection
		String c33811 = (String)map33811.get("key33811"); // get it back out
		String d33811 = c33811.substring(0,c33811.length()-1); // extract most of it
		String e33811 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d33811.getBytes() ) )); // B64 encode and decode it
		String f33811 = e33811.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f33811); // reflection
	
		return bar;	
	}
}
