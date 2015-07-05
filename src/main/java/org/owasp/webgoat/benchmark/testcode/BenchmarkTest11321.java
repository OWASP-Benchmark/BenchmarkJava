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

@WebServlet("/BenchmarkTest11321")
public class BenchmarkTest11321 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a55277 = param; //assign
		StringBuilder b55277 = new StringBuilder(a55277);  // stick in stringbuilder
		b55277.append(" SafeStuff"); // append some safe content
		b55277.replace(b55277.length()-"Chars".length(),b55277.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map55277 = new java.util.HashMap<String,Object>();
		map55277.put("key55277", b55277.toString()); // put in a collection
		String c55277 = (String)map55277.get("key55277"); // get it back out
		String d55277 = c55277.substring(0,c55277.length()-1); // extract most of it
		String e55277 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d55277.getBytes() ) )); // B64 encode and decode it
		String f55277 = e55277.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g55277 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g55277); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
