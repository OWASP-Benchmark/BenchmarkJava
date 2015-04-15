package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07517")
public class BenchmarkTest07517 extends HttpServlet {
	
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
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a61924 = param; //assign
		StringBuilder b61924 = new StringBuilder(a61924);  // stick in stringbuilder
		b61924.append(" SafeStuff"); // append some safe content
		b61924.replace(b61924.length()-"Chars".length(),b61924.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61924 = new java.util.HashMap<String,Object>();
		map61924.put("key61924", b61924.toString()); // put in a collection
		String c61924 = (String)map61924.get("key61924"); // get it back out
		String d61924 = c61924.substring(0,c61924.length()-1); // extract most of it
		String e61924 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61924.getBytes() ) )); // B64 encode and decode it
		String f61924 = e61924.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f61924); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
