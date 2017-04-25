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

@WebServlet(value="/cmdi-01/BenchmarkTest01608")
public class BenchmarkTest01608 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String[] values = request.getParameterValues("BenchmarkTest01608");
		String param;
		if (values != null && values.length > 0)
		  param = values[0];
		else param = "";

		String bar = new Test().doSomething(request, param);
		
		String cmd = org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(this.getClass().getClassLoader());
		String[] args = {cmd};
        String[] argsEnv = { bar };
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(args, argsEnv, new java.io.File(System.getProperty("user.dir")));
			org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
			response.getWriter().println(
			  org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage())
			);
			return;
		}
	}  // end doPost

	
    private class Test {

        public String doSomething(HttpServletRequest request, String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map55872 = new java.util.HashMap<String,Object>();
		map55872.put("keyA-55872", "a_Value"); // put some stuff in the collection
		map55872.put("keyB-55872", param); // put it in a collection
		map55872.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map55872.get("keyB-55872"); // get it back out
		bar = (String)map55872.get("keyA-55872"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
