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

@WebServlet("/BenchmarkTest00383")
public class BenchmarkTest00383 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = request.getParameter("vector");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a47181 = param; //assign
		StringBuilder b47181 = new StringBuilder(a47181);  // stick in stringbuilder
		b47181.append(" SafeStuff"); // append some safe content
		b47181.replace(b47181.length()-"Chars".length(),b47181.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47181 = new java.util.HashMap<String,Object>();
		map47181.put("key47181", b47181.toString()); // put in a collection
		String c47181 = (String)map47181.get("key47181"); // get it back out
		String d47181 = c47181.substring(0,c47181.length()-1); // extract most of it
		String e47181 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47181.getBytes() ) )); // B64 encode and decode it
		String f47181 = e47181.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f47181); // reflection
		
		
		Object[] obj = { "a", "b"};
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}
}
