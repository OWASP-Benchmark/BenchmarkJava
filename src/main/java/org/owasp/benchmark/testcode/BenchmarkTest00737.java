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

@WebServlet("/BenchmarkTest00737")
public class BenchmarkTest00737 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String[] values = request.getParameterValues("vector");
		String param;
		if (values != null && values.length > 0)
		  param = values[0];
		else param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a17364 = param; //assign
		StringBuilder b17364 = new StringBuilder(a17364);  // stick in stringbuilder
		b17364.append(" SafeStuff"); // append some safe content
		b17364.replace(b17364.length()-"Chars".length(),b17364.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map17364 = new java.util.HashMap<String,Object>();
		map17364.put("key17364", b17364.toString()); // put in a collection
		String c17364 = (String)map17364.get("key17364"); // get it back out
		String d17364 = c17364.substring(0,c17364.length()-1); // extract most of it
		String e17364 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d17364.getBytes() ) )); // B64 encode and decode it
		String f17364 = e17364.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f17364); // reflection
		
		
		response.getWriter().write("Parameter value: " + bar);
	}
}
