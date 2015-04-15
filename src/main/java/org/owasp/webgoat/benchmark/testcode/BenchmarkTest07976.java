package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07976")
public class BenchmarkTest07976 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map51074 = new java.util.HashMap<String,Object>();
		map51074.put("keyA-51074", "a Value"); // put some stuff in the collection
		map51074.put("keyB-51074", param.toString()); // put it in a collection
		map51074.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map51074.get("keyB-51074"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
