package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01448")
public class BenchmarkTest01448 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map41554 = new java.util.HashMap<String,Object>();
		map41554.put("keyA-41554", "a Value"); // put some stuff in the collection
		map41554.put("keyB-41554", param.toString()); // put it in a collection
		map41554.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map41554.get("keyB-41554"); // get it back out
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}
}
