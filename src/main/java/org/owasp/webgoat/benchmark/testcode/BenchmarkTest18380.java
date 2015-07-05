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

@WebServlet("/BenchmarkTest18380")
public class BenchmarkTest18380 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64313 = param; //assign
		StringBuilder b64313 = new StringBuilder(a64313);  // stick in stringbuilder
		b64313.append(" SafeStuff"); // append some safe content
		b64313.replace(b64313.length()-"Chars".length(),b64313.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64313 = new java.util.HashMap<String,Object>();
		map64313.put("key64313", b64313.toString()); // put in a collection
		String c64313 = (String)map64313.get("key64313"); // get it back out
		String d64313 = c64313.substring(0,c64313.length()-1); // extract most of it
		String e64313 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64313.getBytes() ) )); // B64 encode and decode it
		String f64313 = e64313.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64313); // reflection
	
		return bar;	
	}
}
