package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05154")
public class BenchmarkTest05154 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map40070 = new java.util.HashMap<String,Object>();
		map40070.put("keyA-40070", "a Value"); // put some stuff in the collection
		map40070.put("keyB-40070", param.toString()); // put it in a collection
		map40070.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map40070.get("keyB-40070"); // get it back out
		
		
		response.getWriter().write(bar);
	}
}
