package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02635")
public class BenchmarkTest02635 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map13611 = new java.util.HashMap<String,Object>();
		map13611.put("keyA-13611", "a_Value"); // put some stuff in the collection
		map13611.put("keyB-13611", param.toString()); // put it in a collection
		map13611.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map13611.get("keyB-13611"); // get it back out
		bar = (String)map13611.get("keyA-13611"); // get safe value back out
		
		
		response.addHeader(bar, "SomeValue");
	}
}
