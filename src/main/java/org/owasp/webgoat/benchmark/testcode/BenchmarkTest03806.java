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

@WebServlet("/BenchmarkTest03806")
public class BenchmarkTest03806 extends HttpServlet {
	
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
		String a9462 = param; //assign
		StringBuilder b9462 = new StringBuilder(a9462);  // stick in stringbuilder
		b9462.append(" SafeStuff"); // append some safe content
		b9462.replace(b9462.length()-"Chars".length(),b9462.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9462 = new java.util.HashMap<String,Object>();
		map9462.put("key9462", b9462.toString()); // put in a collection
		String c9462 = (String)map9462.get("key9462"); // get it back out
		String d9462 = c9462.substring(0,c9462.length()-1); // extract most of it
		String e9462 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9462.getBytes() ) )); // B64 encode and decode it
		String f9462 = e9462.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g9462 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g9462); // reflection
		
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}
}
