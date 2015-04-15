package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02991")
public class BenchmarkTest02991 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map37610 = new java.util.HashMap<String,Object>();
		map37610.put("keyA-37610", "a_Value"); // put some stuff in the collection
		map37610.put("keyB-37610", param.toString()); // put it in a collection
		map37610.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map37610.get("keyB-37610"); // get it back out
		bar = (String)map37610.get("keyA-37610"); // get safe value back out
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}
}
