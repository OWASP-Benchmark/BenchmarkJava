package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17483")
public class BenchmarkTest17483 extends HttpServlet {
	
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
		

		String bar = doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map27739 = new java.util.HashMap<String,Object>();
		map27739.put("keyA-27739", "a_Value"); // put some stuff in the collection
		map27739.put("keyB-27739", param.toString()); // put it in a collection
		map27739.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map27739.get("keyB-27739"); // get it back out
		bar = (String)map27739.get("keyA-27739"); // get safe value back out
	
		return bar;	
	}
}
