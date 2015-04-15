package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20208")
public class BenchmarkTest20208 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map94671 = new java.util.HashMap<String,Object>();
		map94671.put("keyA-94671", "a_Value"); // put some stuff in the collection
		map94671.put("keyB-94671", param.toString()); // put it in a collection
		map94671.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map94671.get("keyB-94671"); // get it back out
		bar = (String)map94671.get("keyA-94671"); // get safe value back out
	
		return bar;	
	}
}
