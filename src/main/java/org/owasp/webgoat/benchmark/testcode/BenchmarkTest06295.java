package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06295")
public class BenchmarkTest06295 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map75444 = new java.util.HashMap<String,Object>();
		map75444.put("keyA-75444", "a_Value"); // put some stuff in the collection
		map75444.put("keyB-75444", param.toString()); // put it in a collection
		map75444.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map75444.get("keyB-75444"); // get it back out
		bar = (String)map75444.get("keyA-75444"); // get safe value back out
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
