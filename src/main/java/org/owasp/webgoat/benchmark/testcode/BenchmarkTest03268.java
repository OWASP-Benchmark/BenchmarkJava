package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03268")
public class BenchmarkTest03268 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map15697 = new java.util.HashMap<String,Object>();
		map15697.put("keyA-15697", "a_Value"); // put some stuff in the collection
		map15697.put("keyB-15697", param.toString()); // put it in a collection
		map15697.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map15697.get("keyB-15697"); // get it back out
		bar = (String)map15697.get("keyA-15697"); // get safe value back out
		
		
		response.addHeader("SomeHeader", bar);
	}
}
