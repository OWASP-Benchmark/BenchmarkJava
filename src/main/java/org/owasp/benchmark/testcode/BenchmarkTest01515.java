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

@WebServlet("/BenchmarkTest01515")
public class BenchmarkTest01515 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("vector");
		if (param == null) param = "";

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a97453 = param; //assign
		StringBuilder b97453 = new StringBuilder(a97453);  // stick in stringbuilder
		b97453.append(" SafeStuff"); // append some safe content
		b97453.replace(b97453.length()-"Chars".length(),b97453.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map97453 = new java.util.HashMap<String,Object>();
		map97453.put("key97453", b97453.toString()); // put in a collection
		String c97453 = (String)map97453.get("key97453"); // get it back out
		String d97453 = c97453.substring(0,c97453.length()-1); // extract most of it
		String e97453 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d97453.getBytes() ) )); // B64 encode and decode it
		String f97453 = e97453.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g97453 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g97453); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
