package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12560")
public class BenchmarkTest12560 extends HttpServlet {
	
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
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a11889 = param; //assign
		StringBuilder b11889 = new StringBuilder(a11889);  // stick in stringbuilder
		b11889.append(" SafeStuff"); // append some safe content
		b11889.replace(b11889.length()-"Chars".length(),b11889.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11889 = new java.util.HashMap<String,Object>();
		map11889.put("key11889", b11889.toString()); // put in a collection
		String c11889 = (String)map11889.get("key11889"); // get it back out
		String d11889 = c11889.substring(0,c11889.length()-1); // extract most of it
		String e11889 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11889.getBytes() ) )); // B64 encode and decode it
		String f11889 = e11889.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f11889); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
