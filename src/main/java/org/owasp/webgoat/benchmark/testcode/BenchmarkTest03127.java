package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03127")
public class BenchmarkTest03127 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map35871 = new java.util.HashMap<String,Object>();
		map35871.put("keyA-35871", "a Value"); // put some stuff in the collection
		map35871.put("keyB-35871", param.toString()); // put it in a collection
		map35871.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map35871.get("keyB-35871"); // get it back out
		
		
		response.getWriter().println(bar);
	}
}
