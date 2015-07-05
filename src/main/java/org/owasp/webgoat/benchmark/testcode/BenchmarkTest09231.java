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

@WebServlet("/BenchmarkTest09231")
public class BenchmarkTest09231 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93090 = param; //assign
		StringBuilder b93090 = new StringBuilder(a93090);  // stick in stringbuilder
		b93090.append(" SafeStuff"); // append some safe content
		b93090.replace(b93090.length()-"Chars".length(),b93090.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93090 = new java.util.HashMap<String,Object>();
		map93090.put("key93090", b93090.toString()); // put in a collection
		String c93090 = (String)map93090.get("key93090"); // get it back out
		String d93090 = c93090.substring(0,c93090.length()-1); // extract most of it
		String e93090 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93090.getBytes() ) )); // B64 encode and decode it
		String f93090 = e93090.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g93090 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g93090); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
