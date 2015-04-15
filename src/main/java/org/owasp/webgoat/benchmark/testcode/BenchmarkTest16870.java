package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16870")
public class BenchmarkTest16870 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map94171 = new java.util.HashMap<String,Object>();
		map94171.put("keyA-94171", "a_Value"); // put some stuff in the collection
		map94171.put("keyB-94171", param.toString()); // put it in a collection
		map94171.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map94171.get("keyB-94171"); // get it back out
		bar = (String)map94171.get("keyA-94171"); // get safe value back out
	
		return bar;	
	}
}
