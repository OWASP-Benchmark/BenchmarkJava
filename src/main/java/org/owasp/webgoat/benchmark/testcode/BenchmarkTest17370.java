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

@WebServlet("/BenchmarkTest17370")
public class BenchmarkTest17370 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = doSomething(param);
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
            // TODO: Fix this.
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a72531 = param; //assign
		StringBuilder b72531 = new StringBuilder(a72531);  // stick in stringbuilder
		b72531.append(" SafeStuff"); // append some safe content
		b72531.replace(b72531.length()-"Chars".length(),b72531.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72531 = new java.util.HashMap<String,Object>();
		map72531.put("key72531", b72531.toString()); // put in a collection
		String c72531 = (String)map72531.get("key72531"); // get it back out
		String d72531 = c72531.substring(0,c72531.length()-1); // extract most of it
		String e72531 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72531.getBytes() ) )); // B64 encode and decode it
		String f72531 = e72531.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g72531 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g72531); // reflection
	
		return bar;	
	}
}
