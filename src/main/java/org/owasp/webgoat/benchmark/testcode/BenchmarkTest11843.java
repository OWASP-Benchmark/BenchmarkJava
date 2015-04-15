package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11843")
public class BenchmarkTest11843 extends HttpServlet {
	
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
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a31490 = param; //assign
		StringBuilder b31490 = new StringBuilder(a31490);  // stick in stringbuilder
		b31490.append(" SafeStuff"); // append some safe content
		b31490.replace(b31490.length()-"Chars".length(),b31490.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31490 = new java.util.HashMap<String,Object>();
		map31490.put("key31490", b31490.toString()); // put in a collection
		String c31490 = (String)map31490.get("key31490"); // get it back out
		String d31490 = c31490.substring(0,c31490.length()-1); // extract most of it
		String e31490 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31490.getBytes() ) )); // B64 encode and decode it
		String f31490 = e31490.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f31490); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
