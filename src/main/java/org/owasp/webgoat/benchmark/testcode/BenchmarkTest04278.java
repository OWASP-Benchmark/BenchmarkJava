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

@WebServlet("/BenchmarkTest04278")
public class BenchmarkTest04278 extends HttpServlet {
	
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
		String a53692 = param; //assign
		StringBuilder b53692 = new StringBuilder(a53692);  // stick in stringbuilder
		b53692.append(" SafeStuff"); // append some safe content
		b53692.replace(b53692.length()-"Chars".length(),b53692.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53692 = new java.util.HashMap<String,Object>();
		map53692.put("key53692", b53692.toString()); // put in a collection
		String c53692 = (String)map53692.get("key53692"); // get it back out
		String d53692 = c53692.substring(0,c53692.length()-1); // extract most of it
		String e53692 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53692.getBytes() ) )); // B64 encode and decode it
		String f53692 = e53692.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g53692 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g53692); // reflection
		
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}
}
