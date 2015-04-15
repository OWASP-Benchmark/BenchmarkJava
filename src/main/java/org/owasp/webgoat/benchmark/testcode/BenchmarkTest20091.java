package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20091")
public class BenchmarkTest20091 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map87148 = new java.util.HashMap<String,Object>();
		map87148.put("keyA-87148", "a_Value"); // put some stuff in the collection
		map87148.put("keyB-87148", param.toString()); // put it in a collection
		map87148.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map87148.get("keyB-87148"); // get it back out
		bar = (String)map87148.get("keyA-87148"); // get safe value back out
	
		return bar;	
	}
}
