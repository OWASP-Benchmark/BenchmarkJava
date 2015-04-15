package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08140")
public class BenchmarkTest08140 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a92821 = param; //assign
		StringBuilder b92821 = new StringBuilder(a92821);  // stick in stringbuilder
		b92821.append(" SafeStuff"); // append some safe content
		b92821.replace(b92821.length()-"Chars".length(),b92821.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92821 = new java.util.HashMap<String,Object>();
		map92821.put("key92821", b92821.toString()); // put in a collection
		String c92821 = (String)map92821.get("key92821"); // get it back out
		String d92821 = c92821.substring(0,c92821.length()-1); // extract most of it
		String e92821 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92821.getBytes() ) )); // B64 encode and decode it
		String f92821 = e92821.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g92821 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g92821); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
