package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07452")
public class BenchmarkTest07452 extends HttpServlet {
	
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
		
		int length = 1;
		if (bar != null) {
			length = bar.length();
			response.getWriter().write(bar, 0, length - 1);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a36392 = param; //assign
		StringBuilder b36392 = new StringBuilder(a36392);  // stick in stringbuilder
		b36392.append(" SafeStuff"); // append some safe content
		b36392.replace(b36392.length()-"Chars".length(),b36392.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map36392 = new java.util.HashMap<String,Object>();
		map36392.put("key36392", b36392.toString()); // put in a collection
		String c36392 = (String)map36392.get("key36392"); // get it back out
		String d36392 = c36392.substring(0,c36392.length()-1); // extract most of it
		String e36392 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d36392.getBytes() ) )); // B64 encode and decode it
		String f36392 = e36392.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f36392); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
