package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01159")
public class BenchmarkTest01159 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map18671 = new java.util.HashMap<String,Object>();
		map18671.put("keyA-18671", "a_Value"); // put some stuff in the collection
		map18671.put("keyB-18671", param.toString()); // put it in a collection
		map18671.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map18671.get("keyB-18671"); // get it back out
		bar = (String)map18671.get("keyA-18671"); // get safe value back out
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
