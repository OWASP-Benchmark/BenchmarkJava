package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01672")
public class BenchmarkTest01672 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map26566 = new java.util.HashMap<String,Object>();
		map26566.put("keyA-26566", "a Value"); // put some stuff in the collection
		map26566.put("keyB-26566", param.toString()); // put it in a collection
		map26566.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map26566.get("keyB-26566"); // get it back out
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
