package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03230")
public class BenchmarkTest03230 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map47294 = new java.util.HashMap<String,Object>();
		map47294.put("keyA-47294", "a_Value"); // put some stuff in the collection
		map47294.put("keyB-47294", param.toString()); // put it in a collection
		map47294.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map47294.get("keyB-47294"); // get it back out
		bar = (String)map47294.get("keyA-47294"); // get safe value back out
		
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}
}
