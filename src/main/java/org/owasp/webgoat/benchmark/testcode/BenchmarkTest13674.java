package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13674")
public class BenchmarkTest13674 extends HttpServlet {
	
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
		
		Object[] obj = { "a", bar};
		response.getWriter().println(obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3350 = param; //assign
		StringBuilder b3350 = new StringBuilder(a3350);  // stick in stringbuilder
		b3350.append(" SafeStuff"); // append some safe content
		b3350.replace(b3350.length()-"Chars".length(),b3350.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3350 = new java.util.HashMap<String,Object>();
		map3350.put("key3350", b3350.toString()); // put in a collection
		String c3350 = (String)map3350.get("key3350"); // get it back out
		String d3350 = c3350.substring(0,c3350.length()-1); // extract most of it
		String e3350 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3350.getBytes() ) )); // B64 encode and decode it
		String f3350 = e3350.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3350); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
