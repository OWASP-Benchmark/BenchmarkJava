package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13211")
public class BenchmarkTest13211 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map16517 = new java.util.HashMap<String,Object>();
		map16517.put("keyA-16517", "a Value"); // put some stuff in the collection
		map16517.put("keyB-16517", param.toString()); // put it in a collection
		map16517.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map16517.get("keyB-16517"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
