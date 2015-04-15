package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15769")
public class BenchmarkTest15769 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map43777 = new java.util.HashMap<String,Object>();
		map43777.put("keyA-43777", "a_Value"); // put some stuff in the collection
		map43777.put("keyB-43777", param.toString()); // put it in a collection
		map43777.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map43777.get("keyB-43777"); // get it back out
		bar = (String)map43777.get("keyA-43777"); // get safe value back out
	
		return bar;	
	}
}
