package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13571")
public class BenchmarkTest13571 extends HttpServlet {
	
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
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a66469 = param; //assign
		StringBuilder b66469 = new StringBuilder(a66469);  // stick in stringbuilder
		b66469.append(" SafeStuff"); // append some safe content
		b66469.replace(b66469.length()-"Chars".length(),b66469.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map66469 = new java.util.HashMap<String,Object>();
		map66469.put("key66469", b66469.toString()); // put in a collection
		String c66469 = (String)map66469.get("key66469"); // get it back out
		String d66469 = c66469.substring(0,c66469.length()-1); // extract most of it
		String e66469 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d66469.getBytes() ) )); // B64 encode and decode it
		String f66469 = e66469.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f66469); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
