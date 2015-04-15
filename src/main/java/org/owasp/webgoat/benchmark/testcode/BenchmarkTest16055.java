package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16055")
public class BenchmarkTest16055 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map99686 = new java.util.HashMap<String,Object>();
		map99686.put("keyA-99686", "a_Value"); // put some stuff in the collection
		map99686.put("keyB-99686", param.toString()); // put it in a collection
		map99686.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map99686.get("keyB-99686"); // get it back out
		bar = (String)map99686.get("keyA-99686"); // get safe value back out
	
		return bar;	
	}
}
