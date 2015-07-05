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

@WebServlet("/BenchmarkTest08062")
public class BenchmarkTest08062 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a89352 = param; //assign
		StringBuilder b89352 = new StringBuilder(a89352);  // stick in stringbuilder
		b89352.append(" SafeStuff"); // append some safe content
		b89352.replace(b89352.length()-"Chars".length(),b89352.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89352 = new java.util.HashMap<String,Object>();
		map89352.put("key89352", b89352.toString()); // put in a collection
		String c89352 = (String)map89352.get("key89352"); // get it back out
		String d89352 = c89352.substring(0,c89352.length()-1); // extract most of it
		String e89352 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89352.getBytes() ) )); // B64 encode and decode it
		String f89352 = e89352.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g89352 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g89352); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
