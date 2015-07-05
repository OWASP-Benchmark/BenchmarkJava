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

@WebServlet("/BenchmarkTest05088")
public class BenchmarkTest05088 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a56997 = param; //assign
		StringBuilder b56997 = new StringBuilder(a56997);  // stick in stringbuilder
		b56997.append(" SafeStuff"); // append some safe content
		b56997.replace(b56997.length()-"Chars".length(),b56997.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56997 = new java.util.HashMap<String,Object>();
		map56997.put("key56997", b56997.toString()); // put in a collection
		String c56997 = (String)map56997.get("key56997"); // get it back out
		String d56997 = c56997.substring(0,c56997.length()-1); // extract most of it
		String e56997 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56997.getBytes() ) )); // B64 encode and decode it
		String f56997 = e56997.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g56997 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g56997); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}
}
