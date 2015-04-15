package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06120")
public class BenchmarkTest06120 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map43156 = new java.util.HashMap<String,Object>();
		map43156.put("keyA-43156", "a Value"); // put some stuff in the collection
		map43156.put("keyB-43156", param.toString()); // put it in a collection
		map43156.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map43156.get("keyB-43156"); // get it back out
		
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}
}
