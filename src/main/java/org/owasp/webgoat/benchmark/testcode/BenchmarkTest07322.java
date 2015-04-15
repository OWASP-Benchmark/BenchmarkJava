package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07322")
public class BenchmarkTest07322 extends HttpServlet {
	
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
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a62980 = param; //assign
		StringBuilder b62980 = new StringBuilder(a62980);  // stick in stringbuilder
		b62980.append(" SafeStuff"); // append some safe content
		b62980.replace(b62980.length()-"Chars".length(),b62980.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62980 = new java.util.HashMap<String,Object>();
		map62980.put("key62980", b62980.toString()); // put in a collection
		String c62980 = (String)map62980.get("key62980"); // get it back out
		String d62980 = c62980.substring(0,c62980.length()-1); // extract most of it
		String e62980 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62980.getBytes() ) )); // B64 encode and decode it
		String f62980 = e62980.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g62980 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g62980); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
