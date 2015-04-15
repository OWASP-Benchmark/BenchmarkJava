package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03743")
public class BenchmarkTest03743 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map43101 = new java.util.HashMap<String,Object>();
		map43101.put("keyA-43101", "a Value"); // put some stuff in the collection
		map43101.put("keyB-43101", param.toString()); // put it in a collection
		map43101.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map43101.get("keyB-43101"); // get it back out
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
