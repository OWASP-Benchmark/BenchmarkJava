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

@WebServlet("/BenchmarkTest20506")
public class BenchmarkTest20506 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a59623 = param; //assign
		StringBuilder b59623 = new StringBuilder(a59623);  // stick in stringbuilder
		b59623.append(" SafeStuff"); // append some safe content
		b59623.replace(b59623.length()-"Chars".length(),b59623.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59623 = new java.util.HashMap<String,Object>();
		map59623.put("key59623", b59623.toString()); // put in a collection
		String c59623 = (String)map59623.get("key59623"); // get it back out
		String d59623 = c59623.substring(0,c59623.length()-1); // extract most of it
		String e59623 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59623.getBytes() ) )); // B64 encode and decode it
		String f59623 = e59623.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g59623 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g59623); // reflection
	
		return bar;	
	}
}
