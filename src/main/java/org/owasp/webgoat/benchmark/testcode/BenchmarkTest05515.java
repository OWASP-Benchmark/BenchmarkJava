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

@WebServlet("/BenchmarkTest05515")
public class BenchmarkTest05515 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a78307 = param; //assign
		StringBuilder b78307 = new StringBuilder(a78307);  // stick in stringbuilder
		b78307.append(" SafeStuff"); // append some safe content
		b78307.replace(b78307.length()-"Chars".length(),b78307.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78307 = new java.util.HashMap<String,Object>();
		map78307.put("key78307", b78307.toString()); // put in a collection
		String c78307 = (String)map78307.get("key78307"); // get it back out
		String d78307 = c78307.substring(0,c78307.length()-1); // extract most of it
		String e78307 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d78307.getBytes() ) )); // B64 encode and decode it
		String f78307 = e78307.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g78307 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g78307); // reflection
		
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-512", "SUN");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
            throw new ServletException(e);
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
            throw new ServletException(e);
		}

		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String,java.lang.String) executed");
	}
}
