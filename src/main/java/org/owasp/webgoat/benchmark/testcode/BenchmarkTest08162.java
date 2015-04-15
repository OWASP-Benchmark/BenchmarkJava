package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08162")
public class BenchmarkTest08162 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a24372 = param; //assign
		StringBuilder b24372 = new StringBuilder(a24372);  // stick in stringbuilder
		b24372.append(" SafeStuff"); // append some safe content
		b24372.replace(b24372.length()-"Chars".length(),b24372.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24372 = new java.util.HashMap<String,Object>();
		map24372.put("key24372", b24372.toString()); // put in a collection
		String c24372 = (String)map24372.get("key24372"); // get it back out
		String d24372 = c24372.substring(0,c24372.length()-1); // extract most of it
		String e24372 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24372.getBytes() ) )); // B64 encode and decode it
		String f24372 = e24372.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f24372); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
