package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17622")
public class BenchmarkTest17622 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map91506 = new java.util.HashMap<String,Object>();
		map91506.put("keyA-91506", "a_Value"); // put some stuff in the collection
		map91506.put("keyB-91506", param.toString()); // put it in a collection
		map91506.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map91506.get("keyB-91506"); // get it back out
		bar = (String)map91506.get("keyA-91506"); // get safe value back out
	
		return bar;	
	}
}
