package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12606")
public class BenchmarkTest12606 extends HttpServlet {
	
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
		String a83444 = param; //assign
		StringBuilder b83444 = new StringBuilder(a83444);  // stick in stringbuilder
		b83444.append(" SafeStuff"); // append some safe content
		b83444.replace(b83444.length()-"Chars".length(),b83444.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83444 = new java.util.HashMap<String,Object>();
		map83444.put("key83444", b83444.toString()); // put in a collection
		String c83444 = (String)map83444.get("key83444"); // get it back out
		String d83444 = c83444.substring(0,c83444.length()-1); // extract most of it
		String e83444 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83444.getBytes() ) )); // B64 encode and decode it
		String f83444 = e83444.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g83444 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g83444); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
