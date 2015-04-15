package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12545")
public class BenchmarkTest12545 extends HttpServlet {
	
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
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a53499 = param; //assign
		StringBuilder b53499 = new StringBuilder(a53499);  // stick in stringbuilder
		b53499.append(" SafeStuff"); // append some safe content
		b53499.replace(b53499.length()-"Chars".length(),b53499.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map53499 = new java.util.HashMap<String,Object>();
		map53499.put("key53499", b53499.toString()); // put in a collection
		String c53499 = (String)map53499.get("key53499"); // get it back out
		String d53499 = c53499.substring(0,c53499.length()-1); // extract most of it
		String e53499 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d53499.getBytes() ) )); // B64 encode and decode it
		String f53499 = e53499.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g53499 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g53499); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
