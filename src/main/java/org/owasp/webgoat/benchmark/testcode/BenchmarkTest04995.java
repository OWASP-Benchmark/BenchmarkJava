package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04995")
public class BenchmarkTest04995 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map91566 = new java.util.HashMap<String,Object>();
		map91566.put("keyA-91566", "a_Value"); // put some stuff in the collection
		map91566.put("keyB-91566", param.toString()); // put it in a collection
		map91566.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map91566.get("keyB-91566"); // get it back out
		bar = (String)map91566.get("keyA-91566"); // get safe value back out
		
		
		response.getWriter().println(bar);
	}
}
