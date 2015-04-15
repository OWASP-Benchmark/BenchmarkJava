package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09278")
public class BenchmarkTest09278 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map22516 = new java.util.HashMap<String,Object>();
		map22516.put("keyA-22516", "a Value"); // put some stuff in the collection
		map22516.put("keyB-22516", param.toString()); // put it in a collection
		map22516.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map22516.get("keyB-22516"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
