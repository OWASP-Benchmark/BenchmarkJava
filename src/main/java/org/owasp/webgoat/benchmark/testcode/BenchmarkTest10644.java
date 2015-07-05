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

@WebServlet("/BenchmarkTest10644")
public class BenchmarkTest10644 extends HttpServlet {
	
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
		

		String bar = new Test().doSomething(param);
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a79977 = param; //assign
		StringBuilder b79977 = new StringBuilder(a79977);  // stick in stringbuilder
		b79977.append(" SafeStuff"); // append some safe content
		b79977.replace(b79977.length()-"Chars".length(),b79977.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map79977 = new java.util.HashMap<String,Object>();
		map79977.put("key79977", b79977.toString()); // put in a collection
		String c79977 = (String)map79977.get("key79977"); // get it back out
		String d79977 = c79977.substring(0,c79977.length()-1); // extract most of it
		String e79977 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d79977.getBytes() ) )); // B64 encode and decode it
		String f79977 = e79977.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f79977); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
