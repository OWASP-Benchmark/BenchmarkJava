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

@WebServlet("/BenchmarkTest06904")
public class BenchmarkTest06904 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a8065 = param; //assign
		StringBuilder b8065 = new StringBuilder(a8065);  // stick in stringbuilder
		b8065.append(" SafeStuff"); // append some safe content
		b8065.replace(b8065.length()-"Chars".length(),b8065.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map8065 = new java.util.HashMap<String,Object>();
		map8065.put("key8065", b8065.toString()); // put in a collection
		String c8065 = (String)map8065.get("key8065"); // get it back out
		String d8065 = c8065.substring(0,c8065.length()-1); // extract most of it
		String e8065 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d8065.getBytes() ) )); // B64 encode and decode it
		String f8065 = e8065.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g8065 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g8065); // reflection
		
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}
}
