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

@WebServlet("/BenchmarkTest10495")
public class BenchmarkTest10495 extends HttpServlet {
	
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
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-512", "SUN");
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
		String a60883 = param; //assign
		StringBuilder b60883 = new StringBuilder(a60883);  // stick in stringbuilder
		b60883.append(" SafeStuff"); // append some safe content
		b60883.replace(b60883.length()-"Chars".length(),b60883.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map60883 = new java.util.HashMap<String,Object>();
		map60883.put("key60883", b60883.toString()); // put in a collection
		String c60883 = (String)map60883.get("key60883"); // get it back out
		String d60883 = c60883.substring(0,c60883.length()-1); // extract most of it
		String e60883 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d60883.getBytes() ) )); // B64 encode and decode it
		String f60883 = e60883.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g60883 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g60883); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
