package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19528")
public class BenchmarkTest19528 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map30503 = new java.util.HashMap<String,Object>();
		map30503.put("keyA-30503", "a_Value"); // put some stuff in the collection
		map30503.put("keyB-30503", param.toString()); // put it in a collection
		map30503.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map30503.get("keyB-30503"); // get it back out
		bar = (String)map30503.get("keyA-30503"); // get safe value back out
	
		return bar;	
	}
}
