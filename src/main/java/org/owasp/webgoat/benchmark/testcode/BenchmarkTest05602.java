package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05602")
public class BenchmarkTest05602 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map3692 = new java.util.HashMap<String,Object>();
		map3692.put("keyA-3692", "a_Value"); // put some stuff in the collection
		map3692.put("keyB-3692", param.toString()); // put it in a collection
		map3692.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map3692.get("keyB-3692"); // get it back out
		bar = (String)map3692.get("keyA-3692"); // get safe value back out
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
