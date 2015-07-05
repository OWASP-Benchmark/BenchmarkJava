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

@WebServlet("/BenchmarkTest15737")
public class BenchmarkTest15737 extends HttpServlet {
	
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
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a26668 = param; //assign
		StringBuilder b26668 = new StringBuilder(a26668);  // stick in stringbuilder
		b26668.append(" SafeStuff"); // append some safe content
		b26668.replace(b26668.length()-"Chars".length(),b26668.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26668 = new java.util.HashMap<String,Object>();
		map26668.put("key26668", b26668.toString()); // put in a collection
		String c26668 = (String)map26668.get("key26668"); // get it back out
		String d26668 = c26668.substring(0,c26668.length()-1); // extract most of it
		String e26668 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26668.getBytes() ) )); // B64 encode and decode it
		String f26668 = e26668.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g26668 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g26668); // reflection
	
		return bar;	
	}
}
