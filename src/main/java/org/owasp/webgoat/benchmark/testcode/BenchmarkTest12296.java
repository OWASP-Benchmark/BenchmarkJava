package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12296")
public class BenchmarkTest12296 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;

		String bar = new Test().doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a44158 = param; //assign
		StringBuilder b44158 = new StringBuilder(a44158);  // stick in stringbuilder
		b44158.append(" SafeStuff"); // append some safe content
		b44158.replace(b44158.length()-"Chars".length(),b44158.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44158 = new java.util.HashMap<String,Object>();
		map44158.put("key44158", b44158.toString()); // put in a collection
		String c44158 = (String)map44158.get("key44158"); // get it back out
		String d44158 = c44158.substring(0,c44158.length()-1); // extract most of it
		String e44158 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44158.getBytes() ) )); // B64 encode and decode it
		String f44158 = e44158.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f44158); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
