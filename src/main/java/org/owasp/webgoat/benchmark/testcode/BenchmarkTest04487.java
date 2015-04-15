package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04487")
public class BenchmarkTest04487 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map6032 = new java.util.HashMap<String,Object>();
		map6032.put("keyA-6032", "a Value"); // put some stuff in the collection
		map6032.put("keyB-6032", param.toString()); // put it in a collection
		map6032.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map6032.get("keyB-6032"); // get it back out
		
		
		response.getWriter().write(bar);
	}
}
