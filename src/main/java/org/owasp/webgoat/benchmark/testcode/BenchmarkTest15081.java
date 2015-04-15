package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15081")
public class BenchmarkTest15081 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map38857 = new java.util.HashMap<String,Object>();
		map38857.put("keyA-38857", "a_Value"); // put some stuff in the collection
		map38857.put("keyB-38857", param.toString()); // put it in a collection
		map38857.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map38857.get("keyB-38857"); // get it back out
		bar = (String)map38857.get("keyA-38857"); // get safe value back out
	
		return bar;	
	}
}
