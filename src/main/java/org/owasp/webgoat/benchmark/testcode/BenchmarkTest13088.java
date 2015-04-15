package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13088")
public class BenchmarkTest13088 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map46349 = new java.util.HashMap<String,Object>();
		map46349.put("keyA-46349", "a Value"); // put some stuff in the collection
		map46349.put("keyB-46349", param.toString()); // put it in a collection
		map46349.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map46349.get("keyB-46349"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
