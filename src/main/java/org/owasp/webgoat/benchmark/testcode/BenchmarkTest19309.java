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

@WebServlet("/BenchmarkTest19309")
public class BenchmarkTest19309 extends HttpServlet {
	
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
		    java.util.Properties Benchmarkprops = new java.util.Properties();
		    Benchmarkprops.load(this.getClass().getClassLoader().getResourceAsStream("Benchmark.properties"));
			String algorithm = Benchmarkprops.getProperty("hashAlg2", "SHA5");
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(algorithm);
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a79519 = param; //assign
		StringBuilder b79519 = new StringBuilder(a79519);  // stick in stringbuilder
		b79519.append(" SafeStuff"); // append some safe content
		b79519.replace(b79519.length()-"Chars".length(),b79519.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79519 = new java.util.HashMap<String,Object>();
		map79519.put("key79519", b79519.toString()); // put in a collection
		String c79519 = (String)map79519.get("key79519"); // get it back out
		String d79519 = c79519.substring(0,c79519.length()-1); // extract most of it
		String e79519 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79519.getBytes() ) )); // B64 encode and decode it
		String f79519 = e79519.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f79519); // reflection
	
		return bar;	
	}
}
