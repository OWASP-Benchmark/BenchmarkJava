package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01868")
public class BenchmarkTest01868 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map84870 = new java.util.HashMap<String,Object>();
		map84870.put("keyA-84870", "a_Value"); // put some stuff in the collection
		map84870.put("keyB-84870", param.toString()); // put it in a collection
		map84870.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map84870.get("keyB-84870"); // get it back out
		bar = (String)map84870.get("keyA-84870"); // get safe value back out
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
