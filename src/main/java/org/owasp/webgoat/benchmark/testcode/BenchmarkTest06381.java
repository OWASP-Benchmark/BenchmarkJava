package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06381")
public class BenchmarkTest06381 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map59167 = new java.util.HashMap<String,Object>();
		map59167.put("keyA-59167", "a_Value"); // put some stuff in the collection
		map59167.put("keyB-59167", param.toString()); // put it in a collection
		map59167.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map59167.get("keyB-59167"); // get it back out
		bar = (String)map59167.get("keyA-59167"); // get safe value back out
		
		
		response.getWriter().write(bar);
	}
}
