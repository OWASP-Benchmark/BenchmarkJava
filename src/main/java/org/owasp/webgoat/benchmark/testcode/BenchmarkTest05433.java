package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05433")
public class BenchmarkTest05433 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map84100 = new java.util.HashMap<String,Object>();
		map84100.put("keyA-84100", "a Value"); // put some stuff in the collection
		map84100.put("keyB-84100", param.toString()); // put it in a collection
		map84100.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map84100.get("keyB-84100"); // get it back out
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
