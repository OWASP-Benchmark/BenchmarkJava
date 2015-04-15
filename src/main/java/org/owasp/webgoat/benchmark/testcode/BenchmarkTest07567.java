package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07567")
public class BenchmarkTest07567 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a31121 = param; //assign
		StringBuilder b31121 = new StringBuilder(a31121);  // stick in stringbuilder
		b31121.append(" SafeStuff"); // append some safe content
		b31121.replace(b31121.length()-"Chars".length(),b31121.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31121 = new java.util.HashMap<String,Object>();
		map31121.put("key31121", b31121.toString()); // put in a collection
		String c31121 = (String)map31121.get("key31121"); // get it back out
		String d31121 = c31121.substring(0,c31121.length()-1); // extract most of it
		String e31121 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31121.getBytes() ) )); // B64 encode and decode it
		String f31121 = e31121.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g31121 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g31121); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
