package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07290")
public class BenchmarkTest07290 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64813 = param; //assign
		StringBuilder b64813 = new StringBuilder(a64813);  // stick in stringbuilder
		b64813.append(" SafeStuff"); // append some safe content
		b64813.replace(b64813.length()-"Chars".length(),b64813.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64813 = new java.util.HashMap<String,Object>();
		map64813.put("key64813", b64813.toString()); // put in a collection
		String c64813 = (String)map64813.get("key64813"); // get it back out
		String d64813 = c64813.substring(0,c64813.length()-1); // extract most of it
		String e64813 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64813.getBytes() ) )); // B64 encode and decode it
		String f64813 = e64813.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64813); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
