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

@WebServlet("/BenchmarkTest01134")
public class BenchmarkTest01134 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = "";
		boolean flag = true;
		java.util.Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements() && flag) {
			String name = (String) names.nextElement();
			java.util.Enumeration<String> values = request.getHeaders(name);
			if (values != null) {
				while (values.hasMoreElements() && flag) {
					String value = (String) values.nextElement();
					if (value.equals("vector")) {
						param = name;
						flag = false;
					}
				}
			}
		}

		String bar = new Test().doSomething(param);
		
		byte[] input = new byte[1000];
		String str = "?";
		Object inputParam = param;
		if (inputParam instanceof String) str = ((String) inputParam);
		if (inputParam instanceof java.io.InputStream) {
			int i = ((java.io.InputStream) inputParam).read(input);
			if (i == -1) {
				response.getWriter().println("This input source requires a POST, not a GET. Incompatible UI for the InputStream source.");
				return;
			}			
			str = new String(input, 0, i);
		}
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie", str);
		
		cookie.setSecure(false);
		cookie.setPath("/benchmark/" + this.getClass().getSimpleName());
		
		response.addCookie(cookie);

        response.getWriter().println("Created cookie: 'SomeCookie': with value: '"
          + org.owasp.esapi.ESAPI.encoder().encodeForHTML(str) + "' and secure flag set to: false");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map7506 = new java.util.HashMap<String,Object>();
		map7506.put("keyA-7506", "a Value"); // put some stuff in the collection
		map7506.put("keyB-7506", param); // put it in a collection
		map7506.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map7506.get("keyB-7506"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
