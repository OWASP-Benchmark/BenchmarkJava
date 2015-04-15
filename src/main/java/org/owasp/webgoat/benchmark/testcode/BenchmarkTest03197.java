package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03197")
public class BenchmarkTest03197 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map69876 = new java.util.HashMap<String,Object>();
		map69876.put("keyA-69876", "a_Value"); // put some stuff in the collection
		map69876.put("keyB-69876", param.toString()); // put it in a collection
		map69876.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map69876.get("keyB-69876"); // get it back out
		bar = (String)map69876.get("keyA-69876"); // get safe value back out
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
