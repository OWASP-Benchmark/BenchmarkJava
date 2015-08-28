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

@WebServlet("/BenchmarkTest01550")
public class BenchmarkTest01550 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "userid", bar);
				
		response.getWriter().println("Item: 'userid' with value: '" + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
			+ "' saved in session.");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a35565 = param; //assign
		StringBuilder b35565 = new StringBuilder(a35565);  // stick in stringbuilder
		b35565.append(" SafeStuff"); // append some safe content
		b35565.replace(b35565.length()-"Chars".length(),b35565.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35565 = new java.util.HashMap<String,Object>();
		map35565.put("key35565", b35565.toString()); // put in a collection
		String c35565 = (String)map35565.get("key35565"); // get it back out
		String d35565 = c35565.substring(0,c35565.length()-1); // extract most of it
		String e35565 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35565.getBytes() ) )); // B64 encode and decode it
		String f35565 = e35565.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f35565); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
