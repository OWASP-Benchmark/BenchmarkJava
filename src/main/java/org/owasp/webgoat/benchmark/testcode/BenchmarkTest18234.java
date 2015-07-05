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

@WebServlet("/BenchmarkTest18234")
public class BenchmarkTest18234 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88640 = param; //assign
		StringBuilder b88640 = new StringBuilder(a88640);  // stick in stringbuilder
		b88640.append(" SafeStuff"); // append some safe content
		b88640.replace(b88640.length()-"Chars".length(),b88640.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88640 = new java.util.HashMap<String,Object>();
		map88640.put("key88640", b88640.toString()); // put in a collection
		String c88640 = (String)map88640.get("key88640"); // get it back out
		String d88640 = c88640.substring(0,c88640.length()-1); // extract most of it
		String e88640 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88640.getBytes() ) )); // B64 encode and decode it
		String f88640 = e88640.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g88640 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g88640); // reflection
	
		return bar;	
	}
}
