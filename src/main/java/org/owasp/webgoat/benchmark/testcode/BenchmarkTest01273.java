package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01273")
public class BenchmarkTest01273 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map88151 = new java.util.HashMap<String,Object>();
		map88151.put("keyA-88151", "a_Value"); // put some stuff in the collection
		map88151.put("keyB-88151", param.toString()); // put it in a collection
		map88151.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map88151.get("keyB-88151"); // get it back out
		bar = (String)map88151.get("keyA-88151"); // get safe value back out
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
