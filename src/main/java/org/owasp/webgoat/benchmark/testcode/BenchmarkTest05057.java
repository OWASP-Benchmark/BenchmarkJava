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

@WebServlet("/BenchmarkTest05057")
public class BenchmarkTest05057 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a5320 = param; //assign
		StringBuilder b5320 = new StringBuilder(a5320);  // stick in stringbuilder
		b5320.append(" SafeStuff"); // append some safe content
		b5320.replace(b5320.length()-"Chars".length(),b5320.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5320 = new java.util.HashMap<String,Object>();
		map5320.put("key5320", b5320.toString()); // put in a collection
		String c5320 = (String)map5320.get("key5320"); // get it back out
		String d5320 = c5320.substring(0,c5320.length()-1); // extract most of it
		String e5320 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5320.getBytes() ) )); // B64 encode and decode it
		String f5320 = e5320.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f5320); // reflection
		
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}
}
