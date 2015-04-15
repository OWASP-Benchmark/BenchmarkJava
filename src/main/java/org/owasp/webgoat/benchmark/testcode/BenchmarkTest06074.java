package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06074")
public class BenchmarkTest06074 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map87332 = new java.util.HashMap<String,Object>();
		map87332.put("keyA-87332", "a_Value"); // put some stuff in the collection
		map87332.put("keyB-87332", param.toString()); // put it in a collection
		map87332.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map87332.get("keyB-87332"); // get it back out
		bar = (String)map87332.get("keyA-87332"); // get safe value back out
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}
}
