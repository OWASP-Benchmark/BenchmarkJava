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

@WebServlet("/BenchmarkTest16321")
public class BenchmarkTest16321 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93103 = param; //assign
		StringBuilder b93103 = new StringBuilder(a93103);  // stick in stringbuilder
		b93103.append(" SafeStuff"); // append some safe content
		b93103.replace(b93103.length()-"Chars".length(),b93103.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93103 = new java.util.HashMap<String,Object>();
		map93103.put("key93103", b93103.toString()); // put in a collection
		String c93103 = (String)map93103.get("key93103"); // get it back out
		String d93103 = c93103.substring(0,c93103.length()-1); // extract most of it
		String e93103 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93103.getBytes() ) )); // B64 encode and decode it
		String f93103 = e93103.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f93103); // reflection
	
		return bar;	
	}
}
