package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03370")
public class BenchmarkTest03370 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map96762 = new java.util.HashMap<String,Object>();
		map96762.put("keyA-96762", "a_Value"); // put some stuff in the collection
		map96762.put("keyB-96762", param.toString()); // put it in a collection
		map96762.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map96762.get("keyB-96762"); // get it back out
		bar = (String)map96762.get("keyA-96762"); // get safe value back out
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}
}
