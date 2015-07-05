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

@WebServlet("/BenchmarkTest06583")
public class BenchmarkTest06583 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a80582 = param; //assign
		StringBuilder b80582 = new StringBuilder(a80582);  // stick in stringbuilder
		b80582.append(" SafeStuff"); // append some safe content
		b80582.replace(b80582.length()-"Chars".length(),b80582.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map80582 = new java.util.HashMap<String,Object>();
		map80582.put("key80582", b80582.toString()); // put in a collection
		String c80582 = (String)map80582.get("key80582"); // get it back out
		String d80582 = c80582.substring(0,c80582.length()-1); // extract most of it
		String e80582 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d80582.getBytes() ) )); // B64 encode and decode it
		String f80582 = e80582.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g80582 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g80582); // reflection
		
		
		try {
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case");
			throw new ServletException(e);
		} catch (javax.crypto.NoSuchPaddingException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String) Test Case");
			throw new ServletException(e);
		}
		response.getWriter().println("Crypto Test javax.crypto.Cipher.getInstance(java.lang.String) executed");
	}
}
