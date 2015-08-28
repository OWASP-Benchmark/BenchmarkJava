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

@WebServlet("/BenchmarkTest02490")
public class BenchmarkTest02490 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String[] values = request.getParameterValues("vector");
		String param;
		if (values != null && values.length > 0)
		  param = values[0];
		else param = "";

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b"};
		response.getWriter().printf(bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95559 = param; //assign
		StringBuilder b95559 = new StringBuilder(a95559);  // stick in stringbuilder
		b95559.append(" SafeStuff"); // append some safe content
		b95559.replace(b95559.length()-"Chars".length(),b95559.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95559 = new java.util.HashMap<String,Object>();
		map95559.put("key95559", b95559.toString()); // put in a collection
		String c95559 = (String)map95559.get("key95559"); // get it back out
		String d95559 = c95559.substring(0,c95559.length()-1); // extract most of it
		String e95559 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95559.getBytes() ) )); // B64 encode and decode it
		String f95559 = e95559.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g95559 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g95559); // reflection
	
		return bar;	
	}
}
