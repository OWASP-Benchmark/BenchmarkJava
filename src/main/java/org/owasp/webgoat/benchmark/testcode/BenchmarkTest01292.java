package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01292")
public class BenchmarkTest01292 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map3929 = new java.util.HashMap<String,Object>();
		map3929.put("keyA-3929", "a_Value"); // put some stuff in the collection
		map3929.put("keyB-3929", param.toString()); // put it in a collection
		map3929.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map3929.get("keyB-3929"); // get it back out
		bar = (String)map3929.get("keyA-3929"); // get safe value back out
		
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}
}
