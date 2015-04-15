package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08168")
public class BenchmarkTest08168 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a13075 = param; //assign
		StringBuilder b13075 = new StringBuilder(a13075);  // stick in stringbuilder
		b13075.append(" SafeStuff"); // append some safe content
		b13075.replace(b13075.length()-"Chars".length(),b13075.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13075 = new java.util.HashMap<String,Object>();
		map13075.put("key13075", b13075.toString()); // put in a collection
		String c13075 = (String)map13075.get("key13075"); // get it back out
		String d13075 = c13075.substring(0,c13075.length()-1); // extract most of it
		String e13075 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13075.getBytes() ) )); // B64 encode and decode it
		String f13075 = e13075.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f13075); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
