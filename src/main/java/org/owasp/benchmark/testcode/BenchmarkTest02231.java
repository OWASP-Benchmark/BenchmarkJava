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

@WebServlet("/BenchmarkTest02231")
public class BenchmarkTest02231 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			String[] values = map.get("vector");
			if (values != null) param = values[0];
		}
		

		String bar = doSomething(param);
		
		Object[] obj = { bar, "b"};
		response.getWriter().printf("Formatted like: %1$s and %2$s.",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a77735 = param; //assign
		StringBuilder b77735 = new StringBuilder(a77735);  // stick in stringbuilder
		b77735.append(" SafeStuff"); // append some safe content
		b77735.replace(b77735.length()-"Chars".length(),b77735.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77735 = new java.util.HashMap<String,Object>();
		map77735.put("key77735", b77735.toString()); // put in a collection
		String c77735 = (String)map77735.get("key77735"); // get it back out
		String d77735 = c77735.substring(0,c77735.length()-1); // extract most of it
		String e77735 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77735.getBytes() ) )); // B64 encode and decode it
		String f77735 = e77735.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g77735 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g77735); // reflection
	
		return bar;	
	}
}
