package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03285")
public class BenchmarkTest03285 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map57559 = new java.util.HashMap<String,Object>();
		map57559.put("keyA-57559", "a Value"); // put some stuff in the collection
		map57559.put("keyB-57559", param.toString()); // put it in a collection
		map57559.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map57559.get("keyB-57559"); // get it back out
		
		
		response.setHeader(bar, "SomeValue");
	}
}
