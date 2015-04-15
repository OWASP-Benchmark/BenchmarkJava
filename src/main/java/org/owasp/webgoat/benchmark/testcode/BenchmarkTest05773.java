package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05773")
public class BenchmarkTest05773 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map30424 = new java.util.HashMap<String,Object>();
		map30424.put("keyA-30424", "a Value"); // put some stuff in the collection
		map30424.put("keyB-30424", param.toString()); // put it in a collection
		map30424.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map30424.get("keyB-30424"); // get it back out
		
		
		response.getWriter().write(bar);
	}
}
