package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16651")
public class BenchmarkTest16651 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map96396 = new java.util.HashMap<String,Object>();
		map96396.put("keyA-96396", "a_Value"); // put some stuff in the collection
		map96396.put("keyB-96396", param.toString()); // put it in a collection
		map96396.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map96396.get("keyB-96396"); // get it back out
		bar = (String)map96396.get("keyA-96396"); // get safe value back out
	
		return bar;	
	}
}
