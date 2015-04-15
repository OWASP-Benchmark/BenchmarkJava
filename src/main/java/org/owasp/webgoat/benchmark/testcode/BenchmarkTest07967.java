package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07967")
public class BenchmarkTest07967 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map57092 = new java.util.HashMap<String,Object>();
		map57092.put("keyA-57092", "a Value"); // put some stuff in the collection
		map57092.put("keyB-57092", param.toString()); // put it in a collection
		map57092.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map57092.get("keyB-57092"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
