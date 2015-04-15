package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17105")
public class BenchmarkTest17105 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map95134 = new java.util.HashMap<String,Object>();
		map95134.put("keyA-95134", "a_Value"); // put some stuff in the collection
		map95134.put("keyB-95134", param.toString()); // put it in a collection
		map95134.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map95134.get("keyB-95134"); // get it back out
		bar = (String)map95134.get("keyA-95134"); // get safe value back out
	
		return bar;	
	}
}
