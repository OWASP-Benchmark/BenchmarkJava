package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08211")
public class BenchmarkTest08211 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map82082 = new java.util.HashMap<String,Object>();
		map82082.put("keyA-82082", "a Value"); // put some stuff in the collection
		map82082.put("keyB-82082", param.toString()); // put it in a collection
		map82082.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map82082.get("keyB-82082"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
