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

@WebServlet("/BenchmarkTest06042")
public class BenchmarkTest06042 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a86061 = param; //assign
		StringBuilder b86061 = new StringBuilder(a86061);  // stick in stringbuilder
		b86061.append(" SafeStuff"); // append some safe content
		b86061.replace(b86061.length()-"Chars".length(),b86061.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86061 = new java.util.HashMap<String,Object>();
		map86061.put("key86061", b86061.toString()); // put in a collection
		String c86061 = (String)map86061.get("key86061"); // get it back out
		String d86061 = c86061.substring(0,c86061.length()-1); // extract most of it
		String e86061 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86061.getBytes() ) )); // B64 encode and decode it
		String f86061 = e86061.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f86061); // reflection
		
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
            // TODO: Fix this.
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
