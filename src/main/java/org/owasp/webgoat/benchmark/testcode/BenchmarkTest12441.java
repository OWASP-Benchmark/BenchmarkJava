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

@WebServlet("/BenchmarkTest12441")
public class BenchmarkTest12441 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1", "SUN");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
			throw new ServletException(e);			
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.lang.String)");
			throw new ServletException(e);
		}

		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String,java.lang.String) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a9700 = param; //assign
		StringBuilder b9700 = new StringBuilder(a9700);  // stick in stringbuilder
		b9700.append(" SafeStuff"); // append some safe content
		b9700.replace(b9700.length()-"Chars".length(),b9700.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9700 = new java.util.HashMap<String,Object>();
		map9700.put("key9700", b9700.toString()); // put in a collection
		String c9700 = (String)map9700.get("key9700"); // get it back out
		String d9700 = c9700.substring(0,c9700.length()-1); // extract most of it
		String e9700 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9700.getBytes() ) )); // B64 encode and decode it
		String f9700 = e9700.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g9700 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g9700); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
