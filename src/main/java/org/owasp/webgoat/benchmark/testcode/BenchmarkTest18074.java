package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18074")
public class BenchmarkTest18074 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		response.getWriter().print(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map61096 = new java.util.HashMap<String,Object>();
		map61096.put("keyA-61096", "a_Value"); // put some stuff in the collection
		map61096.put("keyB-61096", param.toString()); // put it in a collection
		map61096.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map61096.get("keyB-61096"); // get it back out
		bar = (String)map61096.get("keyA-61096"); // get safe value back out
	
		return bar;	
	}
}
