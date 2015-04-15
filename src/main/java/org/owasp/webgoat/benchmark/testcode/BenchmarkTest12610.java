package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12610")
public class BenchmarkTest12610 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a23780 = param; //assign
		StringBuilder b23780 = new StringBuilder(a23780);  // stick in stringbuilder
		b23780.append(" SafeStuff"); // append some safe content
		b23780.replace(b23780.length()-"Chars".length(),b23780.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23780 = new java.util.HashMap<String,Object>();
		map23780.put("key23780", b23780.toString()); // put in a collection
		String c23780 = (String)map23780.get("key23780"); // get it back out
		String d23780 = c23780.substring(0,c23780.length()-1); // extract most of it
		String e23780 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23780.getBytes() ) )); // B64 encode and decode it
		String f23780 = e23780.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f23780); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
