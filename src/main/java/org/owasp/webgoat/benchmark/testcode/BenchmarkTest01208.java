package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01208")
public class BenchmarkTest01208 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map34733 = new java.util.HashMap<String,Object>();
		map34733.put("keyA-34733", "a Value"); // put some stuff in the collection
		map34733.put("keyB-34733", param.toString()); // put it in a collection
		map34733.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map34733.get("keyB-34733"); // get it back out
		
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}
}
