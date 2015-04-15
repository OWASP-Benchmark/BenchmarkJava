package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11666")
public class BenchmarkTest11666 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a11279 = param; //assign
		StringBuilder b11279 = new StringBuilder(a11279);  // stick in stringbuilder
		b11279.append(" SafeStuff"); // append some safe content
		b11279.replace(b11279.length()-"Chars".length(),b11279.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map11279 = new java.util.HashMap<String,Object>();
		map11279.put("key11279", b11279.toString()); // put in a collection
		String c11279 = (String)map11279.get("key11279"); // get it back out
		String d11279 = c11279.substring(0,c11279.length()-1); // extract most of it
		String e11279 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d11279.getBytes() ) )); // B64 encode and decode it
		String f11279 = e11279.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f11279); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
