package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03202")
public class BenchmarkTest03202 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map44676 = new java.util.HashMap<String,Object>();
		map44676.put("keyA-44676", "a_Value"); // put some stuff in the collection
		map44676.put("keyB-44676", param.toString()); // put it in a collection
		map44676.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map44676.get("keyB-44676"); // get it back out
		bar = (String)map44676.get("keyA-44676"); // get safe value back out
		
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}
}
