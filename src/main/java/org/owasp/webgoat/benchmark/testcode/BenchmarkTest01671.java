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

@WebServlet("/BenchmarkTest01671")
public class BenchmarkTest01671 extends HttpServlet {
	
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
		String a17887 = param; //assign
		StringBuilder b17887 = new StringBuilder(a17887);  // stick in stringbuilder
		b17887.append(" SafeStuff"); // append some safe content
		b17887.replace(b17887.length()-"Chars".length(),b17887.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map17887 = new java.util.HashMap<String,Object>();
		map17887.put("key17887", b17887.toString()); // put in a collection
		String c17887 = (String)map17887.get("key17887"); // get it back out
		String d17887 = c17887.substring(0,c17887.length()-1); // extract most of it
		String e17887 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d17887.getBytes() ) )); // B64 encode and decode it
		String f17887 = e17887.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f17887); // reflection
		
		
		java.io.File file = new java.io.File(bar);
	}
}
