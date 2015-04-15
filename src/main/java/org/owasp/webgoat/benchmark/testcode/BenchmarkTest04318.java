package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04318")
public class BenchmarkTest04318 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map5328 = new java.util.HashMap<String,Object>();
		map5328.put("keyA-5328", "a_Value"); // put some stuff in the collection
		map5328.put("keyB-5328", param.toString()); // put it in a collection
		map5328.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map5328.get("keyB-5328"); // get it back out
		bar = (String)map5328.get("keyA-5328"); // get safe value back out
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
