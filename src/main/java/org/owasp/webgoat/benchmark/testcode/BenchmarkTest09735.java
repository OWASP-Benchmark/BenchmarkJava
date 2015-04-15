package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09735")
public class BenchmarkTest09735 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a89356 = param; //assign
		StringBuilder b89356 = new StringBuilder(a89356);  // stick in stringbuilder
		b89356.append(" SafeStuff"); // append some safe content
		b89356.replace(b89356.length()-"Chars".length(),b89356.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89356 = new java.util.HashMap<String,Object>();
		map89356.put("key89356", b89356.toString()); // put in a collection
		String c89356 = (String)map89356.get("key89356"); // get it back out
		String d89356 = c89356.substring(0,c89356.length()-1); // extract most of it
		String e89356 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89356.getBytes() ) )); // B64 encode and decode it
		String f89356 = e89356.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f89356); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
