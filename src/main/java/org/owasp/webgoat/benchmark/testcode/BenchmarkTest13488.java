package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13488")
public class BenchmarkTest13488 extends HttpServlet {
	
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
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a68345 = param; //assign
		StringBuilder b68345 = new StringBuilder(a68345);  // stick in stringbuilder
		b68345.append(" SafeStuff"); // append some safe content
		b68345.replace(b68345.length()-"Chars".length(),b68345.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68345 = new java.util.HashMap<String,Object>();
		map68345.put("key68345", b68345.toString()); // put in a collection
		String c68345 = (String)map68345.get("key68345"); // get it back out
		String d68345 = c68345.substring(0,c68345.length()-1); // extract most of it
		String e68345 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68345.getBytes() ) )); // B64 encode and decode it
		String f68345 = e68345.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f68345); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
