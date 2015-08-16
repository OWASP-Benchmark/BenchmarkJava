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

@WebServlet("/BenchmarkTest00146")
public class BenchmarkTest00146 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = request.getHeader("vector");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a82306 = param; //assign
		StringBuilder b82306 = new StringBuilder(a82306);  // stick in stringbuilder
		b82306.append(" SafeStuff"); // append some safe content
		b82306.replace(b82306.length()-"Chars".length(),b82306.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82306 = new java.util.HashMap<String,Object>();
		map82306.put("key82306", b82306.toString()); // put in a collection
		String c82306 = (String)map82306.get("key82306"); // get it back out
		String d82306 = c82306.substring(0,c82306.length()-1); // extract most of it
		String e82306 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82306.getBytes() ) )); // B64 encode and decode it
		String f82306 = e82306.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g82306 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g82306); // reflection
		
		
		java.io.File fileTarget = new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir, bar);
		response.getWriter().write("Access to file: '" + fileTarget + "' created." );
		if (fileTarget.exists()) {
			response.getWriter().write(" And file already exists.");
		} else { response.getWriter().write(" But file doesn't exist yet."); }
	}
}
