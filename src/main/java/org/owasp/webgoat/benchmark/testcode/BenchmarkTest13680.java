package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13680")
public class BenchmarkTest13680 extends HttpServlet {
	
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
		
		response.getWriter().println(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a98788 = param; //assign
		StringBuilder b98788 = new StringBuilder(a98788);  // stick in stringbuilder
		b98788.append(" SafeStuff"); // append some safe content
		b98788.replace(b98788.length()-"Chars".length(),b98788.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map98788 = new java.util.HashMap<String,Object>();
		map98788.put("key98788", b98788.toString()); // put in a collection
		String c98788 = (String)map98788.get("key98788"); // get it back out
		String d98788 = c98788.substring(0,c98788.length()-1); // extract most of it
		String e98788 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d98788.getBytes() ) )); // B64 encode and decode it
		String f98788 = e98788.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f98788); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
