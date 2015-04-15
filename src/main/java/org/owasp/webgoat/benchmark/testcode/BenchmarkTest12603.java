package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12603")
public class BenchmarkTest12603 extends HttpServlet {
	
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
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a72959 = param; //assign
		StringBuilder b72959 = new StringBuilder(a72959);  // stick in stringbuilder
		b72959.append(" SafeStuff"); // append some safe content
		b72959.replace(b72959.length()-"Chars".length(),b72959.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72959 = new java.util.HashMap<String,Object>();
		map72959.put("key72959", b72959.toString()); // put in a collection
		String c72959 = (String)map72959.get("key72959"); // get it back out
		String d72959 = c72959.substring(0,c72959.length()-1); // extract most of it
		String e72959 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72959.getBytes() ) )); // B64 encode and decode it
		String f72959 = e72959.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f72959); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
