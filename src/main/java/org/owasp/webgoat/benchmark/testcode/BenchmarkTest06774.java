package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06774")
public class BenchmarkTest06774 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map6373 = new java.util.HashMap<String,Object>();
		map6373.put("keyA-6373", "a Value"); // put some stuff in the collection
		map6373.put("keyB-6373", param.toString()); // put it in a collection
		map6373.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map6373.get("keyB-6373"); // get it back out
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
