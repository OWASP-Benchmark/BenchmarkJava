package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07365")
public class BenchmarkTest07365 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a90405 = param; //assign
		StringBuilder b90405 = new StringBuilder(a90405);  // stick in stringbuilder
		b90405.append(" SafeStuff"); // append some safe content
		b90405.replace(b90405.length()-"Chars".length(),b90405.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map90405 = new java.util.HashMap<String,Object>();
		map90405.put("key90405", b90405.toString()); // put in a collection
		String c90405 = (String)map90405.get("key90405"); // get it back out
		String d90405 = c90405.substring(0,c90405.length()-1); // extract most of it
		String e90405 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d90405.getBytes() ) )); // B64 encode and decode it
		String f90405 = e90405.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g90405 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g90405); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
