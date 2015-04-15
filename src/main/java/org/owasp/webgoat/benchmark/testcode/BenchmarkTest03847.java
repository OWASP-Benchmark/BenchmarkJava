package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03847")
public class BenchmarkTest03847 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map97316 = new java.util.HashMap<String,Object>();
		map97316.put("keyA-97316", "a_Value"); // put some stuff in the collection
		map97316.put("keyB-97316", param.toString()); // put it in a collection
		map97316.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map97316.get("keyB-97316"); // get it back out
		bar = (String)map97316.get("keyA-97316"); // get safe value back out
		
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}
}
