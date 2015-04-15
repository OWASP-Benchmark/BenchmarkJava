package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19308")
public class BenchmarkTest19308 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map58586 = new java.util.HashMap<String,Object>();
		map58586.put("keyA-58586", "a_Value"); // put some stuff in the collection
		map58586.put("keyB-58586", param.toString()); // put it in a collection
		map58586.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map58586.get("keyB-58586"); // get it back out
		bar = (String)map58586.get("keyA-58586"); // get safe value back out
	
		return bar;	
	}
}
