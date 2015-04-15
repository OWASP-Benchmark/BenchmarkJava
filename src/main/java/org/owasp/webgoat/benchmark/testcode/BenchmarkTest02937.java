package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02937")
public class BenchmarkTest02937 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map50248 = new java.util.HashMap<String,Object>();
		map50248.put("keyA-50248", "a_Value"); // put some stuff in the collection
		map50248.put("keyB-50248", param.toString()); // put it in a collection
		map50248.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map50248.get("keyB-50248"); // get it back out
		bar = (String)map50248.get("keyA-50248"); // get safe value back out
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
