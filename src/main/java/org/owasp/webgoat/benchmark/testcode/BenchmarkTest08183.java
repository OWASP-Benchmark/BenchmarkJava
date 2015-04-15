package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08183")
public class BenchmarkTest08183 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map89921 = new java.util.HashMap<String,Object>();
		map89921.put("keyA-89921", "a_Value"); // put some stuff in the collection
		map89921.put("keyB-89921", param.toString()); // put it in a collection
		map89921.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map89921.get("keyB-89921"); // get it back out
		bar = (String)map89921.get("keyA-89921"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
