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

@WebServlet("/BenchmarkTest00548")
public class BenchmarkTest00548 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = "";
		boolean flag = true;
		java.util.Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements() && flag) {
			String name = (String) names.nextElement();		    	
			String[] values = request.getParameterValues(name);
			if (values != null) {
				for(int i=0;i<values.length && flag; i++){
					String value = values[i];
					if (value.equals("vector")) {
						param = name;
					    flag = false;
					}
				}
			}
		}
		
		
		// Chain a bunch of propagators in sequence
		String a21392 = param; //assign
		StringBuilder b21392 = new StringBuilder(a21392);  // stick in stringbuilder
		b21392.append(" SafeStuff"); // append some safe content
		b21392.replace(b21392.length()-"Chars".length(),b21392.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21392 = new java.util.HashMap<String,Object>();
		map21392.put("key21392", b21392.toString()); // put in a collection
		String c21392 = (String)map21392.get("key21392"); // get it back out
		String d21392 = c21392.substring(0,c21392.length()-1); // extract most of it
		String e21392 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21392.getBytes() ) )); // B64 encode and decode it
		String f21392 = e21392.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g21392 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g21392); // reflection
		
		
		Object[] obj = { bar, "b"};
		response.getWriter().printf("Formatted like: %1$s and %2$s.",obj);
	}
}
