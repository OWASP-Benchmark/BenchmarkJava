package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07572")
public class BenchmarkTest07572 extends HttpServlet {
	
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
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a15265 = param; //assign
		StringBuilder b15265 = new StringBuilder(a15265);  // stick in stringbuilder
		b15265.append(" SafeStuff"); // append some safe content
		b15265.replace(b15265.length()-"Chars".length(),b15265.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map15265 = new java.util.HashMap<String,Object>();
		map15265.put("key15265", b15265.toString()); // put in a collection
		String c15265 = (String)map15265.get("key15265"); // get it back out
		String d15265 = c15265.substring(0,c15265.length()-1); // extract most of it
		String e15265 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d15265.getBytes() ) )); // B64 encode and decode it
		String f15265 = e15265.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f15265); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
