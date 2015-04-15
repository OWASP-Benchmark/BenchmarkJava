package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18269")
public class BenchmarkTest18269 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map82722 = new java.util.HashMap<String,Object>();
		map82722.put("keyA-82722", "a_Value"); // put some stuff in the collection
		map82722.put("keyB-82722", param.toString()); // put it in a collection
		map82722.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map82722.get("keyB-82722"); // get it back out
		bar = (String)map82722.get("keyA-82722"); // get safe value back out
	
		return bar;	
	}
}
