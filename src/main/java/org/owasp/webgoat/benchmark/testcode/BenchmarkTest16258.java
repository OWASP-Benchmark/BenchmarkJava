package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16258")
public class BenchmarkTest16258 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map53390 = new java.util.HashMap<String,Object>();
		map53390.put("keyA-53390", "a_Value"); // put some stuff in the collection
		map53390.put("keyB-53390", param.toString()); // put it in a collection
		map53390.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map53390.get("keyB-53390"); // get it back out
		bar = (String)map53390.get("keyA-53390"); // get safe value back out
	
		return bar;	
	}
}
