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

@WebServlet("/BenchmarkTest16702")
public class BenchmarkTest16702 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		new java.io.File(new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43752 = param; //assign
		StringBuilder b43752 = new StringBuilder(a43752);  // stick in stringbuilder
		b43752.append(" SafeStuff"); // append some safe content
		b43752.replace(b43752.length()-"Chars".length(),b43752.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43752 = new java.util.HashMap<String,Object>();
		map43752.put("key43752", b43752.toString()); // put in a collection
		String c43752 = (String)map43752.get("key43752"); // get it back out
		String d43752 = c43752.substring(0,c43752.length()-1); // extract most of it
		String e43752 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43752.getBytes() ) )); // B64 encode and decode it
		String f43752 = e43752.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f43752); // reflection
	
		return bar;	
	}
}
