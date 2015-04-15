package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02633")
public class BenchmarkTest02633 extends HttpServlet {
	
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
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map51987 = new java.util.HashMap<String,Object>();
		map51987.put("keyA-51987", "a Value"); // put some stuff in the collection
		map51987.put("keyB-51987", param.toString()); // put it in a collection
		map51987.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map51987.get("keyB-51987"); // get it back out
		
		
		response.addHeader(bar, "SomeValue");
	}
}
