package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08179")
public class BenchmarkTest08179 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a31727 = param; //assign
		StringBuilder b31727 = new StringBuilder(a31727);  // stick in stringbuilder
		b31727.append(" SafeStuff"); // append some safe content
		b31727.replace(b31727.length()-"Chars".length(),b31727.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31727 = new java.util.HashMap<String,Object>();
		map31727.put("key31727", b31727.toString()); // put in a collection
		String c31727 = (String)map31727.get("key31727"); // get it back out
		String d31727 = c31727.substring(0,c31727.length()-1); // extract most of it
		String e31727 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31727.getBytes() ) )); // B64 encode and decode it
		String f31727 = e31727.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g31727 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g31727); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
