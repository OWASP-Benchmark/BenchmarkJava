package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01152")
public class BenchmarkTest01152 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map87507 = new java.util.HashMap<String,Object>();
		map87507.put("keyA-87507", "a_Value"); // put some stuff in the collection
		map87507.put("keyB-87507", param.toString()); // put it in a collection
		map87507.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map87507.get("keyB-87507"); // get it back out
		bar = (String)map87507.get("keyA-87507"); // get safe value back out
		
		
		response.getWriter().print(bar.toCharArray());
	}
}
