package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19312")
public class BenchmarkTest19312 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map47519 = new java.util.HashMap<String,Object>();
		map47519.put("keyA-47519", "a_Value"); // put some stuff in the collection
		map47519.put("keyB-47519", param.toString()); // put it in a collection
		map47519.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map47519.get("keyB-47519"); // get it back out
		bar = (String)map47519.get("keyA-47519"); // get safe value back out
	
		return bar;	
	}
}
