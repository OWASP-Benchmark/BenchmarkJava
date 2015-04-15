package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02316")
public class BenchmarkTest02316 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map61409 = new java.util.HashMap<String,Object>();
		map61409.put("keyA-61409", "a Value"); // put some stuff in the collection
		map61409.put("keyB-61409", param.toString()); // put it in a collection
		map61409.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map61409.get("keyB-61409"); // get it back out
		
		
		java.io.File file = new java.io.File(bar);
	}
}
