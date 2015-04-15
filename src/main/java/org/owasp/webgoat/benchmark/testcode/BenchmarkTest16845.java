package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16845")
public class BenchmarkTest16845 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map66524 = new java.util.HashMap<String,Object>();
		map66524.put("keyA-66524", "a Value"); // put some stuff in the collection
		map66524.put("keyB-66524", param.toString()); // put it in a collection
		map66524.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map66524.get("keyB-66524"); // get it back out
	
		return bar;	
	}
}
