package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00590")
public class BenchmarkTest00590 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map47036 = new java.util.HashMap<String,Object>();
		map47036.put("keyA-47036", "a_Value"); // put some stuff in the collection
		map47036.put("keyB-47036", param.toString()); // put it in a collection
		map47036.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map47036.get("keyB-47036"); // get it back out
		bar = (String)map47036.get("keyA-47036"); // get safe value back out
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
