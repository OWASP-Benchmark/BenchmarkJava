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

@WebServlet("/BenchmarkTest07600")
public class BenchmarkTest07600 extends HttpServlet {
	
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
		
		String cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo");
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd + bar);
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
            throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70836 = param; //assign
		StringBuilder b70836 = new StringBuilder(a70836);  // stick in stringbuilder
		b70836.append(" SafeStuff"); // append some safe content
		b70836.replace(b70836.length()-"Chars".length(),b70836.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70836 = new java.util.HashMap<String,Object>();
		map70836.put("key70836", b70836.toString()); // put in a collection
		String c70836 = (String)map70836.get("key70836"); // get it back out
		String d70836 = c70836.substring(0,c70836.length()-1); // extract most of it
		String e70836 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70836.getBytes() ) )); // B64 encode and decode it
		String f70836 = e70836.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g70836 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g70836); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
