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
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08077")
public class BenchmarkTest08077 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a32530 = param; //assign
		StringBuilder b32530 = new StringBuilder(a32530);  // stick in stringbuilder
		b32530.append(" SafeStuff"); // append some safe content
		b32530.replace(b32530.length()-"Chars".length(),b32530.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map32530 = new java.util.HashMap<String,Object>();
		map32530.put("key32530", b32530.toString()); // put in a collection
		String c32530 = (String)map32530.get("key32530"); // get it back out
		String d32530 = c32530.substring(0,c32530.length()-1); // extract most of it
		String e32530 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d32530.getBytes() ) )); // B64 encode and decode it
		String f32530 = e32530.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g32530 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g32530); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
