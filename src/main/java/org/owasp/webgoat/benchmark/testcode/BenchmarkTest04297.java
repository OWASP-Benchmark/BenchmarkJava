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

@WebServlet("/BenchmarkTest04297")
public class BenchmarkTest04297 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a59865 = param; //assign
		StringBuilder b59865 = new StringBuilder(a59865);  // stick in stringbuilder
		b59865.append(" SafeStuff"); // append some safe content
		b59865.replace(b59865.length()-"Chars".length(),b59865.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59865 = new java.util.HashMap<String,Object>();
		map59865.put("key59865", b59865.toString()); // put in a collection
		String c59865 = (String)map59865.get("key59865"); // get it back out
		String d59865 = c59865.substring(0,c59865.length()-1); // extract most of it
		String e59865 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59865.getBytes() ) )); // B64 encode and decode it
		String f59865 = e59865.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g59865 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g59865); // reflection
		
		
		java.security.Provider[] provider = java.security.Security.getProviders();
		java.security.MessageDigest md;

		try {
			if (provider.length > 1) {

				md = java.security.MessageDigest.getInstance("sha-384", provider[0]);
			} else {
				md = java.security.MessageDigest.getInstance("sha-384","SUN");
			}
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.security.Provider)");
            throw new ServletException(e);
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.security.Provider)");
            throw new ServletException(e);
		}

		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String,java.security.Provider) executed");
	}
}
