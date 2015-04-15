package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17095")
public class BenchmarkTest17095 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map1909 = new java.util.HashMap<String,Object>();
		map1909.put("keyA-1909", "a_Value"); // put some stuff in the collection
		map1909.put("keyB-1909", param.toString()); // put it in a collection
		map1909.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map1909.get("keyB-1909"); // get it back out
		bar = (String)map1909.get("keyA-1909"); // get safe value back out
	
		return bar;	
	}
}
