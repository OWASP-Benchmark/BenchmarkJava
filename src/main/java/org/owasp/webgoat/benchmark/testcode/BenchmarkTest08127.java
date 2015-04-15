package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08127")
public class BenchmarkTest08127 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a37659 = param; //assign
		StringBuilder b37659 = new StringBuilder(a37659);  // stick in stringbuilder
		b37659.append(" SafeStuff"); // append some safe content
		b37659.replace(b37659.length()-"Chars".length(),b37659.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37659 = new java.util.HashMap<String,Object>();
		map37659.put("key37659", b37659.toString()); // put in a collection
		String c37659 = (String)map37659.get("key37659"); // get it back out
		String d37659 = c37659.substring(0,c37659.length()-1); // extract most of it
		String e37659 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37659.getBytes() ) )); // B64 encode and decode it
		String f37659 = e37659.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g37659 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g37659); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
