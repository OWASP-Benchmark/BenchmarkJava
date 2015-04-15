package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05583")
public class BenchmarkTest05583 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map47173 = new java.util.HashMap<String,Object>();
		map47173.put("keyA-47173", "a_Value"); // put some stuff in the collection
		map47173.put("keyB-47173", param.toString()); // put it in a collection
		map47173.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map47173.get("keyB-47173"); // get it back out
		bar = (String)map47173.get("keyA-47173"); // get safe value back out
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}
}
