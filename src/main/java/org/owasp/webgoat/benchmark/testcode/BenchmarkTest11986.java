package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11986")
public class BenchmarkTest11986 extends HttpServlet {
	
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
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87597 = param; //assign
		StringBuilder b87597 = new StringBuilder(a87597);  // stick in stringbuilder
		b87597.append(" SafeStuff"); // append some safe content
		b87597.replace(b87597.length()-"Chars".length(),b87597.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87597 = new java.util.HashMap<String,Object>();
		map87597.put("key87597", b87597.toString()); // put in a collection
		String c87597 = (String)map87597.get("key87597"); // get it back out
		String d87597 = c87597.substring(0,c87597.length()-1); // extract most of it
		String e87597 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87597.getBytes() ) )); // B64 encode and decode it
		String f87597 = e87597.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f87597); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
