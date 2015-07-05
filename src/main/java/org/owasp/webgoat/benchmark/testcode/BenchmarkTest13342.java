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

@WebServlet("/BenchmarkTest13342")
public class BenchmarkTest13342 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		try {
			double rand = java.security.SecureRandom.getInstance("SHA1PRNG").nextDouble();
	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextDouble() - TestCase");
			throw new ServletException(e);
	    }
		
		response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextDouble() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a40010 = param; //assign
		StringBuilder b40010 = new StringBuilder(a40010);  // stick in stringbuilder
		b40010.append(" SafeStuff"); // append some safe content
		b40010.replace(b40010.length()-"Chars".length(),b40010.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40010 = new java.util.HashMap<String,Object>();
		map40010.put("key40010", b40010.toString()); // put in a collection
		String c40010 = (String)map40010.get("key40010"); // get it back out
		String d40010 = c40010.substring(0,c40010.length()-1); // extract most of it
		String e40010 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40010.getBytes() ) )); // B64 encode and decode it
		String f40010 = e40010.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40010); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
