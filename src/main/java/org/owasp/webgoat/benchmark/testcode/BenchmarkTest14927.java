package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14927")
public class BenchmarkTest14927 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map14465 = new java.util.HashMap<String,Object>();
		map14465.put("keyA-14465", "a Value"); // put some stuff in the collection
		map14465.put("keyB-14465", param.toString()); // put it in a collection
		map14465.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map14465.get("keyB-14465"); // get it back out
	
		return bar;	
	}
}
