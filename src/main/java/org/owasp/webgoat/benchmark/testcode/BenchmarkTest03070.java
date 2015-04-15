package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03070")
public class BenchmarkTest03070 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map32104 = new java.util.HashMap<String,Object>();
		map32104.put("keyA-32104", "a_Value"); // put some stuff in the collection
		map32104.put("keyB-32104", param.toString()); // put it in a collection
		map32104.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map32104.get("keyB-32104"); // get it back out
		bar = (String)map32104.get("keyA-32104"); // get safe value back out
		
		
		response.getWriter().print(bar.toCharArray());
	}
}
