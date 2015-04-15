package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01995")
public class BenchmarkTest01995 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map79458 = new java.util.HashMap<String,Object>();
		map79458.put("keyA-79458", "a Value"); // put some stuff in the collection
		map79458.put("keyB-79458", param.toString()); // put it in a collection
		map79458.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map79458.get("keyB-79458"); // get it back out
		
		
		response.addHeader("SomeHeader", bar);
	}
}
