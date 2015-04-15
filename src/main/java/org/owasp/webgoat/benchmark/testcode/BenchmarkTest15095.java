package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15095")
public class BenchmarkTest15095 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map67679 = new java.util.HashMap<String,Object>();
		map67679.put("keyA-67679", "a_Value"); // put some stuff in the collection
		map67679.put("keyB-67679", param.toString()); // put it in a collection
		map67679.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map67679.get("keyB-67679"); // get it back out
		bar = (String)map67679.get("keyA-67679"); // get safe value back out
	
		return bar;	
	}
}
