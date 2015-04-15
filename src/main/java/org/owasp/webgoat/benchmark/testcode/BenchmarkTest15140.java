package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15140")
public class BenchmarkTest15140 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map13612 = new java.util.HashMap<String,Object>();
		map13612.put("keyA-13612", "a_Value"); // put some stuff in the collection
		map13612.put("keyB-13612", param.toString()); // put it in a collection
		map13612.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map13612.get("keyB-13612"); // get it back out
		bar = (String)map13612.get("keyA-13612"); // get safe value back out
	
		return bar;	
	}
}
