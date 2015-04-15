package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08076")
public class BenchmarkTest08076 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map41358 = new java.util.HashMap<String,Object>();
		map41358.put("keyA-41358", "a Value"); // put some stuff in the collection
		map41358.put("keyB-41358", param.toString()); // put it in a collection
		map41358.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map41358.get("keyB-41358"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
