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
* @author Nick Sanidas
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/xss-00/BenchmarkTest00468")
public class BenchmarkTest00468 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			String[] values = map.get("BenchmarkTest00468");
			if (values != null) param = values[0];
		}
		
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map50379 = new java.util.HashMap<String,Object>();
		map50379.put("keyA-50379", "a_Value"); // put some stuff in the collection
		map50379.put("keyB-50379", param); // put it in a collection
		map50379.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map50379.get("keyB-50379"); // get it back out
		bar = (String)map50379.get("keyA-50379"); // get safe value back out
		
		
response.setHeader("X-XSS-Protection", "0");
		Object[] obj = { "a", "b" };
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}
	
}
