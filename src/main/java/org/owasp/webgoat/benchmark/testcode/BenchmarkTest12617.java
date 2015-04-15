package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12617")
public class BenchmarkTest12617 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map84598 = new java.util.HashMap<String,Object>();
		map84598.put("keyA-84598", "a Value"); // put some stuff in the collection
		map84598.put("keyB-84598", param.toString()); // put it in a collection
		map84598.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map84598.get("keyB-84598"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
