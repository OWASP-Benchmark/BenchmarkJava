package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05435")
public class BenchmarkTest05435 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map66955 = new java.util.HashMap<String,Object>();
		map66955.put("keyA-66955", "a_Value"); // put some stuff in the collection
		map66955.put("keyB-66955", param.toString()); // put it in a collection
		map66955.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map66955.get("keyB-66955"); // get it back out
		bar = (String)map66955.get("keyA-66955"); // get safe value back out
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
