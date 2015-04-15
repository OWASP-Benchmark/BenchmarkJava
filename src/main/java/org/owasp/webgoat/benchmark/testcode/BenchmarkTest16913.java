package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16913")
public class BenchmarkTest16913 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map44613 = new java.util.HashMap<String,Object>();
		map44613.put("keyA-44613", "a_Value"); // put some stuff in the collection
		map44613.put("keyB-44613", param.toString()); // put it in a collection
		map44613.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map44613.get("keyB-44613"); // get it back out
		bar = (String)map44613.get("keyA-44613"); // get safe value back out
	
		return bar;	
	}
}
