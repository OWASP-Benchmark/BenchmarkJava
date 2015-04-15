package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13696")
public class BenchmarkTest13696 extends HttpServlet {
	
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
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a23774 = param; //assign
		StringBuilder b23774 = new StringBuilder(a23774);  // stick in stringbuilder
		b23774.append(" SafeStuff"); // append some safe content
		b23774.replace(b23774.length()-"Chars".length(),b23774.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map23774 = new java.util.HashMap<String,Object>();
		map23774.put("key23774", b23774.toString()); // put in a collection
		String c23774 = (String)map23774.get("key23774"); // get it back out
		String d23774 = c23774.substring(0,c23774.length()-1); // extract most of it
		String e23774 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d23774.getBytes() ) )); // B64 encode and decode it
		String f23774 = e23774.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f23774); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
