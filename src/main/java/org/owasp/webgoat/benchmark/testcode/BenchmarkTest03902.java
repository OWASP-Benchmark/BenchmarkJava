package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03902")
public class BenchmarkTest03902 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map26155 = new java.util.HashMap<String,Object>();
		map26155.put("keyA-26155", "a_Value"); // put some stuff in the collection
		map26155.put("keyB-26155", param.toString()); // put it in a collection
		map26155.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map26155.get("keyB-26155"); // get it back out
		bar = (String)map26155.get("keyA-26155"); // get safe value back out
		
		
		response.setHeader(bar, "SomeValue");
	}
}
