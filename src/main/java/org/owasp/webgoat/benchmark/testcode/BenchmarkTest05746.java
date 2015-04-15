package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05746")
public class BenchmarkTest05746 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map52063 = new java.util.HashMap<String,Object>();
		map52063.put("keyA-52063", "a_Value"); // put some stuff in the collection
		map52063.put("keyB-52063", param.toString()); // put it in a collection
		map52063.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map52063.get("keyB-52063"); // get it back out
		bar = (String)map52063.get("keyA-52063"); // get safe value back out
		
		
		response.addHeader("SomeHeader", bar);
	}
}
