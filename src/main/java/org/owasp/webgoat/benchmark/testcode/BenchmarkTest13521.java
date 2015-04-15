package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13521")
public class BenchmarkTest13521 extends HttpServlet {
	
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
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a47504 = param; //assign
		StringBuilder b47504 = new StringBuilder(a47504);  // stick in stringbuilder
		b47504.append(" SafeStuff"); // append some safe content
		b47504.replace(b47504.length()-"Chars".length(),b47504.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47504 = new java.util.HashMap<String,Object>();
		map47504.put("key47504", b47504.toString()); // put in a collection
		String c47504 = (String)map47504.get("key47504"); // get it back out
		String d47504 = c47504.substring(0,c47504.length()-1); // extract most of it
		String e47504 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47504.getBytes() ) )); // B64 encode and decode it
		String f47504 = e47504.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f47504); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
