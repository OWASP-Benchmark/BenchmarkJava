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

@WebServlet("/BenchmarkTest01261")
public class BenchmarkTest01261 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = request.getParameter("vector");
		if (param == null) param = "";

		String bar = new Test().doSomething(param);
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a81576 = param; //assign
		StringBuilder b81576 = new StringBuilder(a81576);  // stick in stringbuilder
		b81576.append(" SafeStuff"); // append some safe content
		b81576.replace(b81576.length()-"Chars".length(),b81576.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81576 = new java.util.HashMap<String,Object>();
		map81576.put("key81576", b81576.toString()); // put in a collection
		String c81576 = (String)map81576.get("key81576"); // get it back out
		String d81576 = c81576.substring(0,c81576.length()-1); // extract most of it
		String e81576 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81576.getBytes() ) )); // B64 encode and decode it
		String f81576 = e81576.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f81576); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
