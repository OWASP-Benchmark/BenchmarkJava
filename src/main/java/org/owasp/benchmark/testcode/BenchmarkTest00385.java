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

@WebServlet(value="/xss-00/BenchmarkTest00385")
public class BenchmarkTest00385 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = request.getParameter("BenchmarkTest00385");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a21475 = param; //assign
		StringBuilder b21475 = new StringBuilder(a21475);  // stick in stringbuilder
		b21475.append(" SafeStuff"); // append some safe content
		b21475.replace(b21475.length()-"Chars".length(),b21475.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21475 = new java.util.HashMap<String,Object>();
		map21475.put("key21475", b21475.toString()); // put in a collection
		String c21475 = (String)map21475.get("key21475"); // get it back out
		String d21475 = c21475.substring(0,c21475.length()-1); // extract most of it
		String e21475 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d21475.getBytes() ) )); // B64 encode and decode it
		String f21475 = e21475.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f21475); // reflection
		
		
response.setHeader("X-XSS-Protection", "0");
		Object[] obj = { bar, "b"};
		response.getWriter().printf("Formatted like: %1$s and %2$s.",obj);
	}
	
}
