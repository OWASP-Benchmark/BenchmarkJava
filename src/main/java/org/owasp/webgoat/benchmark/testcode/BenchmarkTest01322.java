package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01322")
public class BenchmarkTest01322 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map86619 = new java.util.HashMap<String,Object>();
		map86619.put("keyA-86619", "a_Value"); // put some stuff in the collection
		map86619.put("keyB-86619", param.toString()); // put it in a collection
		map86619.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map86619.get("keyB-86619"); // get it back out
		bar = (String)map86619.get("keyA-86619"); // get safe value back out
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}
}
