package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05768")
public class BenchmarkTest05768 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map59714 = new java.util.HashMap<String,Object>();
		map59714.put("keyA-59714", "a_Value"); // put some stuff in the collection
		map59714.put("keyB-59714", param.toString()); // put it in a collection
		map59714.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map59714.get("keyB-59714"); // get it back out
		bar = (String)map59714.get("keyA-59714"); // get safe value back out
		
		
		response.setHeader(bar, "SomeValue");
	}
}
