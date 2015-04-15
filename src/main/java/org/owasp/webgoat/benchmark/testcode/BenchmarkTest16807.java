package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16807")
public class BenchmarkTest16807 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map8857 = new java.util.HashMap<String,Object>();
		map8857.put("keyA-8857", "a_Value"); // put some stuff in the collection
		map8857.put("keyB-8857", param.toString()); // put it in a collection
		map8857.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map8857.get("keyB-8857"); // get it back out
		bar = (String)map8857.get("keyA-8857"); // get safe value back out
	
		return bar;	
	}
}
