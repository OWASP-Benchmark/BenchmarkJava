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

@WebServlet("/BenchmarkTest01598")
public class BenchmarkTest01598 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String[] values = request.getParameterValues("vector");
		String param;
		if (values != null && values.length > 0)
		  param = values[0];
		else param = "";

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a8895 = param; //assign
		StringBuilder b8895 = new StringBuilder(a8895);  // stick in stringbuilder
		b8895.append(" SafeStuff"); // append some safe content
		b8895.replace(b8895.length()-"Chars".length(),b8895.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map8895 = new java.util.HashMap<String,Object>();
		map8895.put("key8895", b8895.toString()); // put in a collection
		String c8895 = (String)map8895.get("key8895"); // get it back out
		String d8895 = c8895.substring(0,c8895.length()-1); // extract most of it
		String e8895 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d8895.getBytes() ) )); // B64 encode and decode it
		String f8895 = e8895.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f8895); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
