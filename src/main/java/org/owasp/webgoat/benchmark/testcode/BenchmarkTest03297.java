package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03297")
public class BenchmarkTest03297 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map93486 = new java.util.HashMap<String,Object>();
		map93486.put("keyA-93486", "a_Value"); // put some stuff in the collection
		map93486.put("keyB-93486", param.toString()); // put it in a collection
		map93486.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map93486.get("keyB-93486"); // get it back out
		bar = (String)map93486.get("keyA-93486"); // get safe value back out
		
		
		response.getWriter().write(bar);
	}
}
