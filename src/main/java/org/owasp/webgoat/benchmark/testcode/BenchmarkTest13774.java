package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13774")
public class BenchmarkTest13774 extends HttpServlet {
	
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
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a23071 = param; //assign
		StringBuilder b23071 = new StringBuilder(a23071);  // stick in stringbuilder
		b23071.append(" SafeStuff"); // append some safe content
		b23071.replace(b23071.length()-"Chars".length(),b23071.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23071 = new java.util.HashMap<String,Object>();
		map23071.put("key23071", b23071.toString()); // put in a collection
		String c23071 = (String)map23071.get("key23071"); // get it back out
		String d23071 = c23071.substring(0,c23071.length()-1); // extract most of it
		String e23071 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23071.getBytes() ) )); // B64 encode and decode it
		String f23071 = e23071.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f23071); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
