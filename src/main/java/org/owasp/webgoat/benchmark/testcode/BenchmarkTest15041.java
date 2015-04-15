package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15041")
public class BenchmarkTest15041 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map56351 = new java.util.HashMap<String,Object>();
		map56351.put("keyA-56351", "a_Value"); // put some stuff in the collection
		map56351.put("keyB-56351", param.toString()); // put it in a collection
		map56351.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map56351.get("keyB-56351"); // get it back out
		bar = (String)map56351.get("keyA-56351"); // get safe value back out
	
		return bar;	
	}
}
