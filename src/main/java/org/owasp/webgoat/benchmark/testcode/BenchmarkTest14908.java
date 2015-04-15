package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14908")
public class BenchmarkTest14908 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map44850 = new java.util.HashMap<String,Object>();
		map44850.put("keyA-44850", "a_Value"); // put some stuff in the collection
		map44850.put("keyB-44850", param.toString()); // put it in a collection
		map44850.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map44850.get("keyB-44850"); // get it back out
		bar = (String)map44850.get("keyA-44850"); // get safe value back out
	
		return bar;	
	}
}
