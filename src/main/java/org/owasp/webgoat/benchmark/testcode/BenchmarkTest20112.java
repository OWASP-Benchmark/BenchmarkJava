package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20112")
public class BenchmarkTest20112 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map5393 = new java.util.HashMap<String,Object>();
		map5393.put("keyA-5393", "a_Value"); // put some stuff in the collection
		map5393.put("keyB-5393", param.toString()); // put it in a collection
		map5393.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map5393.get("keyB-5393"); // get it back out
		bar = (String)map5393.get("keyA-5393"); // get safe value back out
	
		return bar;	
	}
}
