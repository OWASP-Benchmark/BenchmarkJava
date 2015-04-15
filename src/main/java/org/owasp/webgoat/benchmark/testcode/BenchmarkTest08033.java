package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08033")
public class BenchmarkTest08033 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map7338 = new java.util.HashMap<String,Object>();
		map7338.put("keyA-7338", "a Value"); // put some stuff in the collection
		map7338.put("keyB-7338", param.toString()); // put it in a collection
		map7338.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map7338.get("keyB-7338"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
