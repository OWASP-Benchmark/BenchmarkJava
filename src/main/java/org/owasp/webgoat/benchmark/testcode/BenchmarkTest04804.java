package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04804")
public class BenchmarkTest04804 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map23846 = new java.util.HashMap<String,Object>();
		map23846.put("keyA-23846", "a_Value"); // put some stuff in the collection
		map23846.put("keyB-23846", param.toString()); // put it in a collection
		map23846.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map23846.get("keyB-23846"); // get it back out
		bar = (String)map23846.get("keyA-23846"); // get safe value back out
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}
}
