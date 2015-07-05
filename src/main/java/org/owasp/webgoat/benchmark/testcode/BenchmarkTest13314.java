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

@WebServlet("/BenchmarkTest13314")
public class BenchmarkTest13314 extends HttpServlet {
	
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
	    	java.util.Random numGen = java.security.SecureRandom.getInstance("SHA1PRNG");
        	boolean randNumber = getNextNumber(numGen);
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Problem executing SecureRandom.nextBoolean() - TestCase");
            throw new ServletException(e);
        }

        response.getWriter().println("Weak Randomness Test java.security.SecureRandom.nextBoolean() executed");
	}
	
	boolean getNextNumber(java.util.Random generator) {
		return generator.nextBoolean();
	
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a93680 = param; //assign
		StringBuilder b93680 = new StringBuilder(a93680);  // stick in stringbuilder
		b93680.append(" SafeStuff"); // append some safe content
		b93680.replace(b93680.length()-"Chars".length(),b93680.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map93680 = new java.util.HashMap<String,Object>();
		map93680.put("key93680", b93680.toString()); // put in a collection
		String c93680 = (String)map93680.get("key93680"); // get it back out
		String d93680 = c93680.substring(0,c93680.length()-1); // extract most of it
		String e93680 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d93680.getBytes() ) )); // B64 encode and decode it
		String f93680 = e93680.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g93680 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g93680); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
