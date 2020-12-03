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

@WebServlet(value="/xss-04/BenchmarkTest02396")
public class BenchmarkTest02396 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("BenchmarkTest02396");
		if (param == null) param = "";

		String bar = doSomething(request, param);
		
response.setHeader("X-XSS-Protection", "0");
		Object[] obj = { "a", "b" };
		response.getWriter().format(bar,obj);
	}  // end doPost
	
		
	private static String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a53479 = param; //assign
		StringBuilder b53479 = new StringBuilder(a53479);  // stick in stringbuilder
		b53479.append(" SafeStuff"); // append some safe content
		b53479.replace(b53479.length()-"Chars".length(),b53479.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53479 = new java.util.HashMap<String,Object>();
		map53479.put("key53479", b53479.toString()); // put in a collection
		String c53479 = (String)map53479.get("key53479"); // get it back out
		String d53479 = c53479.substring(0,c53479.length()-1); // extract most of it
		String e53479 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d53479.getBytes() ) )); // B64 encode and decode it
		String f53479 = e53479.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f53479); // reflection
	
		return bar;	
	}
}
