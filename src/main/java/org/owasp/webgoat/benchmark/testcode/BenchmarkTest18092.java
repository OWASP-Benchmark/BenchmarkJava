package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18092")
public class BenchmarkTest18092 extends HttpServlet {
	
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
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map68350 = new java.util.HashMap<String,Object>();
		map68350.put("keyA-68350", "a Value"); // put some stuff in the collection
		map68350.put("keyB-68350", param.toString()); // put it in a collection
		map68350.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map68350.get("keyB-68350"); // get it back out
	
		return bar;	
	}
}
