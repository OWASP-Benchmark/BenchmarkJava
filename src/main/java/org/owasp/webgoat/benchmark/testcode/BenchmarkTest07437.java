package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07437")
public class BenchmarkTest07437 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = new Test().doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a86228 = param; //assign
		StringBuilder b86228 = new StringBuilder(a86228);  // stick in stringbuilder
		b86228.append(" SafeStuff"); // append some safe content
		b86228.replace(b86228.length()-"Chars".length(),b86228.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86228 = new java.util.HashMap<String,Object>();
		map86228.put("key86228", b86228.toString()); // put in a collection
		String c86228 = (String)map86228.get("key86228"); // get it back out
		String d86228 = c86228.substring(0,c86228.length()-1); // extract most of it
		String e86228 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86228.getBytes() ) )); // B64 encode and decode it
		String f86228 = e86228.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g86228 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g86228); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
