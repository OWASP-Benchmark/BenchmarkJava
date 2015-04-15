package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01361")
public class BenchmarkTest01361 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map67326 = new java.util.HashMap<String,Object>();
		map67326.put("keyA-67326", "a_Value"); // put some stuff in the collection
		map67326.put("keyB-67326", param.toString()); // put it in a collection
		map67326.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map67326.get("keyB-67326"); // get it back out
		bar = (String)map67326.get("keyA-67326"); // get safe value back out
		
		
		response.getWriter().write(bar);
	}
}
