package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02970")
public class BenchmarkTest02970 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map15825 = new java.util.HashMap<String,Object>();
		map15825.put("keyA-15825", "a_Value"); // put some stuff in the collection
		map15825.put("keyB-15825", param.toString()); // put it in a collection
		map15825.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map15825.get("keyB-15825"); // get it back out
		bar = (String)map15825.get("keyA-15825"); // get safe value back out
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}
}
