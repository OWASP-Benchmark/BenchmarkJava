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

@WebServlet("/BenchmarkTest06159")
public class BenchmarkTest06159 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a23330 = param; //assign
		StringBuilder b23330 = new StringBuilder(a23330);  // stick in stringbuilder
		b23330.append(" SafeStuff"); // append some safe content
		b23330.replace(b23330.length()-"Chars".length(),b23330.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23330 = new java.util.HashMap<String,Object>();
		map23330.put("key23330", b23330.toString()); // put in a collection
		String c23330 = (String)map23330.get("key23330"); // get it back out
		String d23330 = c23330.substring(0,c23330.length()-1); // extract most of it
		String e23330 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23330.getBytes() ) )); // B64 encode and decode it
		String f23330 = e23330.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f23330); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
