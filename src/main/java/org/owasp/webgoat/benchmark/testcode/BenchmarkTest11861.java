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

@WebServlet("/BenchmarkTest11861")
public class BenchmarkTest11861 extends HttpServlet {
	
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
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43102 = param; //assign
		StringBuilder b43102 = new StringBuilder(a43102);  // stick in stringbuilder
		b43102.append(" SafeStuff"); // append some safe content
		b43102.replace(b43102.length()-"Chars".length(),b43102.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43102 = new java.util.HashMap<String,Object>();
		map43102.put("key43102", b43102.toString()); // put in a collection
		String c43102 = (String)map43102.get("key43102"); // get it back out
		String d43102 = c43102.substring(0,c43102.length()-1); // extract most of it
		String e43102 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43102.getBytes() ) )); // B64 encode and decode it
		String f43102 = e43102.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g43102 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43102); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
