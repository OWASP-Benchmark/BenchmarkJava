package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03884")
public class BenchmarkTest03884 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map95772 = new java.util.HashMap<String,Object>();
		map95772.put("keyA-95772", "a_Value"); // put some stuff in the collection
		map95772.put("keyB-95772", param.toString()); // put it in a collection
		map95772.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map95772.get("keyB-95772"); // get it back out
		bar = (String)map95772.get("keyA-95772"); // get safe value back out
		
		
		response.addHeader("SomeHeader", bar);
	}
}
