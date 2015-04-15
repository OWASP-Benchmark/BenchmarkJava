package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01883")
public class BenchmarkTest01883 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map97809 = new java.util.HashMap<String,Object>();
		map97809.put("keyA-97809", "a Value"); // put some stuff in the collection
		map97809.put("keyB-97809", param.toString()); // put it in a collection
		map97809.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map97809.get("keyB-97809"); // get it back out
		
		
		response.getWriter().write(bar);
	}
}
