package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09918")
public class BenchmarkTest09918 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map75035 = new java.util.HashMap<String,Object>();
		map75035.put("keyA-75035", "a Value"); // put some stuff in the collection
		map75035.put("keyB-75035", param.toString()); // put it in a collection
		map75035.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map75035.get("keyB-75035"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
