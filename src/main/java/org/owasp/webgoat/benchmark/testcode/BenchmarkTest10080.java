package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10080")
public class BenchmarkTest10080 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map61815 = new java.util.HashMap<String,Object>();
		map61815.put("keyA-61815", "a_Value"); // put some stuff in the collection
		map61815.put("keyB-61815", param.toString()); // put it in a collection
		map61815.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map61815.get("keyB-61815"); // get it back out
		bar = (String)map61815.get("keyA-61815"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
