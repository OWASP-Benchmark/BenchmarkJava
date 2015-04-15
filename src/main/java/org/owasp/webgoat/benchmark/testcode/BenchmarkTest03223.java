package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03223")
public class BenchmarkTest03223 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map41695 = new java.util.HashMap<String,Object>();
		map41695.put("keyA-41695", "a_Value"); // put some stuff in the collection
		map41695.put("keyB-41695", param.toString()); // put it in a collection
		map41695.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map41695.get("keyB-41695"); // get it back out
		bar = (String)map41695.get("keyA-41695"); // get safe value back out
		
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}
}
