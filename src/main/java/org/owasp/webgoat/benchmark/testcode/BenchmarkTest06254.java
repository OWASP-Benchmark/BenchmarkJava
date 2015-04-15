package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06254")
public class BenchmarkTest06254 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map31847 = new java.util.HashMap<String,Object>();
		map31847.put("keyA-31847", "a Value"); // put some stuff in the collection
		map31847.put("keyB-31847", param.toString()); // put it in a collection
		map31847.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map31847.get("keyB-31847"); // get it back out
		
		
		response.getWriter().write(bar);
	}
}
