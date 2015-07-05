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

@WebServlet("/BenchmarkTest02380")
public class BenchmarkTest02380 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a88133 = param; //assign
		StringBuilder b88133 = new StringBuilder(a88133);  // stick in stringbuilder
		b88133.append(" SafeStuff"); // append some safe content
		b88133.replace(b88133.length()-"Chars".length(),b88133.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88133 = new java.util.HashMap<String,Object>();
		map88133.put("key88133", b88133.toString()); // put in a collection
		String c88133 = (String)map88133.get("key88133"); // get it back out
		String d88133 = c88133.substring(0,c88133.length()-1); // extract most of it
		String e88133 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88133.getBytes() ) )); // B64 encode and decode it
		String f88133 = e88133.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f88133); // reflection
		
		
		try {
		    java.util.Properties Benchmarkprops = new java.util.Properties();
		    Benchmarkprops.load(this.getClass().getClassLoader().getResourceAsStream("Benchmark.properties"));
			String algorithm = Benchmarkprops.getProperty("hashAlg2", "SHA5");
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(algorithm);
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}
}
