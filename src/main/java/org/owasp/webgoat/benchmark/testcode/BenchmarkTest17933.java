package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17933")
public class BenchmarkTest17933 extends HttpServlet {
	
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
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map81089 = new java.util.HashMap<String,Object>();
		map81089.put("keyA-81089", "a_Value"); // put some stuff in the collection
		map81089.put("keyB-81089", param.toString()); // put it in a collection
		map81089.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map81089.get("keyB-81089"); // get it back out
		bar = (String)map81089.get("keyA-81089"); // get safe value back out
	
		return bar;	
	}
}
