package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04173")
public class BenchmarkTest04173 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map60681 = new java.util.HashMap<String,Object>();
		map60681.put("keyA-60681", "a_Value"); // put some stuff in the collection
		map60681.put("keyB-60681", param.toString()); // put it in a collection
		map60681.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map60681.get("keyB-60681"); // get it back out
		bar = (String)map60681.get("keyA-60681"); // get safe value back out
		
		
		java.io.File file = new java.io.File(bar);
	}
}
