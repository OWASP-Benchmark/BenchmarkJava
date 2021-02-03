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

@WebServlet(value="/xss-00/BenchmarkTest00275")
public class BenchmarkTest00275 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("Referer");
		
		if (headers != null && headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		// URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
		param = java.net.URLDecoder.decode(param, "UTF-8");
		
		
		// Chain a bunch of propagators in sequence
		String a28150 = param; //assign
		StringBuilder b28150 = new StringBuilder(a28150);  // stick in stringbuilder
		b28150.append(" SafeStuff"); // append some safe content
		b28150.replace(b28150.length()-"Chars".length(),b28150.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map28150 = new java.util.HashMap<String,Object>();
		map28150.put("key28150", b28150.toString()); // put in a collection
		String c28150 = (String)map28150.get("key28150"); // get it back out
		String d28150 = c28150.substring(0,c28150.length()-1); // extract most of it
		String e28150 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d28150.getBytes() ) )); // B64 encode and decode it
		String f28150 = e28150.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g28150 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g28150); // reflection
		
		
response.setHeader("X-XSS-Protection", "0");
		response.getWriter().print(bar.toCharArray());
	}
	
}
