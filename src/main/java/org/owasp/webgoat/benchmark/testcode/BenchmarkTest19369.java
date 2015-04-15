package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19369")
public class BenchmarkTest19369 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map63335 = new java.util.HashMap<String,Object>();
		map63335.put("keyA-63335", "a_Value"); // put some stuff in the collection
		map63335.put("keyB-63335", param.toString()); // put it in a collection
		map63335.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map63335.get("keyB-63335"); // get it back out
		bar = (String)map63335.get("keyA-63335"); // get safe value back out
	
		return bar;	
	}
}
