package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04351")
public class BenchmarkTest04351 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map65855 = new java.util.HashMap<String,Object>();
		map65855.put("keyA-65855", "a_Value"); // put some stuff in the collection
		map65855.put("keyB-65855", param.toString()); // put it in a collection
		map65855.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map65855.get("keyB-65855"); // get it back out
		bar = (String)map65855.get("keyA-65855"); // get safe value back out
		
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}
}
