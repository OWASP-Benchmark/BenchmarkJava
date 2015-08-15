/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
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

@WebServlet("/BenchmarkTest01095")
public class BenchmarkTest01095 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = request.getHeader("vector");
		if (param == null) param = "";

		String bar = new Test().doSomething(param);
		
		byte[] input = new byte[1000];
		String str = "?";
		Object inputParam = param;
		if (inputParam instanceof String) str = ((String) inputParam);
		if (inputParam instanceof java.io.InputStream) {
			int i = ((java.io.InputStream) inputParam).read(input);
			if (i == -1) {
				response.getWriter().println("This input source requires a POST, not a GET. Incompatible UI for the InputStream source.");
				return;
			}			
			str = new String(input, 0, i);
		}
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie", str);
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);

        response.getWriter().println("Created cookie: 'SomeCookie': with value: '"
          + org.owasp.esapi.ESAPI.encoder().encodeForHTML(str) + "' and secure flag set to: false");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52552 = param; //assign
		StringBuilder b52552 = new StringBuilder(a52552);  // stick in stringbuilder
		b52552.append(" SafeStuff"); // append some safe content
		b52552.replace(b52552.length()-"Chars".length(),b52552.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52552 = new java.util.HashMap<String,Object>();
		map52552.put("key52552", b52552.toString()); // put in a collection
		String c52552 = (String)map52552.get("key52552"); // get it back out
		String d52552 = c52552.substring(0,c52552.length()-1); // extract most of it
		String e52552 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52552.getBytes() ) )); // B64 encode and decode it
		String f52552 = e52552.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g52552 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52552); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
