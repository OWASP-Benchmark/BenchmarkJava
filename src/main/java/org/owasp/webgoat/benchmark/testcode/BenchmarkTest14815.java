package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14815")
public class BenchmarkTest14815 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map91458 = new java.util.HashMap<String,Object>();
		map91458.put("keyA-91458", "a_Value"); // put some stuff in the collection
		map91458.put("keyB-91458", param.toString()); // put it in a collection
		map91458.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map91458.get("keyB-91458"); // get it back out
		bar = (String)map91458.get("keyA-91458"); // get safe value back out
	
		return bar;	
	}
}
