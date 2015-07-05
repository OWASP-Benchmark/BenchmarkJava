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

@WebServlet("/BenchmarkTest11885")
public class BenchmarkTest11885 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a68438 = param; //assign
		StringBuilder b68438 = new StringBuilder(a68438);  // stick in stringbuilder
		b68438.append(" SafeStuff"); // append some safe content
		b68438.replace(b68438.length()-"Chars".length(),b68438.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68438 = new java.util.HashMap<String,Object>();
		map68438.put("key68438", b68438.toString()); // put in a collection
		String c68438 = (String)map68438.get("key68438"); // get it back out
		String d68438 = c68438.substring(0,c68438.length()-1); // extract most of it
		String e68438 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68438.getBytes() ) )); // B64 encode and decode it
		String f68438 = e68438.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g68438 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g68438); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
