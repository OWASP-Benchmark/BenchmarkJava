package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06951")
public class BenchmarkTest06951 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map70056 = new java.util.HashMap<String,Object>();
		map70056.put("keyA-70056", "a_Value"); // put some stuff in the collection
		map70056.put("keyB-70056", param.toString()); // put it in a collection
		map70056.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map70056.get("keyB-70056"); // get it back out
		bar = (String)map70056.get("keyA-70056"); // get safe value back out
		
		
		response.addHeader("SomeHeader", bar);
	}
}
