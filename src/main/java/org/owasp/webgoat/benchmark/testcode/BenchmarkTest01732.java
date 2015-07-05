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

@WebServlet("/BenchmarkTest01732")
public class BenchmarkTest01732 extends HttpServlet {
	
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
		String a82408 = param; //assign
		StringBuilder b82408 = new StringBuilder(a82408);  // stick in stringbuilder
		b82408.append(" SafeStuff"); // append some safe content
		b82408.replace(b82408.length()-"Chars".length(),b82408.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82408 = new java.util.HashMap<String,Object>();
		map82408.put("key82408", b82408.toString()); // put in a collection
		String c82408 = (String)map82408.get("key82408"); // get it back out
		String d82408 = c82408.substring(0,c82408.length()-1); // extract most of it
		String e82408 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82408.getBytes() ) )); // B64 encode and decode it
		String f82408 = e82408.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g82408 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g82408); // reflection
		
		
		try {	
			java.nio.file.Path path = java.nio.file.Paths.get(org.owasp.benchmark.helpers.Utils.testfileDir + bar);
			java.io.InputStream is = java.nio.file.Files.newInputStream(path, java.nio.file.StandardOpenOption.READ);
		} catch (Exception e) {
			// OK to swallow any exception for now
            // TODO: Fix this, if possible.
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
