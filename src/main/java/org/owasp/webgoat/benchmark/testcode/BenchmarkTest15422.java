package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15422")
public class BenchmarkTest15422 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map97945 = new java.util.HashMap<String,Object>();
		map97945.put("keyA-97945", "a_Value"); // put some stuff in the collection
		map97945.put("keyB-97945", param.toString()); // put it in a collection
		map97945.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map97945.get("keyB-97945"); // get it back out
		bar = (String)map97945.get("keyA-97945"); // get safe value back out
	
		return bar;	
	}
}
