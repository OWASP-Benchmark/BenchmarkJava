package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13549")
public class BenchmarkTest13549 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a54915 = param; //assign
		StringBuilder b54915 = new StringBuilder(a54915);  // stick in stringbuilder
		b54915.append(" SafeStuff"); // append some safe content
		b54915.replace(b54915.length()-"Chars".length(),b54915.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map54915 = new java.util.HashMap<String,Object>();
		map54915.put("key54915", b54915.toString()); // put in a collection
		String c54915 = (String)map54915.get("key54915"); // get it back out
		String d54915 = c54915.substring(0,c54915.length()-1); // extract most of it
		String e54915 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d54915.getBytes() ) )); // B64 encode and decode it
		String f54915 = e54915.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f54915); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
