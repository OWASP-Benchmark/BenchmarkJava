package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03712")
public class BenchmarkTest03712 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map94164 = new java.util.HashMap<String,Object>();
		map94164.put("keyA-94164", "a_Value"); // put some stuff in the collection
		map94164.put("keyB-94164", param.toString()); // put it in a collection
		map94164.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map94164.get("keyB-94164"); // get it back out
		bar = (String)map94164.get("keyA-94164"); // get safe value back out
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
