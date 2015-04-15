package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06153")
public class BenchmarkTest06153 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map42953 = new java.util.HashMap<String,Object>();
		map42953.put("keyA-42953", "a_Value"); // put some stuff in the collection
		map42953.put("keyB-42953", param.toString()); // put it in a collection
		map42953.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map42953.get("keyB-42953"); // get it back out
		bar = (String)map42953.get("keyA-42953"); // get safe value back out
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}
}
