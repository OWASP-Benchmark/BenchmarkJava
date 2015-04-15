package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19808")
public class BenchmarkTest19808 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map46159 = new java.util.HashMap<String,Object>();
		map46159.put("keyA-46159", "a_Value"); // put some stuff in the collection
		map46159.put("keyB-46159", param.toString()); // put it in a collection
		map46159.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map46159.get("keyB-46159"); // get it back out
		bar = (String)map46159.get("keyA-46159"); // get safe value back out
	
		return bar;	
	}
}
