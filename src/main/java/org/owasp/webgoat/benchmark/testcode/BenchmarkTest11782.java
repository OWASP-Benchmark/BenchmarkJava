package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11782")
public class BenchmarkTest11782 extends HttpServlet {
	
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
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a58275 = param; //assign
		StringBuilder b58275 = new StringBuilder(a58275);  // stick in stringbuilder
		b58275.append(" SafeStuff"); // append some safe content
		b58275.replace(b58275.length()-"Chars".length(),b58275.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58275 = new java.util.HashMap<String,Object>();
		map58275.put("key58275", b58275.toString()); // put in a collection
		String c58275 = (String)map58275.get("key58275"); // get it back out
		String d58275 = c58275.substring(0,c58275.length()-1); // extract most of it
		String e58275 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d58275.getBytes() ) )); // B64 encode and decode it
		String f58275 = e58275.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f58275); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
