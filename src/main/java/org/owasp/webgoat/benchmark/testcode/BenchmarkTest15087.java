package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15087")
public class BenchmarkTest15087 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map57280 = new java.util.HashMap<String,Object>();
		map57280.put("keyA-57280", "a_Value"); // put some stuff in the collection
		map57280.put("keyB-57280", param.toString()); // put it in a collection
		map57280.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map57280.get("keyB-57280"); // get it back out
		bar = (String)map57280.get("keyA-57280"); // get safe value back out
	
		return bar;	
	}
}
