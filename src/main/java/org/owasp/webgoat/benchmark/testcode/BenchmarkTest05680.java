package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05680")
public class BenchmarkTest05680 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map23194 = new java.util.HashMap<String,Object>();
		map23194.put("keyA-23194", "a Value"); // put some stuff in the collection
		map23194.put("keyB-23194", param.toString()); // put it in a collection
		map23194.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map23194.get("keyB-23194"); // get it back out
		
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}
}
