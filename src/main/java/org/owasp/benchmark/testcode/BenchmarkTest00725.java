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

@WebServlet("/BenchmarkTest00725")
public class BenchmarkTest00725 extends HttpServlet {
	
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
		String a15619 = param; //assign
		StringBuilder b15619 = new StringBuilder(a15619);  // stick in stringbuilder
		b15619.append(" SafeStuff"); // append some safe content
		b15619.replace(b15619.length()-"Chars".length(),b15619.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map15619 = new java.util.HashMap<String,Object>();
		map15619.put("key15619", b15619.toString()); // put in a collection
		String c15619 = (String)map15619.get("key15619"); // get it back out
		String d15619 = c15619.substring(0,c15619.length()-1); // extract most of it
		String e15619 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d15619.getBytes() ) )); // B64 encode and decode it
		String f15619 = e15619.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f15619); // reflection
		
		
		response.getWriter().println(bar);
	}
}
