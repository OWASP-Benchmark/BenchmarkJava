package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14901")
public class BenchmarkTest14901 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map13553 = new java.util.HashMap<String,Object>();
		map13553.put("keyA-13553", "a_Value"); // put some stuff in the collection
		map13553.put("keyB-13553", param.toString()); // put it in a collection
		map13553.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map13553.get("keyB-13553"); // get it back out
		bar = (String)map13553.get("keyA-13553"); // get safe value back out
	
		return bar;	
	}
}
