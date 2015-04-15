package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16368")
public class BenchmarkTest16368 extends HttpServlet {
	
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
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map46586 = new java.util.HashMap<String,Object>();
		map46586.put("keyA-46586", "a_Value"); // put some stuff in the collection
		map46586.put("keyB-46586", param.toString()); // put it in a collection
		map46586.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map46586.get("keyB-46586"); // get it back out
		bar = (String)map46586.get("keyA-46586"); // get safe value back out
	
		return bar;	
	}
}
