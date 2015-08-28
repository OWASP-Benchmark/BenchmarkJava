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

@WebServlet("/BenchmarkTest00886")
public class BenchmarkTest00886 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("vector");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map70278 = new java.util.HashMap<String,Object>();
		map70278.put("keyA-70278", "a_Value"); // put some stuff in the collection
		map70278.put("keyB-70278", param); // put it in a collection
		map70278.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map70278.get("keyB-70278"); // get it back out
		bar = (String)map70278.get("keyA-70278"); // get safe value back out
		
		
		Object[] obj = { bar, "b"};
		response.getWriter().printf("Formatted like: %1$s and %2$s.",obj);
	}
}
