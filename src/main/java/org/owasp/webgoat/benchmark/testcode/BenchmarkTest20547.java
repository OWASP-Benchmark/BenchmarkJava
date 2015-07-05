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

@WebServlet("/BenchmarkTest20547")
public class BenchmarkTest20547 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

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
		String a90787 = param; //assign
		StringBuilder b90787 = new StringBuilder(a90787);  // stick in stringbuilder
		b90787.append(" SafeStuff"); // append some safe content
		b90787.replace(b90787.length()-"Chars".length(),b90787.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map90787 = new java.util.HashMap<String,Object>();
		map90787.put("key90787", b90787.toString()); // put in a collection
		String c90787 = (String)map90787.get("key90787"); // get it back out
		String d90787 = c90787.substring(0,c90787.length()-1); // extract most of it
		String e90787 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d90787.getBytes() ) )); // B64 encode and decode it
		String f90787 = e90787.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f90787); // reflection
	
		return bar;	
	}
}
