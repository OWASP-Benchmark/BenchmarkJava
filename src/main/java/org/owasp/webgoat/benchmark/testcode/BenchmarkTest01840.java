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

@WebServlet("/BenchmarkTest01840")
public class BenchmarkTest01840 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a33087 = param; //assign
		StringBuilder b33087 = new StringBuilder(a33087);  // stick in stringbuilder
		b33087.append(" SafeStuff"); // append some safe content
		b33087.replace(b33087.length()-"Chars".length(),b33087.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map33087 = new java.util.HashMap<String,Object>();
		map33087.put("key33087", b33087.toString()); // put in a collection
		String c33087 = (String)map33087.get("key33087"); // get it back out
		String d33087 = c33087.substring(0,c33087.length()-1); // extract most of it
		String e33087 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d33087.getBytes() ) )); // B64 encode and decode it
		String f33087 = e33087.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f33087); // reflection
		
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}
}
