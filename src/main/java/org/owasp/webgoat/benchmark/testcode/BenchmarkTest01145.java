package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01145")
public class BenchmarkTest01145 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map26110 = new java.util.HashMap<String,Object>();
		map26110.put("keyA-26110", "a_Value"); // put some stuff in the collection
		map26110.put("keyB-26110", param.toString()); // put it in a collection
		map26110.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map26110.get("keyB-26110"); // get it back out
		bar = (String)map26110.get("keyA-26110"); // get safe value back out
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
