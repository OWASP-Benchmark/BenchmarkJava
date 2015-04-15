package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13480")
public class BenchmarkTest13480 extends HttpServlet {
	
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
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a28509 = param; //assign
		StringBuilder b28509 = new StringBuilder(a28509);  // stick in stringbuilder
		b28509.append(" SafeStuff"); // append some safe content
		b28509.replace(b28509.length()-"Chars".length(),b28509.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map28509 = new java.util.HashMap<String,Object>();
		map28509.put("key28509", b28509.toString()); // put in a collection
		String c28509 = (String)map28509.get("key28509"); // get it back out
		String d28509 = c28509.substring(0,c28509.length()-1); // extract most of it
		String e28509 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d28509.getBytes() ) )); // B64 encode and decode it
		String f28509 = e28509.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f28509); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
