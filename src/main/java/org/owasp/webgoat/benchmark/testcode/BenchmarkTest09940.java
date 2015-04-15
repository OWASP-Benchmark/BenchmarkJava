package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09940")
public class BenchmarkTest09940 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map8935 = new java.util.HashMap<String,Object>();
		map8935.put("keyA-8935", "a Value"); // put some stuff in the collection
		map8935.put("keyB-8935", param.toString()); // put it in a collection
		map8935.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map8935.get("keyB-8935"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
