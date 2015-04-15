package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03108")
public class BenchmarkTest03108 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map6128 = new java.util.HashMap<String,Object>();
		map6128.put("keyA-6128", "a_Value"); // put some stuff in the collection
		map6128.put("keyB-6128", param.toString()); // put it in a collection
		map6128.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map6128.get("keyB-6128"); // get it back out
		bar = (String)map6128.get("keyA-6128"); // get safe value back out
		
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}
}
