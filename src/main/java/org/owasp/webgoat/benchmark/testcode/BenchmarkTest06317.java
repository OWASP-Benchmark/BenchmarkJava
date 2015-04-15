package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06317")
public class BenchmarkTest06317 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map87903 = new java.util.HashMap<String,Object>();
		map87903.put("keyA-87903", "a_Value"); // put some stuff in the collection
		map87903.put("keyB-87903", param.toString()); // put it in a collection
		map87903.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map87903.get("keyB-87903"); // get it back out
		bar = (String)map87903.get("keyA-87903"); // get safe value back out
		
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}
}
