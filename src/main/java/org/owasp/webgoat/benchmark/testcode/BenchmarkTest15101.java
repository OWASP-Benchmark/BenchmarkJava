package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15101")
public class BenchmarkTest15101 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map50633 = new java.util.HashMap<String,Object>();
		map50633.put("keyA-50633", "a_Value"); // put some stuff in the collection
		map50633.put("keyB-50633", param.toString()); // put it in a collection
		map50633.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map50633.get("keyB-50633"); // get it back out
		bar = (String)map50633.get("keyA-50633"); // get safe value back out
	
		return bar;	
	}
}
