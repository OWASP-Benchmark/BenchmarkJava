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

@WebServlet(value="/xss-04/BenchmarkTest02145")
public class BenchmarkTest02145 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String param = request.getParameter("BenchmarkTest02145");
		if (param == null) param = "";

		String bar = doSomething(request, param);
		
response.setHeader("X-XSS-Protection", "0");
		response.getWriter().write("Parameter value: " + bar);
	}  // end doPost
	
		
	private static String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a32743 = param; //assign
		StringBuilder b32743 = new StringBuilder(a32743);  // stick in stringbuilder
		b32743.append(" SafeStuff"); // append some safe content
		b32743.replace(b32743.length()-"Chars".length(),b32743.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32743 = new java.util.HashMap<String,Object>();
		map32743.put("key32743", b32743.toString()); // put in a collection
		String c32743 = (String)map32743.get("key32743"); // get it back out
		String d32743 = c32743.substring(0,c32743.length()-1); // extract most of it
		String e32743 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d32743.getBytes() ) )); // B64 encode and decode it
		String f32743 = e32743.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f32743); // reflection
	
		return bar;	
	}
}
