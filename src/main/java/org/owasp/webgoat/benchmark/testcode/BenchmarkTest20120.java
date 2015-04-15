package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20120")
public class BenchmarkTest20120 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map5240 = new java.util.HashMap<String,Object>();
		map5240.put("keyA-5240", "a Value"); // put some stuff in the collection
		map5240.put("keyB-5240", param.toString()); // put it in a collection
		map5240.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map5240.get("keyB-5240"); // get it back out
	
		return bar;	
	}
}
