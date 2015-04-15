package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06040")
public class BenchmarkTest06040 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map50352 = new java.util.HashMap<String,Object>();
		map50352.put("keyA-50352", "a_Value"); // put some stuff in the collection
		map50352.put("keyB-50352", param.toString()); // put it in a collection
		map50352.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map50352.get("keyB-50352"); // get it back out
		bar = (String)map50352.get("keyA-50352"); // get safe value back out
		
		
		java.io.File file = new java.io.File(bar);
	}
}
