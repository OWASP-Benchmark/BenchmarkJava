package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03060")
public class BenchmarkTest03060 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map49686 = new java.util.HashMap<String,Object>();
		map49686.put("keyA-49686", "a Value"); // put some stuff in the collection
		map49686.put("keyB-49686", param.toString()); // put it in a collection
		map49686.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map49686.get("keyB-49686"); // get it back out
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
