package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02933")
public class BenchmarkTest02933 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map19994 = new java.util.HashMap<String,Object>();
		map19994.put("keyA-19994", "a Value"); // put some stuff in the collection
		map19994.put("keyB-19994", param.toString()); // put it in a collection
		map19994.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map19994.get("keyB-19994"); // get it back out
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
