package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20047")
public class BenchmarkTest20047 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map81219 = new java.util.HashMap<String,Object>();
		map81219.put("keyA-81219", "a_Value"); // put some stuff in the collection
		map81219.put("keyB-81219", param.toString()); // put it in a collection
		map81219.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map81219.get("keyB-81219"); // get it back out
		bar = (String)map81219.get("keyA-81219"); // get safe value back out
	
		return bar;	
	}
}
