package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03093")
public class BenchmarkTest03093 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map10225 = new java.util.HashMap<String,Object>();
		map10225.put("keyA-10225", "a_Value"); // put some stuff in the collection
		map10225.put("keyB-10225", param.toString()); // put it in a collection
		map10225.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map10225.get("keyB-10225"); // get it back out
		bar = (String)map10225.get("keyA-10225"); // get safe value back out
		
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}
}
