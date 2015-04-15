package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01865")
public class BenchmarkTest01865 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map8752 = new java.util.HashMap<String,Object>();
		map8752.put("keyA-8752", "a Value"); // put some stuff in the collection
		map8752.put("keyB-8752", param.toString()); // put it in a collection
		map8752.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map8752.get("keyB-8752"); // get it back out
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
