package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09741")
public class BenchmarkTest09741 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map27362 = new java.util.HashMap<String,Object>();
		map27362.put("keyA-27362", "a_Value"); // put some stuff in the collection
		map27362.put("keyB-27362", param.toString()); // put it in a collection
		map27362.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map27362.get("keyB-27362"); // get it back out
		bar = (String)map27362.get("keyA-27362"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
