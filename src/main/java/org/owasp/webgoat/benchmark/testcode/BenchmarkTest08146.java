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

@WebServlet("/BenchmarkTest08146")
public class BenchmarkTest08146 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a47913 = param; //assign
		StringBuilder b47913 = new StringBuilder(a47913);  // stick in stringbuilder
		b47913.append(" SafeStuff"); // append some safe content
		b47913.replace(b47913.length()-"Chars".length(),b47913.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47913 = new java.util.HashMap<String,Object>();
		map47913.put("key47913", b47913.toString()); // put in a collection
		String c47913 = (String)map47913.get("key47913"); // get it back out
		String d47913 = c47913.substring(0,c47913.length()-1); // extract most of it
		String e47913 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47913.getBytes() ) )); // B64 encode and decode it
		String f47913 = e47913.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g47913 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g47913); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
