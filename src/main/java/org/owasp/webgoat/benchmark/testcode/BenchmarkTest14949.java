package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14949")
public class BenchmarkTest14949 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map35139 = new java.util.HashMap<String,Object>();
		map35139.put("keyA-35139", "a_Value"); // put some stuff in the collection
		map35139.put("keyB-35139", param.toString()); // put it in a collection
		map35139.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map35139.get("keyB-35139"); // get it back out
		bar = (String)map35139.get("keyA-35139"); // get safe value back out
	
		return bar;	
	}
}
