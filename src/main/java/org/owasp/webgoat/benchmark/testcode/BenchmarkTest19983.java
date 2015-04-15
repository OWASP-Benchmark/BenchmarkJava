package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19983")
public class BenchmarkTest19983 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map72817 = new java.util.HashMap<String,Object>();
		map72817.put("keyA-72817", "a_Value"); // put some stuff in the collection
		map72817.put("keyB-72817", param.toString()); // put it in a collection
		map72817.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map72817.get("keyB-72817"); // get it back out
		bar = (String)map72817.get("keyA-72817"); // get safe value back out
	
		return bar;	
	}
}
