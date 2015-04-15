package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20553")
public class BenchmarkTest20553 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		response.getWriter().print(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map25009 = new java.util.HashMap<String,Object>();
		map25009.put("keyA-25009", "a_Value"); // put some stuff in the collection
		map25009.put("keyB-25009", param.toString()); // put it in a collection
		map25009.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map25009.get("keyB-25009"); // get it back out
		bar = (String)map25009.get("keyA-25009"); // get safe value back out
	
		return bar;	
	}
}
