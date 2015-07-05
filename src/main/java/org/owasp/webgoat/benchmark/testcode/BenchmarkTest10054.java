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

@WebServlet("/BenchmarkTest10054")
public class BenchmarkTest10054 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a58677 = param; //assign
		StringBuilder b58677 = new StringBuilder(a58677);  // stick in stringbuilder
		b58677.append(" SafeStuff"); // append some safe content
		b58677.replace(b58677.length()-"Chars".length(),b58677.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58677 = new java.util.HashMap<String,Object>();
		map58677.put("key58677", b58677.toString()); // put in a collection
		String c58677 = (String)map58677.get("key58677"); // get it back out
		String d58677 = c58677.substring(0,c58677.length()-1); // extract most of it
		String e58677 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d58677.getBytes() ) )); // B64 encode and decode it
		String f58677 = e58677.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g58677 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g58677); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
