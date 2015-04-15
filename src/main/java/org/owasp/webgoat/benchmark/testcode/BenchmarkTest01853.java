package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01853")
public class BenchmarkTest01853 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map32726 = new java.util.HashMap<String,Object>();
		map32726.put("keyA-32726", "a Value"); // put some stuff in the collection
		map32726.put("keyB-32726", param.toString()); // put it in a collection
		map32726.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map32726.get("keyB-32726"); // get it back out
		
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}
}
