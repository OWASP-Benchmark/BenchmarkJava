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

@WebServlet("/BenchmarkTest01109")
public class BenchmarkTest01109 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = "";
		boolean flag = true;
		java.util.Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements() && flag) {
			String name = (String) names.nextElement();
			java.util.Enumeration<String> values = request.getHeaders(name);
			if (values != null) {
				while (values.hasMoreElements() && flag) {
					String value = (String) values.nextElement();
					if (value.equals("vector")) {
						param = name;
						flag = false;
					}
				}
			}
		}

		String bar = new Test().doSomething(param);
		
		java.io.File fileTarget = new java.io.File(bar, "/Test.txt");
		response.getWriter().write("Access to file: '" + fileTarget + "' created." );
		if (fileTarget.exists()) {
			response.getWriter().write(" And file already exists.");
		} else { response.getWriter().write(" But file doesn't exist yet."); }
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95129 = param; //assign
		StringBuilder b95129 = new StringBuilder(a95129);  // stick in stringbuilder
		b95129.append(" SafeStuff"); // append some safe content
		b95129.replace(b95129.length()-"Chars".length(),b95129.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95129 = new java.util.HashMap<String,Object>();
		map95129.put("key95129", b95129.toString()); // put in a collection
		String c95129 = (String)map95129.get("key95129"); // get it back out
		String d95129 = c95129.substring(0,c95129.length()-1); // extract most of it
		String e95129 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95129.getBytes() ) )); // B64 encode and decode it
		String f95129 = e95129.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g95129 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g95129); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
