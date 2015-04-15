package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01359")
public class BenchmarkTest01359 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map55058 = new java.util.HashMap<String,Object>();
		map55058.put("keyA-55058", "a Value"); // put some stuff in the collection
		map55058.put("keyB-55058", param.toString()); // put it in a collection
		map55058.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map55058.get("keyB-55058"); // get it back out
		
		
		response.getWriter().write(bar);
	}
}
