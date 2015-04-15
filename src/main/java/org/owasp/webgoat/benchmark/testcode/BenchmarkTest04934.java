package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04934")
public class BenchmarkTest04934 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map31538 = new java.util.HashMap<String,Object>();
		map31538.put("keyA-31538", "a_Value"); // put some stuff in the collection
		map31538.put("keyB-31538", param.toString()); // put it in a collection
		map31538.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map31538.get("keyB-31538"); // get it back out
		bar = (String)map31538.get("keyA-31538"); // get safe value back out
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
