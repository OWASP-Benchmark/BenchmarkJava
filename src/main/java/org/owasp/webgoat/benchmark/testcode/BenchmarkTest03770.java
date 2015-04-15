package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03770")
public class BenchmarkTest03770 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map67738 = new java.util.HashMap<String,Object>();
		map67738.put("keyA-67738", "a_Value"); // put some stuff in the collection
		map67738.put("keyB-67738", param.toString()); // put it in a collection
		map67738.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map67738.get("keyB-67738"); // get it back out
		bar = (String)map67738.get("keyA-67738"); // get safe value back out
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
