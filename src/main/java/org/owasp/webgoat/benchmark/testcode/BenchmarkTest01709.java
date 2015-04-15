package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01709")
public class BenchmarkTest01709 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map35450 = new java.util.HashMap<String,Object>();
		map35450.put("keyA-35450", "a_Value"); // put some stuff in the collection
		map35450.put("keyB-35450", param.toString()); // put it in a collection
		map35450.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map35450.get("keyB-35450"); // get it back out
		bar = (String)map35450.get("keyA-35450"); // get safe value back out
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}
}
