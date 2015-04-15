package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03563")
public class BenchmarkTest03563 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map57719 = new java.util.HashMap<String,Object>();
		map57719.put("keyA-57719", "a_Value"); // put some stuff in the collection
		map57719.put("keyB-57719", param.toString()); // put it in a collection
		map57719.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map57719.get("keyB-57719"); // get it back out
		bar = (String)map57719.get("keyA-57719"); // get safe value back out
		
		
		java.io.File file = new java.io.File(bar);
	}
}
