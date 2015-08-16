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

@WebServlet("/BenchmarkTest00377")
public class BenchmarkTest00377 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = request.getParameter("vector");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a84752 = param; //assign
		StringBuilder b84752 = new StringBuilder(a84752);  // stick in stringbuilder
		b84752.append(" SafeStuff"); // append some safe content
		b84752.replace(b84752.length()-"Chars".length(),b84752.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84752 = new java.util.HashMap<String,Object>();
		map84752.put("key84752", b84752.toString()); // put in a collection
		String c84752 = (String)map84752.get("key84752"); // get it back out
		String d84752 = c84752.substring(0,c84752.length()-1); // extract most of it
		String e84752 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84752.getBytes() ) )); // B64 encode and decode it
		String f84752 = e84752.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g84752 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g84752); // reflection
		
		
		java.io.File fileTarget = new java.io.File(bar);
		response.getWriter().write("Access to file: '" + fileTarget + "' created." );
		if (fileTarget.exists()) {
			response.getWriter().write(" And file already exists.");
		} else { response.getWriter().write(" But file doesn't exist yet."); }
	}
}
