package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08045")
public class BenchmarkTest08045 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		response.getWriter().println(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a89726 = param; //assign
		StringBuilder b89726 = new StringBuilder(a89726);  // stick in stringbuilder
		b89726.append(" SafeStuff"); // append some safe content
		b89726.replace(b89726.length()-"Chars".length(),b89726.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89726 = new java.util.HashMap<String,Object>();
		map89726.put("key89726", b89726.toString()); // put in a collection
		String c89726 = (String)map89726.get("key89726"); // get it back out
		String d89726 = c89726.substring(0,c89726.length()-1); // extract most of it
		String e89726 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89726.getBytes() ) )); // B64 encode and decode it
		String f89726 = e89726.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f89726); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
