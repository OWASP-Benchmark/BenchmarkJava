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

@WebServlet(value="/xss-00/BenchmarkTest00383")
public class BenchmarkTest00383 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = request.getParameter("BenchmarkTest00383");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a2196 = param; //assign
		StringBuilder b2196 = new StringBuilder(a2196);  // stick in stringbuilder
		b2196.append(" SafeStuff"); // append some safe content
		b2196.replace(b2196.length()-"Chars".length(),b2196.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map2196 = new java.util.HashMap<String,Object>();
		map2196.put("key2196", b2196.toString()); // put in a collection
		String c2196 = (String)map2196.get("key2196"); // get it back out
		String d2196 = c2196.substring(0,c2196.length()-1); // extract most of it
		String e2196 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d2196.getBytes() ) )); // B64 encode and decode it
		String f2196 = e2196.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f2196); // reflection
		
		
response.setHeader("X-XSS-Protection", "0");
		Object[] obj = { "a", "b"};
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}
	
}
