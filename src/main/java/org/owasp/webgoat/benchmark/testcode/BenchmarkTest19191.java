package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19191")
public class BenchmarkTest19191 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map52343 = new java.util.HashMap<String,Object>();
		map52343.put("keyA-52343", "a_Value"); // put some stuff in the collection
		map52343.put("keyB-52343", param.toString()); // put it in a collection
		map52343.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map52343.get("keyB-52343"); // get it back out
		bar = (String)map52343.get("keyA-52343"); // get safe value back out
	
		return bar;	
	}
}
