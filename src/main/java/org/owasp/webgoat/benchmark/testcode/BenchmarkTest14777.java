package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14777")
public class BenchmarkTest14777 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map24369 = new java.util.HashMap<String,Object>();
		map24369.put("keyA-24369", "a_Value"); // put some stuff in the collection
		map24369.put("keyB-24369", param.toString()); // put it in a collection
		map24369.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map24369.get("keyB-24369"); // get it back out
		bar = (String)map24369.get("keyA-24369"); // get safe value back out
	
		return bar;	
	}
}
