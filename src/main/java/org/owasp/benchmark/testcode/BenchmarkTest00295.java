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

@WebServlet("/BenchmarkTest00295")
public class BenchmarkTest00295 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("vector");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a89677 = param; //assign
		StringBuilder b89677 = new StringBuilder(a89677);  // stick in stringbuilder
		b89677.append(" SafeStuff"); // append some safe content
		b89677.replace(b89677.length()-"Chars".length(),b89677.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89677 = new java.util.HashMap<String,Object>();
		map89677.put("key89677", b89677.toString()); // put in a collection
		String c89677 = (String)map89677.get("key89677"); // get it back out
		String d89677 = c89677.substring(0,c89677.length()-1); // extract most of it
		String e89677 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89677.getBytes() ) )); // B64 encode and decode it
		String f89677 = e89677.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f89677); // reflection
		
		
		Object[] obj = { "a", bar };
		java.io.PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE html>\n<html>\n<body>\n<p>");
		out.format(java.util.Locale.US,"Formatted like: %1$s and %2$s.",obj);
	    out.write("\n</p>\n</body>\n</html>");
	}
}
