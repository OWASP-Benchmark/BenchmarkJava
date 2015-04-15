package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06705")
public class BenchmarkTest06705 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map41161 = new java.util.HashMap<String,Object>();
		map41161.put("keyA-41161", "a_Value"); // put some stuff in the collection
		map41161.put("keyB-41161", param.toString()); // put it in a collection
		map41161.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map41161.get("keyB-41161"); // get it back out
		bar = (String)map41161.get("keyA-41161"); // get safe value back out
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}
}
