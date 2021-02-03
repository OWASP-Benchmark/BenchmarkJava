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

@WebServlet(value="/securecookie-00/BenchmarkTest01523")
public class BenchmarkTest01523 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("BenchmarkTest01523");
		if (param == null) param = "";

		String bar = new Test().doSomething(request, param);
		
		byte[] input = new byte[1000];
		String str = "?";
		Object inputParam = param;
		if (inputParam instanceof String) str = ((String) inputParam);
		if (inputParam instanceof java.io.InputStream) {
			int i = ((java.io.InputStream) inputParam).read(input);
			if (i == -1) {
				response.getWriter().println(
				"This input source requires a POST, not a GET. Incompatible UI for the InputStream source."
				);
				return;
			}			
			str = new String(input, 0, i);
		}
		if ("".equals(str)) str="No cookie value supplied";
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie", str);
		
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
		cookie.setPath(request.getRequestURI()); // i.e., set path to JUST this servlet
												 // e.g., /benchmark/sql-01/BenchmarkTest01001
		response.addCookie(cookie);

		response.getWriter().println(
			"Created cookie: 'SomeCookie': with value: '"
			+ org.owasp.esapi.ESAPI.encoder().encodeForHTML(str) + "' and secure flag set to: true"
		);
	}  // end doPost

	
    private class Test {

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a94015 = param; //assign
		StringBuilder b94015 = new StringBuilder(a94015);  // stick in stringbuilder
		b94015.append(" SafeStuff"); // append some safe content
		b94015.replace(b94015.length()-"Chars".length(),b94015.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94015 = new java.util.HashMap<String,Object>();
		map94015.put("key94015", b94015.toString()); // put in a collection
		String c94015 = (String)map94015.get("key94015"); // get it back out
		String d94015 = c94015.substring(0,c94015.length()-1); // extract most of it
		String e94015 = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
		    org.apache.commons.codec.binary.Base64.encodeBase64( d94015.getBytes() ) )); // B64 encode and decode it
		String f94015 = e94015.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f94015); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
