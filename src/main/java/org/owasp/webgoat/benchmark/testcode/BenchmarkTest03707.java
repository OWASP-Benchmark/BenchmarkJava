package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03707")
public class BenchmarkTest03707 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map12907 = new java.util.HashMap<String,Object>();
		map12907.put("keyA-12907", "a_Value"); // put some stuff in the collection
		map12907.put("keyB-12907", param.toString()); // put it in a collection
		map12907.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map12907.get("keyB-12907"); // get it back out
		bar = (String)map12907.get("keyA-12907"); // get safe value back out
		
		
		response.getWriter().print(bar.toCharArray());
	}
}
