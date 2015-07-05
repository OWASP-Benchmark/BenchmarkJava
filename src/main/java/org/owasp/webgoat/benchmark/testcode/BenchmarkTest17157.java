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

@WebServlet("/BenchmarkTest17157")
public class BenchmarkTest17157 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a44330 = param; //assign
		StringBuilder b44330 = new StringBuilder(a44330);  // stick in stringbuilder
		b44330.append(" SafeStuff"); // append some safe content
		b44330.replace(b44330.length()-"Chars".length(),b44330.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44330 = new java.util.HashMap<String,Object>();
		map44330.put("key44330", b44330.toString()); // put in a collection
		String c44330 = (String)map44330.get("key44330"); // get it back out
		String d44330 = c44330.substring(0,c44330.length()-1); // extract most of it
		String e44330 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44330.getBytes() ) )); // B64 encode and decode it
		String f44330 = e44330.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g44330 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g44330); // reflection
	
		return bar;	
	}
}
