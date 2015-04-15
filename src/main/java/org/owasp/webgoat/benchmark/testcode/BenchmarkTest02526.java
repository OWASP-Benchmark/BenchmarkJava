package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02526")
public class BenchmarkTest02526 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map20207 = new java.util.HashMap<String,Object>();
		map20207.put("keyA-20207", "a_Value"); // put some stuff in the collection
		map20207.put("keyB-20207", param.toString()); // put it in a collection
		map20207.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map20207.get("keyB-20207"); // get it back out
		bar = (String)map20207.get("keyA-20207"); // get safe value back out
		
		
		response.getWriter().write(bar);
	}
}
