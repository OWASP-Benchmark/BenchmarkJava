package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02438")
public class BenchmarkTest02438 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map11030 = new java.util.HashMap<String,Object>();
		map11030.put("keyA-11030", "a_Value"); // put some stuff in the collection
		map11030.put("keyB-11030", param.toString()); // put it in a collection
		map11030.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map11030.get("keyB-11030"); // get it back out
		bar = (String)map11030.get("keyA-11030"); // get safe value back out
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format("notfoo",obj);
	}
}
