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

@WebServlet("/BenchmarkTest13118")
public class BenchmarkTest13118 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a62604 = param; //assign
		StringBuilder b62604 = new StringBuilder(a62604);  // stick in stringbuilder
		b62604.append(" SafeStuff"); // append some safe content
		b62604.replace(b62604.length()-"Chars".length(),b62604.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62604 = new java.util.HashMap<String,Object>();
		map62604.put("key62604", b62604.toString()); // put in a collection
		String c62604 = (String)map62604.get("key62604"); // get it back out
		String d62604 = c62604.substring(0,c62604.length()-1); // extract most of it
		String e62604 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62604.getBytes() ) )); // B64 encode and decode it
		String f62604 = e62604.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f62604); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
