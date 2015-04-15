package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11957")
public class BenchmarkTest11957 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95179 = param; //assign
		StringBuilder b95179 = new StringBuilder(a95179);  // stick in stringbuilder
		b95179.append(" SafeStuff"); // append some safe content
		b95179.replace(b95179.length()-"Chars".length(),b95179.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95179 = new java.util.HashMap<String,Object>();
		map95179.put("key95179", b95179.toString()); // put in a collection
		String c95179 = (String)map95179.get("key95179"); // get it back out
		String d95179 = c95179.substring(0,c95179.length()-1); // extract most of it
		String e95179 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95179.getBytes() ) )); // B64 encode and decode it
		String f95179 = e95179.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g95179 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g95179); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
