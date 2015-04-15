package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10004")
public class BenchmarkTest10004 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a37813 = param; //assign
		StringBuilder b37813 = new StringBuilder(a37813);  // stick in stringbuilder
		b37813.append(" SafeStuff"); // append some safe content
		b37813.replace(b37813.length()-"Chars".length(),b37813.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37813 = new java.util.HashMap<String,Object>();
		map37813.put("key37813", b37813.toString()); // put in a collection
		String c37813 = (String)map37813.get("key37813"); // get it back out
		String d37813 = c37813.substring(0,c37813.length()-1); // extract most of it
		String e37813 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37813.getBytes() ) )); // B64 encode and decode it
		String f37813 = e37813.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f37813); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
