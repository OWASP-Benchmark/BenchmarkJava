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

@WebServlet("/BenchmarkTest13849")
public class BenchmarkTest13849 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a45982 = param; //assign
		StringBuilder b45982 = new StringBuilder(a45982);  // stick in stringbuilder
		b45982.append(" SafeStuff"); // append some safe content
		b45982.replace(b45982.length()-"Chars".length(),b45982.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45982 = new java.util.HashMap<String,Object>();
		map45982.put("key45982", b45982.toString()); // put in a collection
		String c45982 = (String)map45982.get("key45982"); // get it back out
		String d45982 = c45982.substring(0,c45982.length()-1); // extract most of it
		String e45982 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45982.getBytes() ) )); // B64 encode and decode it
		String f45982 = e45982.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g45982 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g45982); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
