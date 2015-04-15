package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07989")
public class BenchmarkTest07989 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().print(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map68744 = new java.util.HashMap<String,Object>();
		map68744.put("keyA-68744", "a Value"); // put some stuff in the collection
		map68744.put("keyB-68744", param.toString()); // put it in a collection
		map68744.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map68744.get("keyB-68744"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
