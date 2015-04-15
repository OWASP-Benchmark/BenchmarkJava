package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13841")
public class BenchmarkTest13841 extends HttpServlet {
	
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
		
		response.setHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a41976 = param; //assign
		StringBuilder b41976 = new StringBuilder(a41976);  // stick in stringbuilder
		b41976.append(" SafeStuff"); // append some safe content
		b41976.replace(b41976.length()-"Chars".length(),b41976.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map41976 = new java.util.HashMap<String,Object>();
		map41976.put("key41976", b41976.toString()); // put in a collection
		String c41976 = (String)map41976.get("key41976"); // get it back out
		String d41976 = c41976.substring(0,c41976.length()-1); // extract most of it
		String e41976 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d41976.getBytes() ) )); // B64 encode and decode it
		String f41976 = e41976.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f41976); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
