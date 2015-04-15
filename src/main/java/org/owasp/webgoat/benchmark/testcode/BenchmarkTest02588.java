package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02588")
public class BenchmarkTest02588 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map22240 = new java.util.HashMap<String,Object>();
		map22240.put("keyA-22240", "a_Value"); // put some stuff in the collection
		map22240.put("keyB-22240", param.toString()); // put it in a collection
		map22240.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map22240.get("keyB-22240"); // get it back out
		bar = (String)map22240.get("keyA-22240"); // get safe value back out
		
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}
}
