package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09920")
public class BenchmarkTest09920 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map60840 = new java.util.HashMap<String,Object>();
		map60840.put("keyA-60840", "a_Value"); // put some stuff in the collection
		map60840.put("keyB-60840", param.toString()); // put it in a collection
		map60840.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map60840.get("keyB-60840"); // get it back out
		bar = (String)map60840.get("keyA-60840"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
