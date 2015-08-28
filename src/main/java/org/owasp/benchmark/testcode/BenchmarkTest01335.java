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

@WebServlet("/BenchmarkTest01335")
public class BenchmarkTest01335 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			String[] values = map.get("vector");
			if (values != null) param = values[0];
		}
		

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar };
		java.io.PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE html>\n<html>\n<body>\n<p>");
		out.format(java.util.Locale.US,"Formatted like: %1$s and %2$s.",obj);
	    out.write("\n</p>\n</body>\n</html>");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map52702 = new java.util.HashMap<String,Object>();
		map52702.put("keyA-52702", "a Value"); // put some stuff in the collection
		map52702.put("keyB-52702", param); // put it in a collection
		map52702.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map52702.get("keyB-52702"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
