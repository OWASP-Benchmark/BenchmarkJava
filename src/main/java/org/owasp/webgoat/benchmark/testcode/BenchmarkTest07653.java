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

@WebServlet("/BenchmarkTest07653")
public class BenchmarkTest07653 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = new Test().doSomething(param);
		
	    try {
		    java.util.Random numGen = java.security.SecureRandom.getInstance("SHA1PRNG");
		
		    // Get 40 random bytes
		    byte[] randomBytes = new byte[40];
		    getNextNumber(numGen, randomBytes);
			response.getWriter().println("Random bytes are: " + new String(randomBytes));
				    
	    } catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing SecureRandom.nextBytes() - TestCase");
			throw new ServletException(e);
	    } finally {
			response.getWriter().println("Randomness Test java.security.SecureRandom.nextBytes(byte[]) executed");	    
	    }
	}
	    	
	void getNextNumber(java.util.Random generator, byte[] barray) {
		generator.nextBytes(barray);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a14829 = param; //assign
		StringBuilder b14829 = new StringBuilder(a14829);  // stick in stringbuilder
		b14829.append(" SafeStuff"); // append some safe content
		b14829.replace(b14829.length()-"Chars".length(),b14829.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14829 = new java.util.HashMap<String,Object>();
		map14829.put("key14829", b14829.toString()); // put in a collection
		String c14829 = (String)map14829.get("key14829"); // get it back out
		String d14829 = c14829.substring(0,c14829.length()-1); // extract most of it
		String e14829 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14829.getBytes() ) )); // B64 encode and decode it
		String f14829 = e14829.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g14829 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g14829); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
