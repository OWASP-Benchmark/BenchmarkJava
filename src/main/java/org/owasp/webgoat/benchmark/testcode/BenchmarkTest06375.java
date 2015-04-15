package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06375")
public class BenchmarkTest06375 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map35428 = new java.util.HashMap<String,Object>();
		map35428.put("keyA-35428", "a_Value"); // put some stuff in the collection
		map35428.put("keyB-35428", param.toString()); // put it in a collection
		map35428.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map35428.get("keyB-35428"); // get it back out
		bar = (String)map35428.get("keyA-35428"); // get safe value back out
		
		
		response.setHeader(bar, "SomeValue");
	}
}
