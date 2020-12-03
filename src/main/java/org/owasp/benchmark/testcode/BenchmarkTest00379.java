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

@WebServlet(value="/xss-00/BenchmarkTest00379")
public class BenchmarkTest00379 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = request.getParameter("BenchmarkTest00379");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a75704 = param; //assign
		StringBuilder b75704 = new StringBuilder(a75704);  // stick in stringbuilder
		b75704.append(" SafeStuff"); // append some safe content
		b75704.replace(b75704.length()-"Chars".length(),b75704.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75704 = new java.util.HashMap<String,Object>();
		map75704.put("key75704", b75704.toString()); // put in a collection
		String c75704 = (String)map75704.get("key75704"); // get it back out
		String d75704 = c75704.substring(0,c75704.length()-1); // extract most of it
		String e75704 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d75704.getBytes() ) )); // B64 encode and decode it
		String f75704 = e75704.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g75704 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g75704); // reflection
		
		
response.setHeader("X-XSS-Protection", "0");
		response.getWriter().print(bar.toCharArray());
	}
	
}
