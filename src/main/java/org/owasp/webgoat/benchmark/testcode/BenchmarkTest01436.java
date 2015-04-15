package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01436")
public class BenchmarkTest01436 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map30145 = new java.util.HashMap<String,Object>();
		map30145.put("keyA-30145", "a_Value"); // put some stuff in the collection
		map30145.put("keyB-30145", param.toString()); // put it in a collection
		map30145.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map30145.get("keyB-30145"); // get it back out
		bar = (String)map30145.get("keyA-30145"); // get safe value back out
		
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
		request.getSession().putValue( "foo", bar);
	}
}
