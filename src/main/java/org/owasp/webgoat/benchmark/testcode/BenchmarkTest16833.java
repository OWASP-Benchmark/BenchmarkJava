package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16833")
public class BenchmarkTest16833 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map86711 = new java.util.HashMap<String,Object>();
		map86711.put("keyA-86711", "a_Value"); // put some stuff in the collection
		map86711.put("keyB-86711", param.toString()); // put it in a collection
		map86711.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map86711.get("keyB-86711"); // get it back out
		bar = (String)map86711.get("keyA-86711"); // get safe value back out
	
		return bar;	
	}
}
