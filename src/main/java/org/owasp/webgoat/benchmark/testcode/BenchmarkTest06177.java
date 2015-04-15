package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06177")
public class BenchmarkTest06177 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map56218 = new java.util.HashMap<String,Object>();
		map56218.put("keyA-56218", "a_Value"); // put some stuff in the collection
		map56218.put("keyB-56218", param.toString()); // put it in a collection
		map56218.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map56218.get("keyB-56218"); // get it back out
		bar = (String)map56218.get("keyA-56218"); // get safe value back out
		
		
		response.getWriter().print(bar.toCharArray());
	}
}
