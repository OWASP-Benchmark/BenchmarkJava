package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17005")
public class BenchmarkTest17005 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map92463 = new java.util.HashMap<String,Object>();
		map92463.put("keyA-92463", "a Value"); // put some stuff in the collection
		map92463.put("keyB-92463", param.toString()); // put it in a collection
		map92463.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map92463.get("keyB-92463"); // get it back out
	
		return bar;	
	}
}
