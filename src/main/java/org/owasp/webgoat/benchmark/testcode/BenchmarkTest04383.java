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

@WebServlet("/BenchmarkTest04383")
public class BenchmarkTest04383 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a84541 = param; //assign
		StringBuilder b84541 = new StringBuilder(a84541);  // stick in stringbuilder
		b84541.append(" SafeStuff"); // append some safe content
		b84541.replace(b84541.length()-"Chars".length(),b84541.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84541 = new java.util.HashMap<String,Object>();
		map84541.put("key84541", b84541.toString()); // put in a collection
		String c84541 = (String)map84541.get("key84541"); // get it back out
		String d84541 = c84541.substring(0,c84541.length()-1); // extract most of it
		String e84541 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84541.getBytes() ) )); // B64 encode and decode it
		String f84541 = e84541.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f84541); // reflection
		
		
		response.getWriter().println(bar);
	}
}
