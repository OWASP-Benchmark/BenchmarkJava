package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07383")
public class BenchmarkTest07383 extends HttpServlet {
	
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
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a28350 = param; //assign
		StringBuilder b28350 = new StringBuilder(a28350);  // stick in stringbuilder
		b28350.append(" SafeStuff"); // append some safe content
		b28350.replace(b28350.length()-"Chars".length(),b28350.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map28350 = new java.util.HashMap<String,Object>();
		map28350.put("key28350", b28350.toString()); // put in a collection
		String c28350 = (String)map28350.get("key28350"); // get it back out
		String d28350 = c28350.substring(0,c28350.length()-1); // extract most of it
		String e28350 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d28350.getBytes() ) )); // B64 encode and decode it
		String f28350 = e28350.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f28350); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
