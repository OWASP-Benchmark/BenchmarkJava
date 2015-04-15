package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14844")
public class BenchmarkTest14844 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map4749 = new java.util.HashMap<String,Object>();
		map4749.put("keyA-4749", "a_Value"); // put some stuff in the collection
		map4749.put("keyB-4749", param.toString()); // put it in a collection
		map4749.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map4749.get("keyB-4749"); // get it back out
		bar = (String)map4749.get("keyA-4749"); // get safe value back out
	
		return bar;	
	}
}
