package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11999")
public class BenchmarkTest11999 extends HttpServlet {
	
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
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a68470 = param; //assign
		StringBuilder b68470 = new StringBuilder(a68470);  // stick in stringbuilder
		b68470.append(" SafeStuff"); // append some safe content
		b68470.replace(b68470.length()-"Chars".length(),b68470.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68470 = new java.util.HashMap<String,Object>();
		map68470.put("key68470", b68470.toString()); // put in a collection
		String c68470 = (String)map68470.get("key68470"); // get it back out
		String d68470 = c68470.substring(0,c68470.length()-1); // extract most of it
		String e68470 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68470.getBytes() ) )); // B64 encode and decode it
		String f68470 = e68470.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f68470); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
