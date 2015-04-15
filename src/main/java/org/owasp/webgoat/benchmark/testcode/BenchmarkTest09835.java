package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09835")
public class BenchmarkTest09835 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map68736 = new java.util.HashMap<String,Object>();
		map68736.put("keyA-68736", "a Value"); // put some stuff in the collection
		map68736.put("keyB-68736", param.toString()); // put it in a collection
		map68736.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map68736.get("keyB-68736"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
