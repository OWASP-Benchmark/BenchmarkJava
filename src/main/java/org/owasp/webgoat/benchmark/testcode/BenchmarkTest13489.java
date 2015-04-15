package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13489")
public class BenchmarkTest13489 extends HttpServlet {
	
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
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a89504 = param; //assign
		StringBuilder b89504 = new StringBuilder(a89504);  // stick in stringbuilder
		b89504.append(" SafeStuff"); // append some safe content
		b89504.replace(b89504.length()-"Chars".length(),b89504.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89504 = new java.util.HashMap<String,Object>();
		map89504.put("key89504", b89504.toString()); // put in a collection
		String c89504 = (String)map89504.get("key89504"); // get it back out
		String d89504 = c89504.substring(0,c89504.length()-1); // extract most of it
		String e89504 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89504.getBytes() ) )); // B64 encode and decode it
		String f89504 = e89504.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g89504 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g89504); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
