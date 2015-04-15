package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06367")
public class BenchmarkTest06367 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map49954 = new java.util.HashMap<String,Object>();
		map49954.put("keyA-49954", "a Value"); // put some stuff in the collection
		map49954.put("keyB-49954", param.toString()); // put it in a collection
		map49954.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map49954.get("keyB-49954"); // get it back out
		
		
		response.setHeader("SomeHeader", bar);
	}
}
