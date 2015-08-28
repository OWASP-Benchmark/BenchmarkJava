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

@WebServlet("/BenchmarkTest02126")
public class BenchmarkTest02126 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String param = request.getParameter("vector");
		if (param == null) param = "";

		String bar = doSomething(param);
		
		response.getWriter().print(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a27705 = param; //assign
		StringBuilder b27705 = new StringBuilder(a27705);  // stick in stringbuilder
		b27705.append(" SafeStuff"); // append some safe content
		b27705.replace(b27705.length()-"Chars".length(),b27705.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map27705 = new java.util.HashMap<String,Object>();
		map27705.put("key27705", b27705.toString()); // put in a collection
		String c27705 = (String)map27705.get("key27705"); // get it back out
		String d27705 = c27705.substring(0,c27705.length()-1); // extract most of it
		String e27705 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d27705.getBytes() ) )); // B64 encode and decode it
		String f27705 = e27705.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f27705); // reflection
	
		return bar;	
	}
}
