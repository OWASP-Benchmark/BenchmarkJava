package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01287")
public class BenchmarkTest01287 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map74021 = new java.util.HashMap<String,Object>();
		map74021.put("keyA-74021", "a_Value"); // put some stuff in the collection
		map74021.put("keyB-74021", param.toString()); // put it in a collection
		map74021.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map74021.get("keyB-74021"); // get it back out
		bar = (String)map74021.get("keyA-74021"); // get safe value back out
		
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}
}
