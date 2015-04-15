package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07533")
public class BenchmarkTest07533 extends HttpServlet {
	
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
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a30297 = param; //assign
		StringBuilder b30297 = new StringBuilder(a30297);  // stick in stringbuilder
		b30297.append(" SafeStuff"); // append some safe content
		b30297.replace(b30297.length()-"Chars".length(),b30297.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30297 = new java.util.HashMap<String,Object>();
		map30297.put("key30297", b30297.toString()); // put in a collection
		String c30297 = (String)map30297.get("key30297"); // get it back out
		String d30297 = c30297.substring(0,c30297.length()-1); // extract most of it
		String e30297 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30297.getBytes() ) )); // B64 encode and decode it
		String f30297 = e30297.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f30297); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
