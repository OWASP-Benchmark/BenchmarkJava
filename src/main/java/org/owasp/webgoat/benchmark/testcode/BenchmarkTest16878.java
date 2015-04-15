package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16878")
public class BenchmarkTest16878 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map29014 = new java.util.HashMap<String,Object>();
		map29014.put("keyA-29014", "a_Value"); // put some stuff in the collection
		map29014.put("keyB-29014", param.toString()); // put it in a collection
		map29014.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map29014.get("keyB-29014"); // get it back out
		bar = (String)map29014.get("keyA-29014"); // get safe value back out
	
		return bar;	
	}
}
