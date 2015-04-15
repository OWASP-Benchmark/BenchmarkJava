package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04762")
public class BenchmarkTest04762 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map43327 = new java.util.HashMap<String,Object>();
		map43327.put("keyA-43327", "a Value"); // put some stuff in the collection
		map43327.put("keyB-43327", param.toString()); // put it in a collection
		map43327.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map43327.get("keyB-43327"); // get it back out
		
		
		java.io.File file = new java.io.File(bar);
	}
}
