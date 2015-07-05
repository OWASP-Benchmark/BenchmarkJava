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

@WebServlet("/BenchmarkTest07308")
public class BenchmarkTest07308 extends HttpServlet {
	
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
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
            // TODO: Fix this.
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87267 = param; //assign
		StringBuilder b87267 = new StringBuilder(a87267);  // stick in stringbuilder
		b87267.append(" SafeStuff"); // append some safe content
		b87267.replace(b87267.length()-"Chars".length(),b87267.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87267 = new java.util.HashMap<String,Object>();
		map87267.put("key87267", b87267.toString()); // put in a collection
		String c87267 = (String)map87267.get("key87267"); // get it back out
		String d87267 = c87267.substring(0,c87267.length()-1); // extract most of it
		String e87267 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87267.getBytes() ) )); // B64 encode and decode it
		String f87267 = e87267.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g87267 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87267); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
