package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03122")
public class BenchmarkTest03122 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map49937 = new java.util.HashMap<String,Object>();
		map49937.put("keyA-49937", "a_Value"); // put some stuff in the collection
		map49937.put("keyB-49937", param.toString()); // put it in a collection
		map49937.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map49937.get("keyB-49937"); // get it back out
		bar = (String)map49937.get("keyA-49937"); // get safe value back out
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
