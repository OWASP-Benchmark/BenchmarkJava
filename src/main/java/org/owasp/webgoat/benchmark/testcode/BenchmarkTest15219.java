package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15219")
public class BenchmarkTest15219 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map75138 = new java.util.HashMap<String,Object>();
		map75138.put("keyA-75138", "a_Value"); // put some stuff in the collection
		map75138.put("keyB-75138", param.toString()); // put it in a collection
		map75138.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map75138.get("keyB-75138"); // get it back out
		bar = (String)map75138.get("keyA-75138"); // get safe value back out
	
		return bar;	
	}
}
