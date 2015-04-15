package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13496")
public class BenchmarkTest13496 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map83575 = new java.util.HashMap<String,Object>();
		map83575.put("keyA-83575", "a Value"); // put some stuff in the collection
		map83575.put("keyB-83575", param.toString()); // put it in a collection
		map83575.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map83575.get("keyB-83575"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
