package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04773")
public class BenchmarkTest04773 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map64937 = new java.util.HashMap<String,Object>();
		map64937.put("keyA-64937", "a Value"); // put some stuff in the collection
		map64937.put("keyB-64937", param.toString()); // put it in a collection
		map64937.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map64937.get("keyB-64937"); // get it back out
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
