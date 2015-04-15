package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16093")
public class BenchmarkTest16093 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map53531 = new java.util.HashMap<String,Object>();
		map53531.put("keyA-53531", "a_Value"); // put some stuff in the collection
		map53531.put("keyB-53531", param.toString()); // put it in a collection
		map53531.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map53531.get("keyB-53531"); // get it back out
		bar = (String)map53531.get("keyA-53531"); // get safe value back out
	
		return bar;	
	}
}
