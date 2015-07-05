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

@WebServlet("/BenchmarkTest08696")
public class BenchmarkTest08696 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a55366 = param; //assign
		StringBuilder b55366 = new StringBuilder(a55366);  // stick in stringbuilder
		b55366.append(" SafeStuff"); // append some safe content
		b55366.replace(b55366.length()-"Chars".length(),b55366.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55366 = new java.util.HashMap<String,Object>();
		map55366.put("key55366", b55366.toString()); // put in a collection
		String c55366 = (String)map55366.get("key55366"); // get it back out
		String d55366 = c55366.substring(0,c55366.length()-1); // extract most of it
		String e55366 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55366.getBytes() ) )); // B64 encode and decode it
		String f55366 = e55366.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g55366 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55366); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
