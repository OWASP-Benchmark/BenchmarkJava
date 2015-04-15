package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00731")
public class BenchmarkTest00731 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map49743 = new java.util.HashMap<String,Object>();
		map49743.put("keyA-49743", "a_Value"); // put some stuff in the collection
		map49743.put("keyB-49743", param.toString()); // put it in a collection
		map49743.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map49743.get("keyB-49743"); // get it back out
		bar = (String)map49743.get("keyA-49743"); // get safe value back out
		
		
		response.addHeader(bar, "SomeValue");
	}
}
