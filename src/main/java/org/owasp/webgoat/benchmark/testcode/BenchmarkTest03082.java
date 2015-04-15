package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03082")
public class BenchmarkTest03082 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map914 = new java.util.HashMap<String,Object>();
		map914.put("keyA-914", "a Value"); // put some stuff in the collection
		map914.put("keyB-914", param.toString()); // put it in a collection
		map914.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map914.get("keyB-914"); // get it back out
		
		
		response.getWriter().print(bar);
	}
}
