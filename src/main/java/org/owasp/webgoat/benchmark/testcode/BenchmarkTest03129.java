package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03129")
public class BenchmarkTest03129 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map67357 = new java.util.HashMap<String,Object>();
		map67357.put("keyA-67357", "a_Value"); // put some stuff in the collection
		map67357.put("keyB-67357", param.toString()); // put it in a collection
		map67357.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map67357.get("keyB-67357"); // get it back out
		bar = (String)map67357.get("keyA-67357"); // get safe value back out
		
		
		response.getWriter().println(bar);
	}
}
