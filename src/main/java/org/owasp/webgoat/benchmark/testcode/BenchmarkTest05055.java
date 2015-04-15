package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05055")
public class BenchmarkTest05055 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map16896 = new java.util.HashMap<String,Object>();
		map16896.put("keyA-16896", "a_Value"); // put some stuff in the collection
		map16896.put("keyB-16896", param.toString()); // put it in a collection
		map16896.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map16896.get("keyB-16896"); // get it back out
		bar = (String)map16896.get("keyA-16896"); // get safe value back out
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
