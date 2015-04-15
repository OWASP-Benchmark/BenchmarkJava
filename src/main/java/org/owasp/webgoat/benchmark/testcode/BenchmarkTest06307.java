package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06307")
public class BenchmarkTest06307 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map20618 = new java.util.HashMap<String,Object>();
		map20618.put("keyA-20618", "a_Value"); // put some stuff in the collection
		map20618.put("keyB-20618", param.toString()); // put it in a collection
		map20618.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map20618.get("keyB-20618"); // get it back out
		bar = (String)map20618.get("keyA-20618"); // get safe value back out
		
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}
}
