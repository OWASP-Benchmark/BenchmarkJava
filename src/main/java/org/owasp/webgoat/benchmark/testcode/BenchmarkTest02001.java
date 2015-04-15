package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02001")
public class BenchmarkTest02001 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map58746 = new java.util.HashMap<String,Object>();
		map58746.put("keyA-58746", "a_Value"); // put some stuff in the collection
		map58746.put("keyB-58746", param.toString()); // put it in a collection
		map58746.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map58746.get("keyB-58746"); // get it back out
		bar = (String)map58746.get("keyA-58746"); // get safe value back out
		
		
		response.addHeader(bar, "SomeValue");
	}
}
