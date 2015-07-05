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

@WebServlet("/BenchmarkTest09326")
public class BenchmarkTest09326 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a26565 = param; //assign
		StringBuilder b26565 = new StringBuilder(a26565);  // stick in stringbuilder
		b26565.append(" SafeStuff"); // append some safe content
		b26565.replace(b26565.length()-"Chars".length(),b26565.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26565 = new java.util.HashMap<String,Object>();
		map26565.put("key26565", b26565.toString()); // put in a collection
		String c26565 = (String)map26565.get("key26565"); // get it back out
		String d26565 = c26565.substring(0,c26565.length()-1); // extract most of it
		String e26565 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26565.getBytes() ) )); // B64 encode and decode it
		String f26565 = e26565.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f26565); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
