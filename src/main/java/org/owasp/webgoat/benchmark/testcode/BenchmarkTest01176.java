package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01176")
public class BenchmarkTest01176 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map89206 = new java.util.HashMap<String,Object>();
		map89206.put("keyA-89206", "a_Value"); // put some stuff in the collection
		map89206.put("keyB-89206", param.toString()); // put it in a collection
		map89206.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map89206.get("keyB-89206"); // get it back out
		bar = (String)map89206.get("keyA-89206"); // get safe value back out
		
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}
}
