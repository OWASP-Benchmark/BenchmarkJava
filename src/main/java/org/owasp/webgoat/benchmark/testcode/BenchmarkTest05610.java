package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05610")
public class BenchmarkTest05610 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map5154 = new java.util.HashMap<String,Object>();
		map5154.put("keyA-5154", "a Value"); // put some stuff in the collection
		map5154.put("keyB-5154", param.toString()); // put it in a collection
		map5154.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map5154.get("keyB-5154"); // get it back out
		
		
		response.getWriter().println(bar);
	}
}
