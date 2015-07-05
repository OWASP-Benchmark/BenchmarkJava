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

@WebServlet("/BenchmarkTest12703")
public class BenchmarkTest12703 extends HttpServlet {
	
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
		    java.security.SecureRandom secureRandomGenerator = java.security.SecureRandom.getInstance("SHA1PRNG");
		
		    // Get 40 random bytes
		    byte[] randomBytes = new byte[40];
		    secureRandomGenerator.nextBytes(randomBytes);
			response.getWriter().println("Random bytes are: " + new String(randomBytes));
				    
	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextBytes() - TestCase");
			throw new ServletException(e);
	    } finally {
			response.getWriter().println("Randomness Test java.security.SecureRandom.nextBytes(byte[]) executed");	    
	    }
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a38717 = param; //assign
		StringBuilder b38717 = new StringBuilder(a38717);  // stick in stringbuilder
		b38717.append(" SafeStuff"); // append some safe content
		b38717.replace(b38717.length()-"Chars".length(),b38717.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38717 = new java.util.HashMap<String,Object>();
		map38717.put("key38717", b38717.toString()); // put in a collection
		String c38717 = (String)map38717.get("key38717"); // get it back out
		String d38717 = c38717.substring(0,c38717.length()-1); // extract most of it
		String e38717 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38717.getBytes() ) )); // B64 encode and decode it
		String f38717 = e38717.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f38717); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
