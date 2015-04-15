package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08005")
public class BenchmarkTest08005 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52688 = param; //assign
		StringBuilder b52688 = new StringBuilder(a52688);  // stick in stringbuilder
		b52688.append(" SafeStuff"); // append some safe content
		b52688.replace(b52688.length()-"Chars".length(),b52688.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52688 = new java.util.HashMap<String,Object>();
		map52688.put("key52688", b52688.toString()); // put in a collection
		String c52688 = (String)map52688.get("key52688"); // get it back out
		String d52688 = c52688.substring(0,c52688.length()-1); // extract most of it
		String e52688 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52688.getBytes() ) )); // B64 encode and decode it
		String f52688 = e52688.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f52688); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
