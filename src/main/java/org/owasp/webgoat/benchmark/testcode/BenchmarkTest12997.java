package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12997")
public class BenchmarkTest12997 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map81645 = new java.util.HashMap<String,Object>();
		map81645.put("keyA-81645", "a Value"); // put some stuff in the collection
		map81645.put("keyB-81645", param.toString()); // put it in a collection
		map81645.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map81645.get("keyB-81645"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
