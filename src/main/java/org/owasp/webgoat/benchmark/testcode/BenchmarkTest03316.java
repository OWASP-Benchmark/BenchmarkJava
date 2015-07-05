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
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03316")
public class BenchmarkTest03316 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a5556 = param; //assign
		StringBuilder b5556 = new StringBuilder(a5556);  // stick in stringbuilder
		b5556.append(" SafeStuff"); // append some safe content
		b5556.replace(b5556.length()-"Chars".length(),b5556.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5556 = new java.util.HashMap<String,Object>();
		map5556.put("key5556", b5556.toString()); // put in a collection
		String c5556 = (String)map5556.get("key5556"); // get it back out
		String d5556 = c5556.substring(0,c5556.length()-1); // extract most of it
		String e5556 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5556.getBytes() ) )); // B64 encode and decode it
		String f5556 = e5556.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g5556 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g5556); // reflection
		
		
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
	}
}
