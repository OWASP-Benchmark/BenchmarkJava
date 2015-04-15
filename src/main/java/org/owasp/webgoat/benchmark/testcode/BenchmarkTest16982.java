package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16982")
public class BenchmarkTest16982 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map58933 = new java.util.HashMap<String,Object>();
		map58933.put("keyA-58933", "a_Value"); // put some stuff in the collection
		map58933.put("keyB-58933", param.toString()); // put it in a collection
		map58933.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map58933.get("keyB-58933"); // get it back out
		bar = (String)map58933.get("keyA-58933"); // get safe value back out
	
		return bar;	
	}
}
