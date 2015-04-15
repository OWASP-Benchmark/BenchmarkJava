package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05712")
public class BenchmarkTest05712 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map55188 = new java.util.HashMap<String,Object>();
		map55188.put("keyA-55188", "a_Value"); // put some stuff in the collection
		map55188.put("keyB-55188", param.toString()); // put it in a collection
		map55188.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map55188.get("keyB-55188"); // get it back out
		bar = (String)map55188.get("keyA-55188"); // get safe value back out
		
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}
}
