/**
* OWASP Benchmark Project v1.2
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

@WebServlet(value="/xss-03/BenchmarkTest01771")
public class BenchmarkTest01771 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("BenchmarkTest01771");

		String bar = new Test().doSomething(request, param);
		
response.setHeader("X-XSS-Protection", "0");
		response.getWriter().println(bar);
	}  // end doPost

	
    private class Test {

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a58724 = param; //assign
		StringBuilder b58724 = new StringBuilder(a58724);  // stick in stringbuilder
		b58724.append(" SafeStuff"); // append some safe content
		b58724.replace(b58724.length()-"Chars".length(),b58724.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58724 = new java.util.HashMap<String,Object>();
		map58724.put("key58724", b58724.toString()); // put in a collection
		String c58724 = (String)map58724.get("key58724"); // get it back out
		String d58724 = c58724.substring(0,c58724.length()-1); // extract most of it
		String e58724 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d58724.getBytes() ) )); // B64 encode and decode it
		String f58724 = e58724.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f58724); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
