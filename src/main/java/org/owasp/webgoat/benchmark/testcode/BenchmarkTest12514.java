package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12514")
public class BenchmarkTest12514 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a37667 = param; //assign
		StringBuilder b37667 = new StringBuilder(a37667);  // stick in stringbuilder
		b37667.append(" SafeStuff"); // append some safe content
		b37667.replace(b37667.length()-"Chars".length(),b37667.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37667 = new java.util.HashMap<String,Object>();
		map37667.put("key37667", b37667.toString()); // put in a collection
		String c37667 = (String)map37667.get("key37667"); // get it back out
		String d37667 = c37667.substring(0,c37667.length()-1); // extract most of it
		String e37667 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37667.getBytes() ) )); // B64 encode and decode it
		String f37667 = e37667.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f37667); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
