package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06644")
public class BenchmarkTest06644 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map26580 = new java.util.HashMap<String,Object>();
		map26580.put("keyA-26580", "a_Value"); // put some stuff in the collection
		map26580.put("keyB-26580", param.toString()); // put it in a collection
		map26580.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map26580.get("keyB-26580"); // get it back out
		bar = (String)map26580.get("keyA-26580"); // get safe value back out
		
		
		java.io.File file = new java.io.File(bar);
	}
}
