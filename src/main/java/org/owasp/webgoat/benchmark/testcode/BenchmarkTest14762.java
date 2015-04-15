package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14762")
public class BenchmarkTest14762 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map57088 = new java.util.HashMap<String,Object>();
		map57088.put("keyA-57088", "a_Value"); // put some stuff in the collection
		map57088.put("keyB-57088", param.toString()); // put it in a collection
		map57088.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map57088.get("keyB-57088"); // get it back out
		bar = (String)map57088.get("keyA-57088"); // get safe value back out
	
		return bar;	
	}
}
