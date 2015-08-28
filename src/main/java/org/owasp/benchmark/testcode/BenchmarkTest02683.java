/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
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

@WebServlet("/BenchmarkTest02683")
public class BenchmarkTest02683 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("vector");

		String bar = doSomething(param);
		
		response.getWriter().print(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a34415 = param; //assign
		StringBuilder b34415 = new StringBuilder(a34415);  // stick in stringbuilder
		b34415.append(" SafeStuff"); // append some safe content
		b34415.replace(b34415.length()-"Chars".length(),b34415.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34415 = new java.util.HashMap<String,Object>();
		map34415.put("key34415", b34415.toString()); // put in a collection
		String c34415 = (String)map34415.get("key34415"); // get it back out
		String d34415 = c34415.substring(0,c34415.length()-1); // extract most of it
		String e34415 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34415.getBytes() ) )); // B64 encode and decode it
		String f34415 = e34415.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g34415 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g34415); // reflection
	
		return bar;	
	}
}
