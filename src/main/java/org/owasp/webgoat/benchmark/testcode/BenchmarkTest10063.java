package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10063")
public class BenchmarkTest10063 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a56622 = param; //assign
		StringBuilder b56622 = new StringBuilder(a56622);  // stick in stringbuilder
		b56622.append(" SafeStuff"); // append some safe content
		b56622.replace(b56622.length()-"Chars".length(),b56622.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56622 = new java.util.HashMap<String,Object>();
		map56622.put("key56622", b56622.toString()); // put in a collection
		String c56622 = (String)map56622.get("key56622"); // get it back out
		String d56622 = c56622.substring(0,c56622.length()-1); // extract most of it
		String e56622 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56622.getBytes() ) )); // B64 encode and decode it
		String f56622 = e56622.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g56622 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g56622); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
