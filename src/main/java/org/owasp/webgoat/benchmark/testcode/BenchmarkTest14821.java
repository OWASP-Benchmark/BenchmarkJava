package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14821")
public class BenchmarkTest14821 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map66521 = new java.util.HashMap<String,Object>();
		map66521.put("keyA-66521", "a_Value"); // put some stuff in the collection
		map66521.put("keyB-66521", param.toString()); // put it in a collection
		map66521.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map66521.get("keyB-66521"); // get it back out
		bar = (String)map66521.get("keyA-66521"); // get safe value back out
	
		return bar;	
	}
}
