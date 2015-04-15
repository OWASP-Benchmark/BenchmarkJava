package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01795")
public class BenchmarkTest01795 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map11618 = new java.util.HashMap<String,Object>();
		map11618.put("keyA-11618", "a Value"); // put some stuff in the collection
		map11618.put("keyB-11618", param.toString()); // put it in a collection
		map11618.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map11618.get("keyB-11618"); // get it back out
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
