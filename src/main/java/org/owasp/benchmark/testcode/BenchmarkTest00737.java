/**
* OWASP Benchmark Project v1.2
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Nick Sanidas
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/xss-01/BenchmarkTest00737")
public class BenchmarkTest00737 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String[] values = request.getParameterValues("BenchmarkTest00737");
		String param;
		if (values != null && values.length > 0)
		  param = values[0];
		else param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a57334 = param; //assign
		StringBuilder b57334 = new StringBuilder(a57334);  // stick in stringbuilder
		b57334.append(" SafeStuff"); // append some safe content
		b57334.replace(b57334.length()-"Chars".length(),b57334.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57334 = new java.util.HashMap<String,Object>();
		map57334.put("key57334", b57334.toString()); // put in a collection
		String c57334 = (String)map57334.get("key57334"); // get it back out
		String d57334 = c57334.substring(0,c57334.length()-1); // extract most of it
		String e57334 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d57334.getBytes() ) )); // B64 encode and decode it
		String f57334 = e57334.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f57334); // reflection
		
		
response.setHeader("X-XSS-Protection", "0");
		response.getWriter().write("Parameter value: " + bar);
	}
	
}
