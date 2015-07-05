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

@WebServlet("/BenchmarkTest04394")
public class BenchmarkTest04394 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a51712 = param; //assign
		StringBuilder b51712 = new StringBuilder(a51712);  // stick in stringbuilder
		b51712.append(" SafeStuff"); // append some safe content
		b51712.replace(b51712.length()-"Chars".length(),b51712.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map51712 = new java.util.HashMap<String,Object>();
		map51712.put("key51712", b51712.toString()); // put in a collection
		String c51712 = (String)map51712.get("key51712"); // get it back out
		String d51712 = c51712.substring(0,c51712.length()-1); // extract most of it
		String e51712 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d51712.getBytes() ) )); // B64 encode and decode it
		String f51712 = e51712.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f51712); // reflection
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
