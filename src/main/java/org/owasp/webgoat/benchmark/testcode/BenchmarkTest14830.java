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

@WebServlet("/BenchmarkTest14830")
public class BenchmarkTest14830 extends HttpServlet {
	
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
			javax.naming.directory.DirContext dc = org.owasp.benchmark.helpers.Utils.getDirContext();
			Object[] filterArgs = {"a","b"};
			dc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a40824 = param; //assign
		StringBuilder b40824 = new StringBuilder(a40824);  // stick in stringbuilder
		b40824.append(" SafeStuff"); // append some safe content
		b40824.replace(b40824.length()-"Chars".length(),b40824.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40824 = new java.util.HashMap<String,Object>();
		map40824.put("key40824", b40824.toString()); // put in a collection
		String c40824 = (String)map40824.get("key40824"); // get it back out
		String d40824 = c40824.substring(0,c40824.length()-1); // extract most of it
		String e40824 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40824.getBytes() ) )); // B64 encode and decode it
		String f40824 = e40824.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40824); // reflection
	
		return bar;	
	}
}
