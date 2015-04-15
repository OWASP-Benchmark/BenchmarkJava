package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06209")
public class BenchmarkTest06209 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map3376 = new java.util.HashMap<String,Object>();
		map3376.put("keyA-3376", "a_Value"); // put some stuff in the collection
		map3376.put("keyB-3376", param.toString()); // put it in a collection
		map3376.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map3376.get("keyB-3376"); // get it back out
		bar = (String)map3376.get("keyA-3376"); // get safe value back out
		
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}
}
