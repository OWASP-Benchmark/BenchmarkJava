package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02312")
public class BenchmarkTest02312 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map40999 = new java.util.HashMap<String,Object>();
		map40999.put("keyA-40999", "a_Value"); // put some stuff in the collection
		map40999.put("keyB-40999", param.toString()); // put it in a collection
		map40999.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map40999.get("keyB-40999"); // get it back out
		bar = (String)map40999.get("keyA-40999"); // get safe value back out
		
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}
}
