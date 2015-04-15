package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16992")
public class BenchmarkTest16992 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map94120 = new java.util.HashMap<String,Object>();
		map94120.put("keyA-94120", "a_Value"); // put some stuff in the collection
		map94120.put("keyB-94120", param.toString()); // put it in a collection
		map94120.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map94120.get("keyB-94120"); // get it back out
		bar = (String)map94120.get("keyA-94120"); // get safe value back out
	
		return bar;	
	}
}
