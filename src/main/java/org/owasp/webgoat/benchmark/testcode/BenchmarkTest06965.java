package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06965")
public class BenchmarkTest06965 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map35574 = new java.util.HashMap<String,Object>();
		map35574.put("keyA-35574", "a_Value"); // put some stuff in the collection
		map35574.put("keyB-35574", param.toString()); // put it in a collection
		map35574.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map35574.get("keyB-35574"); // get it back out
		bar = (String)map35574.get("keyA-35574"); // get safe value back out
		
		
		response.setHeader("SomeHeader", bar);
	}
}
