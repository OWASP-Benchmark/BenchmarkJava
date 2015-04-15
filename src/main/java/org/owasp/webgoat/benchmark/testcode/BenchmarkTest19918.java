package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19918")
public class BenchmarkTest19918 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map13178 = new java.util.HashMap<String,Object>();
		map13178.put("keyA-13178", "a_Value"); // put some stuff in the collection
		map13178.put("keyB-13178", param.toString()); // put it in a collection
		map13178.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map13178.get("keyB-13178"); // get it back out
		bar = (String)map13178.get("keyA-13178"); // get safe value back out
	
		return bar;	
	}
}
