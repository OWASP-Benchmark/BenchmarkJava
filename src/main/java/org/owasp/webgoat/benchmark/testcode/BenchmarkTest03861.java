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

@WebServlet("/BenchmarkTest03861")
public class BenchmarkTest03861 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a55862 = param; //assign
		StringBuilder b55862 = new StringBuilder(a55862);  // stick in stringbuilder
		b55862.append(" SafeStuff"); // append some safe content
		b55862.replace(b55862.length()-"Chars".length(),b55862.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55862 = new java.util.HashMap<String,Object>();
		map55862.put("key55862", b55862.toString()); // put in a collection
		String c55862 = (String)map55862.get("key55862"); // get it back out
		String d55862 = c55862.substring(0,c55862.length()-1); // extract most of it
		String e55862 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55862.getBytes() ) )); // B64 encode and decode it
		String f55862 = e55862.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f55862); // reflection
		
		
		response.getWriter().write(bar);
	}
}
