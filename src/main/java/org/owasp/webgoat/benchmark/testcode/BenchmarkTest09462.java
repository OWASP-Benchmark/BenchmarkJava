package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09462")
public class BenchmarkTest09462 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a90905 = param; //assign
		StringBuilder b90905 = new StringBuilder(a90905);  // stick in stringbuilder
		b90905.append(" SafeStuff"); // append some safe content
		b90905.replace(b90905.length()-"Chars".length(),b90905.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map90905 = new java.util.HashMap<String,Object>();
		map90905.put("key90905", b90905.toString()); // put in a collection
		String c90905 = (String)map90905.get("key90905"); // get it back out
		String d90905 = c90905.substring(0,c90905.length()-1); // extract most of it
		String e90905 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d90905.getBytes() ) )); // B64 encode and decode it
		String f90905 = e90905.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f90905); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
