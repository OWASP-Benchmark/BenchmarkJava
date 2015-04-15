package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04965")
public class BenchmarkTest04965 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map79307 = new java.util.HashMap<String,Object>();
		map79307.put("keyA-79307", "a_Value"); // put some stuff in the collection
		map79307.put("keyB-79307", param.toString()); // put it in a collection
		map79307.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map79307.get("keyB-79307"); // get it back out
		bar = (String)map79307.get("keyA-79307"); // get safe value back out
		
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}
}
