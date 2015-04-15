package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13819")
public class BenchmarkTest13819 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a38737 = param; //assign
		StringBuilder b38737 = new StringBuilder(a38737);  // stick in stringbuilder
		b38737.append(" SafeStuff"); // append some safe content
		b38737.replace(b38737.length()-"Chars".length(),b38737.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38737 = new java.util.HashMap<String,Object>();
		map38737.put("key38737", b38737.toString()); // put in a collection
		String c38737 = (String)map38737.get("key38737"); // get it back out
		String d38737 = c38737.substring(0,c38737.length()-1); // extract most of it
		String e38737 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38737.getBytes() ) )); // B64 encode and decode it
		String f38737 = e38737.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g38737 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g38737); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
