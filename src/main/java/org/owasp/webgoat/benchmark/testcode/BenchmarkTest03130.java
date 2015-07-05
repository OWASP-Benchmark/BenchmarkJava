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

@WebServlet("/BenchmarkTest03130")
public class BenchmarkTest03130 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a52730 = param; //assign
		StringBuilder b52730 = new StringBuilder(a52730);  // stick in stringbuilder
		b52730.append(" SafeStuff"); // append some safe content
		b52730.replace(b52730.length()-"Chars".length(),b52730.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52730 = new java.util.HashMap<String,Object>();
		map52730.put("key52730", b52730.toString()); // put in a collection
		String c52730 = (String)map52730.get("key52730"); // get it back out
		String d52730 = c52730.substring(0,c52730.length()-1); // extract most of it
		String e52730 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52730.getBytes() ) )); // B64 encode and decode it
		String f52730 = e52730.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f52730); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}
}
