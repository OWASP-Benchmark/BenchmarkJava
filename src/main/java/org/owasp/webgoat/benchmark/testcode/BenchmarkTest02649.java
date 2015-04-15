package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02649")
public class BenchmarkTest02649 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map15498 = new java.util.HashMap<String,Object>();
		map15498.put("keyA-15498", "a_Value"); // put some stuff in the collection
		map15498.put("keyB-15498", param.toString()); // put it in a collection
		map15498.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map15498.get("keyB-15498"); // get it back out
		bar = (String)map15498.get("keyA-15498"); // get safe value back out
		
		
		response.setHeader(bar, "SomeValue");
	}
}
