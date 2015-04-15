package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09740")
public class BenchmarkTest09740 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map12190 = new java.util.HashMap<String,Object>();
		map12190.put("keyA-12190", "a Value"); // put some stuff in the collection
		map12190.put("keyB-12190", param.toString()); // put it in a collection
		map12190.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map12190.get("keyB-12190"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
