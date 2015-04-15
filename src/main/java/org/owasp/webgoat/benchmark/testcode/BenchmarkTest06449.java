package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06449")
public class BenchmarkTest06449 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map13587 = new java.util.HashMap<String,Object>();
		map13587.put("keyA-13587", "a_Value"); // put some stuff in the collection
		map13587.put("keyB-13587", param.toString()); // put it in a collection
		map13587.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map13587.get("keyB-13587"); // get it back out
		bar = (String)map13587.get("keyA-13587"); // get safe value back out
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}
}
