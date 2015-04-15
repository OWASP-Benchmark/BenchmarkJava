package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07409")
public class BenchmarkTest07409 extends HttpServlet {
	
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
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a73905 = param; //assign
		StringBuilder b73905 = new StringBuilder(a73905);  // stick in stringbuilder
		b73905.append(" SafeStuff"); // append some safe content
		b73905.replace(b73905.length()-"Chars".length(),b73905.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map73905 = new java.util.HashMap<String,Object>();
		map73905.put("key73905", b73905.toString()); // put in a collection
		String c73905 = (String)map73905.get("key73905"); // get it back out
		String d73905 = c73905.substring(0,c73905.length()-1); // extract most of it
		String e73905 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d73905.getBytes() ) )); // B64 encode and decode it
		String f73905 = e73905.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g73905 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g73905); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
