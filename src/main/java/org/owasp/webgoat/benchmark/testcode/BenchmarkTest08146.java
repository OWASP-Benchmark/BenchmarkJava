package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08146")
public class BenchmarkTest08146 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a97265 = param; //assign
		StringBuilder b97265 = new StringBuilder(a97265);  // stick in stringbuilder
		b97265.append(" SafeStuff"); // append some safe content
		b97265.replace(b97265.length()-"Chars".length(),b97265.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map97265 = new java.util.HashMap<String,Object>();
		map97265.put("key97265", b97265.toString()); // put in a collection
		String c97265 = (String)map97265.get("key97265"); // get it back out
		String d97265 = c97265.substring(0,c97265.length()-1); // extract most of it
		String e97265 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d97265.getBytes() ) )); // B64 encode and decode it
		String f97265 = e97265.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f97265); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
