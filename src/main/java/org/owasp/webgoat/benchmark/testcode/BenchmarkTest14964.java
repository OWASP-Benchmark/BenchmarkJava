package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14964")
public class BenchmarkTest14964 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map54290 = new java.util.HashMap<String,Object>();
		map54290.put("keyA-54290", "a Value"); // put some stuff in the collection
		map54290.put("keyB-54290", param.toString()); // put it in a collection
		map54290.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map54290.get("keyB-54290"); // get it back out
	
		return bar;	
	}
}
