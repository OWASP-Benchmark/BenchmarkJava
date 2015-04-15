package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19993")
public class BenchmarkTest19993 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map90882 = new java.util.HashMap<String,Object>();
		map90882.put("keyA-90882", "a_Value"); // put some stuff in the collection
		map90882.put("keyB-90882", param.toString()); // put it in a collection
		map90882.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map90882.get("keyB-90882"); // get it back out
		bar = (String)map90882.get("keyA-90882"); // get safe value back out
	
		return bar;	
	}
}
