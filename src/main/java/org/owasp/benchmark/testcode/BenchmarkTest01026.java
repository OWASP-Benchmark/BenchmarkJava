/**
* OWASP Benchmark Project v1.2
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Dave Wichers
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/pathtraver-01/BenchmarkTest01026")
public class BenchmarkTest01026 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		if (request.getHeader("BenchmarkTest01026") != null) {
			param = request.getHeader("BenchmarkTest01026");
		}
		
		// URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
		param = java.net.URLDecoder.decode(param, "UTF-8");

		String bar = new Test().doSomething(request, param);
		
		java.io.File fileTarget = new java.io.File(bar);
		response.getWriter().println(
"Access to file: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileTarget.toString()) + "' created." 
);
		if (fileTarget.exists()) {
			response.getWriter().println(
" And file already exists."
);
		} else { response.getWriter().println(
" But file doesn't exist yet."
); }
	}  // end doPost

	
    private class Test {

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a11433 = param; //assign
		StringBuilder b11433 = new StringBuilder(a11433);  // stick in stringbuilder
		b11433.append(" SafeStuff"); // append some safe content
		b11433.replace(b11433.length()-"Chars".length(),b11433.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11433 = new java.util.HashMap<String,Object>();
		map11433.put("key11433", b11433.toString()); // put in a collection
		String c11433 = (String)map11433.get("key11433"); // get it back out
		String d11433 = c11433.substring(0,c11433.length()-1); // extract most of it
		String e11433 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d11433.getBytes() ) )); // B64 encode and decode it
		String f11433 = e11433.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g11433 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g11433); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
