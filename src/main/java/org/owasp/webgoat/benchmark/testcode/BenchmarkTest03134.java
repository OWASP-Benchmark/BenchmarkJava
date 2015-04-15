package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03134")
public class BenchmarkTest03134 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map93372 = new java.util.HashMap<String,Object>();
		map93372.put("keyA-93372", "a_Value"); // put some stuff in the collection
		map93372.put("keyB-93372", param.toString()); // put it in a collection
		map93372.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map93372.get("keyB-93372"); // get it back out
		bar = (String)map93372.get("keyA-93372"); // get safe value back out
		
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar.toCharArray(),0,length - 1);
		}
	}
}
