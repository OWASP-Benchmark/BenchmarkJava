/**
* OWASP Benchmark Project v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
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

@WebServlet("/BenchmarkTest01075")
public class BenchmarkTest01075 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a55230 = param; //assign
		StringBuilder b55230 = new StringBuilder(a55230);  // stick in stringbuilder
		b55230.append(" SafeStuff"); // append some safe content
		b55230.replace(b55230.length()-"Chars".length(),b55230.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55230 = new java.util.HashMap<String,Object>();
		map55230.put("key55230", b55230.toString()); // put in a collection
		String c55230 = (String)map55230.get("key55230"); // get it back out
		String d55230 = c55230.substring(0,c55230.length()-1); // extract most of it
		String e55230 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55230.getBytes() ) )); // B64 encode and decode it
		String f55230 = e55230.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g55230 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55230); // reflection
		
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
