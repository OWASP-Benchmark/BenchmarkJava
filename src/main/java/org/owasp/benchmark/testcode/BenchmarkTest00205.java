/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
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

@WebServlet("/BenchmarkTest00205")
public class BenchmarkTest00205 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = request.getHeader("vector");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a23461 = param; //assign
		StringBuilder b23461 = new StringBuilder(a23461);  // stick in stringbuilder
		b23461.append(" SafeStuff"); // append some safe content
		b23461.replace(b23461.length()-"Chars".length(),b23461.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23461 = new java.util.HashMap<String,Object>();
		map23461.put("key23461", b23461.toString()); // put in a collection
		String c23461 = (String)map23461.get("key23461"); // get it back out
		String d23461 = c23461.substring(0,c23461.length()-1); // extract most of it
		String e23461 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23461.getBytes() ) )); // B64 encode and decode it
		String f23461 = e23461.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f23461); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "10340");
				
		response.getWriter().println("Item: '" + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
			+ "' with value: '10340' saved in session.");
	}
}
