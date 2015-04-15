package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11914")
public class BenchmarkTest11914 extends HttpServlet {
	
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
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a61946 = param; //assign
		StringBuilder b61946 = new StringBuilder(a61946);  // stick in stringbuilder
		b61946.append(" SafeStuff"); // append some safe content
		b61946.replace(b61946.length()-"Chars".length(),b61946.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61946 = new java.util.HashMap<String,Object>();
		map61946.put("key61946", b61946.toString()); // put in a collection
		String c61946 = (String)map61946.get("key61946"); // get it back out
		String d61946 = c61946.substring(0,c61946.length()-1); // extract most of it
		String e61946 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61946.getBytes() ) )); // B64 encode and decode it
		String f61946 = e61946.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g61946 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g61946); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
