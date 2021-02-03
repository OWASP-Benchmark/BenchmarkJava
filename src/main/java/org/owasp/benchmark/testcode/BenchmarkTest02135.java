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

@WebServlet(value="/xss-04/BenchmarkTest02135")
public class BenchmarkTest02135 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String param = request.getParameter("BenchmarkTest02135");
		if (param == null) param = "";

		String bar = doSomething(request, param);
		
response.setHeader("X-XSS-Protection", "0");
		response.getWriter().write(bar);
	}  // end doPost
	
		
	private static String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95930 = param; //assign
		StringBuilder b95930 = new StringBuilder(a95930);  // stick in stringbuilder
		b95930.append(" SafeStuff"); // append some safe content
		b95930.replace(b95930.length()-"Chars".length(),b95930.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95930 = new java.util.HashMap<String,Object>();
		map95930.put("key95930", b95930.toString()); // put in a collection
		String c95930 = (String)map95930.get("key95930"); // get it back out
		String d95930 = c95930.substring(0,c95930.length()-1); // extract most of it
		String e95930 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d95930.getBytes() ) )); // B64 encode and decode it
		String f95930 = e95930.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g95930 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g95930); // reflection
	
		return bar;	
	}
}
