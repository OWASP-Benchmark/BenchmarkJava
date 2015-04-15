package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10085")
public class BenchmarkTest10085 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map72453 = new java.util.HashMap<String,Object>();
		map72453.put("keyA-72453", "a Value"); // put some stuff in the collection
		map72453.put("keyB-72453", param.toString()); // put it in a collection
		map72453.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map72453.get("keyB-72453"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
