package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03275")
public class BenchmarkTest03275 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map43815 = new java.util.HashMap<String,Object>();
		map43815.put("keyA-43815", "a_Value"); // put some stuff in the collection
		map43815.put("keyB-43815", param.toString()); // put it in a collection
		map43815.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map43815.get("keyB-43815"); // get it back out
		bar = (String)map43815.get("keyA-43815"); // get safe value back out
		
		
		response.addHeader(bar, "SomeValue");
	}
}
