package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15066")
public class BenchmarkTest15066 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map80935 = new java.util.HashMap<String,Object>();
		map80935.put("keyA-80935", "a_Value"); // put some stuff in the collection
		map80935.put("keyB-80935", param.toString()); // put it in a collection
		map80935.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map80935.get("keyB-80935"); // get it back out
		bar = (String)map80935.get("keyA-80935"); // get safe value back out
	
		return bar;	
	}
}
