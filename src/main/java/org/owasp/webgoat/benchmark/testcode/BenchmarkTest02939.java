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

@WebServlet("/BenchmarkTest02939")
public class BenchmarkTest02939 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a11733 = param; //assign
		StringBuilder b11733 = new StringBuilder(a11733);  // stick in stringbuilder
		b11733.append(" SafeStuff"); // append some safe content
		b11733.replace(b11733.length()-"Chars".length(),b11733.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11733 = new java.util.HashMap<String,Object>();
		map11733.put("key11733", b11733.toString()); // put in a collection
		String c11733 = (String)map11733.get("key11733"); // get it back out
		String d11733 = c11733.substring(0,c11733.length()-1); // extract most of it
		String e11733 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11733.getBytes() ) )); // B64 encode and decode it
		String f11733 = e11733.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f11733); // reflection
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
