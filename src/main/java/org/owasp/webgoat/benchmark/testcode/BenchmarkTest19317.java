package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19317")
public class BenchmarkTest19317 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = doSomething(param);
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map54303 = new java.util.HashMap<String,Object>();
		map54303.put("keyA-54303", "a_Value"); // put some stuff in the collection
		map54303.put("keyB-54303", param.toString()); // put it in a collection
		map54303.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map54303.get("keyB-54303"); // get it back out
		bar = (String)map54303.get("keyA-54303"); // get safe value back out
	
		return bar;	
	}
}
