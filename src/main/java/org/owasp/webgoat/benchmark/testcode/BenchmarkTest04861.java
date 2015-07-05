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

@WebServlet("/BenchmarkTest04861")
public class BenchmarkTest04861 extends HttpServlet {
	
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
		String a85691 = param; //assign
		StringBuilder b85691 = new StringBuilder(a85691);  // stick in stringbuilder
		b85691.append(" SafeStuff"); // append some safe content
		b85691.replace(b85691.length()-"Chars".length(),b85691.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map85691 = new java.util.HashMap<String,Object>();
		map85691.put("key85691", b85691.toString()); // put in a collection
		String c85691 = (String)map85691.get("key85691"); // get it back out
		String d85691 = c85691.substring(0,c85691.length()-1); // extract most of it
		String e85691 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d85691.getBytes() ) )); // B64 encode and decode it
		String f85691 = e85691.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f85691); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.benchmark.helpers.Utils.testfileDir + bar, false);
	}
}
