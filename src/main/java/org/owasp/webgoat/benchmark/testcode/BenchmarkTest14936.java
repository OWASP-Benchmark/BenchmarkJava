package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14936")
public class BenchmarkTest14936 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.getWriter().print(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map31523 = new java.util.HashMap<String,Object>();
		map31523.put("keyA-31523", "a_Value"); // put some stuff in the collection
		map31523.put("keyB-31523", param.toString()); // put it in a collection
		map31523.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map31523.get("keyB-31523"); // get it back out
		bar = (String)map31523.get("keyA-31523"); // get safe value back out
	
		return bar;	
	}
}
