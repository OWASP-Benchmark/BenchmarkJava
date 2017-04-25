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
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/xss-00/BenchmarkTest00145")
public class BenchmarkTest00145 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = "";
		if (request.getHeader("Referer") != null) {
			param = request.getHeader("Referer");
		}
		
		// URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
		param = java.net.URLDecoder.decode(param, "UTF-8");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map17589 = new java.util.HashMap<String,Object>();
		map17589.put("keyA-17589", "a-Value"); // put some stuff in the collection
		map17589.put("keyB-17589", param); // put it in a collection
		map17589.put("keyC", "another-Value"); // put some stuff in the collection
		bar = (String)map17589.get("keyB-17589"); // get it back out
		
		
response.setHeader("X-XSS-Protection", "0");
		Object[] obj = { "a", "b" };
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}
	
}
