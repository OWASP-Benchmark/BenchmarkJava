package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15785")
public class BenchmarkTest15785 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map75765 = new java.util.HashMap<String,Object>();
		map75765.put("keyA-75765", "a_Value"); // put some stuff in the collection
		map75765.put("keyB-75765", param.toString()); // put it in a collection
		map75765.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map75765.get("keyB-75765"); // get it back out
		bar = (String)map75765.get("keyA-75765"); // get safe value back out
	
		return bar;	
	}
}
