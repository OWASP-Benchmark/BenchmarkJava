package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04381")
public class BenchmarkTest04381 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map10159 = new java.util.HashMap<String,Object>();
		map10159.put("keyA-10159", "a_Value"); // put some stuff in the collection
		map10159.put("keyB-10159", param.toString()); // put it in a collection
		map10159.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map10159.get("keyB-10159"); // get it back out
		bar = (String)map10159.get("keyA-10159"); // get safe value back out
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
