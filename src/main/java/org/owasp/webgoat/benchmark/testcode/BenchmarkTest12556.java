package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12556")
public class BenchmarkTest12556 extends HttpServlet {
	
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
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a48925 = param; //assign
		StringBuilder b48925 = new StringBuilder(a48925);  // stick in stringbuilder
		b48925.append(" SafeStuff"); // append some safe content
		b48925.replace(b48925.length()-"Chars".length(),b48925.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48925 = new java.util.HashMap<String,Object>();
		map48925.put("key48925", b48925.toString()); // put in a collection
		String c48925 = (String)map48925.get("key48925"); // get it back out
		String d48925 = c48925.substring(0,c48925.length()-1); // extract most of it
		String e48925 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48925.getBytes() ) )); // B64 encode and decode it
		String f48925 = e48925.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f48925); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
