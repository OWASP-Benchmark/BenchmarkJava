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

@WebServlet("/BenchmarkTest00545")
public class BenchmarkTest00545 extends HttpServlet {
	
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
		String a21936 = param; //assign
		StringBuilder b21936 = new StringBuilder(a21936);  // stick in stringbuilder
		b21936.append(" SafeStuff"); // append some safe content
		b21936.replace(b21936.length()-"Chars".length(),b21936.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map21936 = new java.util.HashMap<String,Object>();
		map21936.put("key21936", b21936.toString()); // put in a collection
		String c21936 = (String)map21936.get("key21936"); // get it back out
		String d21936 = c21936.substring(0,c21936.length()-1); // extract most of it
		String e21936 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d21936.getBytes() ) )); // B64 encode and decode it
		String f21936 = e21936.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g21936 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g21936); // reflection
		
		
		response.getWriter().print(bar.toCharArray());
	}
}
