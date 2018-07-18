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

@WebServlet(value="/securecookie-00/BenchmarkTest01062")
public class BenchmarkTest01062 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		if (request.getHeader("BenchmarkTest01062") != null) {
			param = request.getHeader("BenchmarkTest01062");
		}
		
		// URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
		param = java.net.URLDecoder.decode(param, "UTF-8");

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
//		cookie.setPath("/benchmark/" + this.getClass().getSimpleName());
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

		String bar = "";
		if (param != null) {
			bar = new String( org.apache.commons.codec.binary.Base64.decodeBase64(
			org.apache.commons.codec.binary.Base64.encodeBase64( param.getBytes() ) ));
		}

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
