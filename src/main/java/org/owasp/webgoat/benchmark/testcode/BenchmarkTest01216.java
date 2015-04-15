package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01216")
public class BenchmarkTest01216 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map40890 = new java.util.HashMap<String,Object>();
		map40890.put("keyA-40890", "a Value"); // put some stuff in the collection
		map40890.put("keyB-40890", param.toString()); // put it in a collection
		map40890.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map40890.get("keyB-40890"); // get it back out
		
		
		response.getWriter().println(bar);
	}
}
