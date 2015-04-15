package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02643")
public class BenchmarkTest02643 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map23232 = new java.util.HashMap<String,Object>();
		map23232.put("keyA-23232", "a_Value"); // put some stuff in the collection
		map23232.put("keyB-23232", param.toString()); // put it in a collection
		map23232.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map23232.get("keyB-23232"); // get it back out
		bar = (String)map23232.get("keyA-23232"); // get safe value back out
		
		
		response.setHeader("SomeHeader", bar);
	}
}
