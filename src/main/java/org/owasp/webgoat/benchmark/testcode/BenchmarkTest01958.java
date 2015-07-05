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

@WebServlet("/BenchmarkTest01958")
public class BenchmarkTest01958 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a63438 = param; //assign
		StringBuilder b63438 = new StringBuilder(a63438);  // stick in stringbuilder
		b63438.append(" SafeStuff"); // append some safe content
		b63438.replace(b63438.length()-"Chars".length(),b63438.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map63438 = new java.util.HashMap<String,Object>();
		map63438.put("key63438", b63438.toString()); // put in a collection
		String c63438 = (String)map63438.get("key63438"); // get it back out
		String d63438 = c63438.substring(0,c63438.length()-1); // extract most of it
		String e63438 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d63438.getBytes() ) )); // B64 encode and decode it
		String f63438 = e63438.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g63438 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g63438); // reflection
		
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}
}
