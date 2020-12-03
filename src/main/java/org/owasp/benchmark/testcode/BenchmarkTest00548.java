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

@WebServlet(value="/xss-01/BenchmarkTest00548")
public class BenchmarkTest00548 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		boolean flag = true;
		java.util.Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements() && flag) {
			String name = (String) names.nextElement();		    	
			String[] values = request.getParameterValues(name);
			if (values != null) {
				for(int i=0;i<values.length && flag; i++){
					String value = values[i];
					if (value.equals("BenchmarkTest00548")) {
						param = name;
					    flag = false;
					}
				}
			}
		}
		
		
		// Chain a bunch of propagators in sequence
		String a52901 = param; //assign
		StringBuilder b52901 = new StringBuilder(a52901);  // stick in stringbuilder
		b52901.append(" SafeStuff"); // append some safe content
		b52901.replace(b52901.length()-"Chars".length(),b52901.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52901 = new java.util.HashMap<String,Object>();
		map52901.put("key52901", b52901.toString()); // put in a collection
		String c52901 = (String)map52901.get("key52901"); // get it back out
		String d52901 = c52901.substring(0,c52901.length()-1); // extract most of it
		String e52901 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d52901.getBytes() ) )); // B64 encode and decode it
		String f52901 = e52901.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g52901 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52901); // reflection
		
		
response.setHeader("X-XSS-Protection", "0");
		Object[] obj = { bar, "b"};
		response.getWriter().printf("Formatted like: %1$s and %2$s.",obj);
	}
	
}
