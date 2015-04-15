package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01201")
public class BenchmarkTest01201 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map94178 = new java.util.HashMap<String,Object>();
		map94178.put("keyA-94178", "a Value"); // put some stuff in the collection
		map94178.put("keyB-94178", param.toString()); // put it in a collection
		map94178.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map94178.get("keyB-94178"); // get it back out
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
