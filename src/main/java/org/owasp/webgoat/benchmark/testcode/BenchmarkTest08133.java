package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08133")
public class BenchmarkTest08133 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a37494 = param; //assign
		StringBuilder b37494 = new StringBuilder(a37494);  // stick in stringbuilder
		b37494.append(" SafeStuff"); // append some safe content
		b37494.replace(b37494.length()-"Chars".length(),b37494.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37494 = new java.util.HashMap<String,Object>();
		map37494.put("key37494", b37494.toString()); // put in a collection
		String c37494 = (String)map37494.get("key37494"); // get it back out
		String d37494 = c37494.substring(0,c37494.length()-1); // extract most of it
		String e37494 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37494.getBytes() ) )); // B64 encode and decode it
		String f37494 = e37494.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g37494 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g37494); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
