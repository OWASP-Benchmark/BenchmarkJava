package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04765")
public class BenchmarkTest04765 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map74914 = new java.util.HashMap<String,Object>();
		map74914.put("keyA-74914", "a_Value"); // put some stuff in the collection
		map74914.put("keyB-74914", param.toString()); // put it in a collection
		map74914.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map74914.get("keyB-74914"); // get it back out
		bar = (String)map74914.get("keyA-74914"); // get safe value back out
		
		
		java.io.File file = new java.io.File(bar);
	}
}
