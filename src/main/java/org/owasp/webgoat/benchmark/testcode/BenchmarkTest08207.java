package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08207")
public class BenchmarkTest08207 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a49450 = param; //assign
		StringBuilder b49450 = new StringBuilder(a49450);  // stick in stringbuilder
		b49450.append(" SafeStuff"); // append some safe content
		b49450.replace(b49450.length()-"Chars".length(),b49450.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49450 = new java.util.HashMap<String,Object>();
		map49450.put("key49450", b49450.toString()); // put in a collection
		String c49450 = (String)map49450.get("key49450"); // get it back out
		String d49450 = c49450.substring(0,c49450.length()-1); // extract most of it
		String e49450 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49450.getBytes() ) )); // B64 encode and decode it
		String f49450 = e49450.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g49450 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g49450); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
