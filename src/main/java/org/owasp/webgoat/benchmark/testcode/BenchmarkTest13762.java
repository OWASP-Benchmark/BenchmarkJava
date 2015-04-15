package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13762")
public class BenchmarkTest13762 extends HttpServlet {
	
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
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a62840 = param; //assign
		StringBuilder b62840 = new StringBuilder(a62840);  // stick in stringbuilder
		b62840.append(" SafeStuff"); // append some safe content
		b62840.replace(b62840.length()-"Chars".length(),b62840.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map62840 = new java.util.HashMap<String,Object>();
		map62840.put("key62840", b62840.toString()); // put in a collection
		String c62840 = (String)map62840.get("key62840"); // get it back out
		String d62840 = c62840.substring(0,c62840.length()-1); // extract most of it
		String e62840 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d62840.getBytes() ) )); // B64 encode and decode it
		String f62840 = e62840.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g62840 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g62840); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
