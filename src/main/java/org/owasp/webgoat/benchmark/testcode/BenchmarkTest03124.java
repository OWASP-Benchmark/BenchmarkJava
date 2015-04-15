package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03124")
public class BenchmarkTest03124 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map73027 = new java.util.HashMap<String,Object>();
		map73027.put("keyA-73027", "a_Value"); // put some stuff in the collection
		map73027.put("keyB-73027", param.toString()); // put it in a collection
		map73027.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map73027.get("keyB-73027"); // get it back out
		bar = (String)map73027.get("keyA-73027"); // get safe value back out
		
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}
}
