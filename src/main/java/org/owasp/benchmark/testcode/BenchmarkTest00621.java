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

@WebServlet("/BenchmarkTest00621")
public class BenchmarkTest00621 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("vector");
		if (param == null) param = "";
		
		
		// Chain a bunch of propagators in sequence
		String a72828 = param; //assign
		StringBuilder b72828 = new StringBuilder(a72828);  // stick in stringbuilder
		b72828.append(" SafeStuff"); // append some safe content
		b72828.replace(b72828.length()-"Chars".length(),b72828.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72828 = new java.util.HashMap<String,Object>();
		map72828.put("key72828", b72828.toString()); // put in a collection
		String c72828 = (String)map72828.get("key72828"); // get it back out
		String d72828 = c72828.substring(0,c72828.length()-1); // extract most of it
		String e72828 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72828.getBytes() ) )); // B64 encode and decode it
		String f72828 = e72828.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g72828 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g72828); // reflection
		
		
		java.io.File fileTarget = new java.io.File(new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir),bar);
		response.getWriter().write("Access to file: '" + fileTarget + "' created." );
		if (fileTarget.exists()) {
			response.getWriter().write(" And file already exists.");
		} else { response.getWriter().write(" But file doesn't exist yet."); }
	}
}
