package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13650")
public class BenchmarkTest13650 extends HttpServlet {
	
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
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a40696 = param; //assign
		StringBuilder b40696 = new StringBuilder(a40696);  // stick in stringbuilder
		b40696.append(" SafeStuff"); // append some safe content
		b40696.replace(b40696.length()-"Chars".length(),b40696.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40696 = new java.util.HashMap<String,Object>();
		map40696.put("key40696", b40696.toString()); // put in a collection
		String c40696 = (String)map40696.get("key40696"); // get it back out
		String d40696 = c40696.substring(0,c40696.length()-1); // extract most of it
		String e40696 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40696.getBytes() ) )); // B64 encode and decode it
		String f40696 = e40696.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40696); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
