package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04389")
public class BenchmarkTest04389 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map39718 = new java.util.HashMap<String,Object>();
		map39718.put("keyA-39718", "a_Value"); // put some stuff in the collection
		map39718.put("keyB-39718", param.toString()); // put it in a collection
		map39718.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map39718.get("keyB-39718"); // get it back out
		bar = (String)map39718.get("keyA-39718"); // get safe value back out
		
		
		response.getWriter().write(bar);
	}
}
