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

@WebServlet("/BenchmarkTest10602")
public class BenchmarkTest10602 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = new Test().doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a86849 = param; //assign
		StringBuilder b86849 = new StringBuilder(a86849);  // stick in stringbuilder
		b86849.append(" SafeStuff"); // append some safe content
		b86849.replace(b86849.length()-"Chars".length(),b86849.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86849 = new java.util.HashMap<String,Object>();
		map86849.put("key86849", b86849.toString()); // put in a collection
		String c86849 = (String)map86849.get("key86849"); // get it back out
		String d86849 = c86849.substring(0,c86849.length()-1); // extract most of it
		String e86849 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86849.getBytes() ) )); // B64 encode and decode it
		String f86849 = e86849.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g86849 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g86849); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
