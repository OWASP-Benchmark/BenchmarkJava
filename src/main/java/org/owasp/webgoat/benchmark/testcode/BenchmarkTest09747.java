package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09747")
public class BenchmarkTest09747 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3212 = param; //assign
		StringBuilder b3212 = new StringBuilder(a3212);  // stick in stringbuilder
		b3212.append(" SafeStuff"); // append some safe content
		b3212.replace(b3212.length()-"Chars".length(),b3212.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3212 = new java.util.HashMap<String,Object>();
		map3212.put("key3212", b3212.toString()); // put in a collection
		String c3212 = (String)map3212.get("key3212"); // get it back out
		String d3212 = c3212.substring(0,c3212.length()-1); // extract most of it
		String e3212 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3212.getBytes() ) )); // B64 encode and decode it
		String f3212 = e3212.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f3212); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
