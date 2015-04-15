package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03244")
public class BenchmarkTest03244 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map18433 = new java.util.HashMap<String,Object>();
		map18433.put("keyA-18433", "a_Value"); // put some stuff in the collection
		map18433.put("keyB-18433", param.toString()); // put it in a collection
		map18433.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map18433.get("keyB-18433"); // get it back out
		bar = (String)map18433.get("keyA-18433"); // get safe value back out
		
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}
}
