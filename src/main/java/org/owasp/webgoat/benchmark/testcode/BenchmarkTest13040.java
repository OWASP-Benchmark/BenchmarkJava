package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13040")
public class BenchmarkTest13040 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map87459 = new java.util.HashMap<String,Object>();
		map87459.put("keyA-87459", "a Value"); // put some stuff in the collection
		map87459.put("keyB-87459", param.toString()); // put it in a collection
		map87459.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map87459.get("keyB-87459"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
