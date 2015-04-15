package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12007")
public class BenchmarkTest12007 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a458 = param; //assign
		StringBuilder b458 = new StringBuilder(a458);  // stick in stringbuilder
		b458.append(" SafeStuff"); // append some safe content
		b458.replace(b458.length()-"Chars".length(),b458.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map458 = new java.util.HashMap<String,Object>();
		map458.put("key458", b458.toString()); // put in a collection
		String c458 = (String)map458.get("key458"); // get it back out
		String d458 = c458.substring(0,c458.length()-1); // extract most of it
		String e458 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d458.getBytes() ) )); // B64 encode and decode it
		String f458 = e458.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f458); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
