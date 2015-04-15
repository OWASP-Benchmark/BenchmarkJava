package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13640")
public class BenchmarkTest13640 extends HttpServlet {
	
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
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a9081 = param; //assign
		StringBuilder b9081 = new StringBuilder(a9081);  // stick in stringbuilder
		b9081.append(" SafeStuff"); // append some safe content
		b9081.replace(b9081.length()-"Chars".length(),b9081.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9081 = new java.util.HashMap<String,Object>();
		map9081.put("key9081", b9081.toString()); // put in a collection
		String c9081 = (String)map9081.get("key9081"); // get it back out
		String d9081 = c9081.substring(0,c9081.length()-1); // extract most of it
		String e9081 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9081.getBytes() ) )); // B64 encode and decode it
		String f9081 = e9081.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9081); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
