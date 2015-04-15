package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17009")
public class BenchmarkTest17009 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map52533 = new java.util.HashMap<String,Object>();
		map52533.put("keyA-52533", "a_Value"); // put some stuff in the collection
		map52533.put("keyB-52533", param.toString()); // put it in a collection
		map52533.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map52533.get("keyB-52533"); // get it back out
		bar = (String)map52533.get("keyA-52533"); // get safe value back out
	
		return bar;	
	}
}
