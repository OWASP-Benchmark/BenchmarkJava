package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05633")
public class BenchmarkTest05633 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map85290 = new java.util.HashMap<String,Object>();
		map85290.put("keyA-85290", "a Value"); // put some stuff in the collection
		map85290.put("keyB-85290", param.toString()); // put it in a collection
		map85290.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map85290.get("keyB-85290"); // get it back out
		
		
		response.getWriter().write(bar);
	}
}
