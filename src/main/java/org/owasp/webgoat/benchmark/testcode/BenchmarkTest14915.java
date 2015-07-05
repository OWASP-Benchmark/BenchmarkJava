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

@WebServlet("/BenchmarkTest14915")
public class BenchmarkTest14915 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a74803 = param; //assign
		StringBuilder b74803 = new StringBuilder(a74803);  // stick in stringbuilder
		b74803.append(" SafeStuff"); // append some safe content
		b74803.replace(b74803.length()-"Chars".length(),b74803.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map74803 = new java.util.HashMap<String,Object>();
		map74803.put("key74803", b74803.toString()); // put in a collection
		String c74803 = (String)map74803.get("key74803"); // get it back out
		String d74803 = c74803.substring(0,c74803.length()-1); // extract most of it
		String e74803 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d74803.getBytes() ) )); // B64 encode and decode it
		String f74803 = e74803.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g74803 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g74803); // reflection
	
		return bar;	
	}
}
