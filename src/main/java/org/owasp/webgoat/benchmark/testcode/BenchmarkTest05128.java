package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05128")
public class BenchmarkTest05128 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map19124 = new java.util.HashMap<String,Object>();
		map19124.put("keyA-19124", "a_Value"); // put some stuff in the collection
		map19124.put("keyB-19124", param.toString()); // put it in a collection
		map19124.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map19124.get("keyB-19124"); // get it back out
		bar = (String)map19124.get("keyA-19124"); // get safe value back out
		
		
		response.addHeader("SomeHeader", bar);
	}
}
