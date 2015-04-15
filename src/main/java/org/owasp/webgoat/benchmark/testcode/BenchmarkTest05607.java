package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05607")
public class BenchmarkTest05607 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map15187 = new java.util.HashMap<String,Object>();
		map15187.put("keyA-15187", "a_Value"); // put some stuff in the collection
		map15187.put("keyB-15187", param.toString()); // put it in a collection
		map15187.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map15187.get("keyB-15187"); // get it back out
		bar = (String)map15187.get("keyA-15187"); // get safe value back out
		
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}
}
