package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07221")
public class BenchmarkTest07221 extends HttpServlet {
	
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
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a15473 = param; //assign
		StringBuilder b15473 = new StringBuilder(a15473);  // stick in stringbuilder
		b15473.append(" SafeStuff"); // append some safe content
		b15473.replace(b15473.length()-"Chars".length(),b15473.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map15473 = new java.util.HashMap<String,Object>();
		map15473.put("key15473", b15473.toString()); // put in a collection
		String c15473 = (String)map15473.get("key15473"); // get it back out
		String d15473 = c15473.substring(0,c15473.length()-1); // extract most of it
		String e15473 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d15473.getBytes() ) )); // B64 encode and decode it
		String f15473 = e15473.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g15473 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g15473); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
