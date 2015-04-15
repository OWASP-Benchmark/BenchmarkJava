package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07505")
public class BenchmarkTest07505 extends HttpServlet {
	
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
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a33882 = param; //assign
		StringBuilder b33882 = new StringBuilder(a33882);  // stick in stringbuilder
		b33882.append(" SafeStuff"); // append some safe content
		b33882.replace(b33882.length()-"Chars".length(),b33882.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map33882 = new java.util.HashMap<String,Object>();
		map33882.put("key33882", b33882.toString()); // put in a collection
		String c33882 = (String)map33882.get("key33882"); // get it back out
		String d33882 = c33882.substring(0,c33882.length()-1); // extract most of it
		String e33882 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d33882.getBytes() ) )); // B64 encode and decode it
		String f33882 = e33882.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f33882); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
