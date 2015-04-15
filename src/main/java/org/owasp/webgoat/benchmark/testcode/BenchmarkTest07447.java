package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07447")
public class BenchmarkTest07447 extends HttpServlet {
	
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
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71883 = param; //assign
		StringBuilder b71883 = new StringBuilder(a71883);  // stick in stringbuilder
		b71883.append(" SafeStuff"); // append some safe content
		b71883.replace(b71883.length()-"Chars".length(),b71883.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71883 = new java.util.HashMap<String,Object>();
		map71883.put("key71883", b71883.toString()); // put in a collection
		String c71883 = (String)map71883.get("key71883"); // get it back out
		String d71883 = c71883.substring(0,c71883.length()-1); // extract most of it
		String e71883 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71883.getBytes() ) )); // B64 encode and decode it
		String f71883 = e71883.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f71883); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
