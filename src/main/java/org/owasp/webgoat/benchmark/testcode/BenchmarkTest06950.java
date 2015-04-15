package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06950")
public class BenchmarkTest06950 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map4851 = new java.util.HashMap<String,Object>();
		map4851.put("keyA-4851", "a Value"); // put some stuff in the collection
		map4851.put("keyB-4851", param.toString()); // put it in a collection
		map4851.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map4851.get("keyB-4851"); // get it back out
		
		
		response.addHeader("SomeHeader", bar);
	}
}
