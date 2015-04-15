package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03760")
public class BenchmarkTest03760 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map9846 = new java.util.HashMap<String,Object>();
		map9846.put("keyA-9846", "a_Value"); // put some stuff in the collection
		map9846.put("keyB-9846", param.toString()); // put it in a collection
		map9846.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map9846.get("keyB-9846"); // get it back out
		bar = (String)map9846.get("keyA-9846"); // get safe value back out
		
		
		response.getWriter().println(bar);
	}
}
