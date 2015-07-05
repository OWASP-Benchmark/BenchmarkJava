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

@WebServlet("/BenchmarkTest01038")
public class BenchmarkTest01038 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a81974 = param; //assign
		StringBuilder b81974 = new StringBuilder(a81974);  // stick in stringbuilder
		b81974.append(" SafeStuff"); // append some safe content
		b81974.replace(b81974.length()-"Chars".length(),b81974.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81974 = new java.util.HashMap<String,Object>();
		map81974.put("key81974", b81974.toString()); // put in a collection
		String c81974 = (String)map81974.get("key81974"); // get it back out
		String d81974 = c81974.substring(0,c81974.length()-1); // extract most of it
		String e81974 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81974.getBytes() ) )); // B64 encode and decode it
		String f81974 = e81974.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g81974 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g81974); // reflection
		
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
            // TODO: Fix this.
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}
}
