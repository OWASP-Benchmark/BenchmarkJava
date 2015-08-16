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

@WebServlet("/BenchmarkTest00403")
public class BenchmarkTest00403 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a64635 = param; //assign
		StringBuilder b64635 = new StringBuilder(a64635);  // stick in stringbuilder
		b64635.append(" SafeStuff"); // append some safe content
		b64635.replace(b64635.length()-"Chars".length(),b64635.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64635 = new java.util.HashMap<String,Object>();
		map64635.put("key64635", b64635.toString()); // put in a collection
		String c64635 = (String)map64635.get("key64635"); // get it back out
		String d64635 = c64635.substring(0,c64635.length()-1); // extract most of it
		String e64635 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64635.getBytes() ) )); // B64 encode and decode it
		String f64635 = e64635.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64635); // reflection
		
		
		Object[] obj = { "a", "b"};
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}
}
