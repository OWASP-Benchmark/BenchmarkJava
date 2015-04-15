package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13193")
public class BenchmarkTest13193 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map85635 = new java.util.HashMap<String,Object>();
		map85635.put("keyA-85635", "a Value"); // put some stuff in the collection
		map85635.put("keyB-85635", param.toString()); // put it in a collection
		map85635.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map85635.get("keyB-85635"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
