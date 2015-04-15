package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05594")
public class BenchmarkTest05594 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map25572 = new java.util.HashMap<String,Object>();
		map25572.put("keyA-25572", "a_Value"); // put some stuff in the collection
		map25572.put("keyB-25572", param.toString()); // put it in a collection
		map25572.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map25572.get("keyB-25572"); // get it back out
		bar = (String)map25572.get("keyA-25572"); // get safe value back out
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}
}
