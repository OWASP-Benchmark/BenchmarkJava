package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12437")
public class BenchmarkTest12437 extends HttpServlet {
	
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
		
		response.getWriter().print(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a60012 = param; //assign
		StringBuilder b60012 = new StringBuilder(a60012);  // stick in stringbuilder
		b60012.append(" SafeStuff"); // append some safe content
		b60012.replace(b60012.length()-"Chars".length(),b60012.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map60012 = new java.util.HashMap<String,Object>();
		map60012.put("key60012", b60012.toString()); // put in a collection
		String c60012 = (String)map60012.get("key60012"); // get it back out
		String d60012 = c60012.substring(0,c60012.length()-1); // extract most of it
		String e60012 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d60012.getBytes() ) )); // B64 encode and decode it
		String f60012 = e60012.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f60012); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
