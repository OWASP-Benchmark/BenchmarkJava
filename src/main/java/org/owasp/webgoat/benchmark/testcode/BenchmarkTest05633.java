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

@WebServlet("/BenchmarkTest05633")
public class BenchmarkTest05633 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a5310 = param; //assign
		StringBuilder b5310 = new StringBuilder(a5310);  // stick in stringbuilder
		b5310.append(" SafeStuff"); // append some safe content
		b5310.replace(b5310.length()-"Chars".length(),b5310.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5310 = new java.util.HashMap<String,Object>();
		map5310.put("key5310", b5310.toString()); // put in a collection
		String c5310 = (String)map5310.get("key5310"); // get it back out
		String d5310 = c5310.substring(0,c5310.length()-1); // extract most of it
		String e5310 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5310.getBytes() ) )); // B64 encode and decode it
		String f5310 = e5310.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g5310 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g5310); // reflection
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
