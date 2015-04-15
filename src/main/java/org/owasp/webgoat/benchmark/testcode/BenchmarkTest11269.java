package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11269")
public class BenchmarkTest11269 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map21235 = new java.util.HashMap<String,Object>();
		map21235.put("keyA-21235", "a_Value"); // put some stuff in the collection
		map21235.put("keyB-21235", param.toString()); // put it in a collection
		map21235.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map21235.get("keyB-21235"); // get it back out
		bar = (String)map21235.get("keyA-21235"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
