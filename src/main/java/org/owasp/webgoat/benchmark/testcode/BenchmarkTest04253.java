package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04253")
public class BenchmarkTest04253 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map64330 = new java.util.HashMap<String,Object>();
		map64330.put("keyA-64330", "a Value"); // put some stuff in the collection
		map64330.put("keyB-64330", param.toString()); // put it in a collection
		map64330.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map64330.get("keyB-64330"); // get it back out
		
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}
}
