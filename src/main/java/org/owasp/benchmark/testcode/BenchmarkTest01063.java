/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
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

@WebServlet("/BenchmarkTest01063")
public class BenchmarkTest01063 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = request.getHeader("vector");
		if (param == null) param = "";

		String bar = new Test().doSomething(param);
		
		response.getWriter().write("Parameter value: " + bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a97938 = param; //assign
		StringBuilder b97938 = new StringBuilder(a97938);  // stick in stringbuilder
		b97938.append(" SafeStuff"); // append some safe content
		b97938.replace(b97938.length()-"Chars".length(),b97938.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map97938 = new java.util.HashMap<String,Object>();
		map97938.put("key97938", b97938.toString()); // put in a collection
		String c97938 = (String)map97938.get("key97938"); // get it back out
		String d97938 = c97938.substring(0,c97938.length()-1); // extract most of it
		String e97938 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d97938.getBytes() ) )); // B64 encode and decode it
		String f97938 = e97938.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f97938); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
