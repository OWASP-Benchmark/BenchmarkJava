package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11736")
public class BenchmarkTest11736 extends HttpServlet {
	
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
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a57517 = param; //assign
		StringBuilder b57517 = new StringBuilder(a57517);  // stick in stringbuilder
		b57517.append(" SafeStuff"); // append some safe content
		b57517.replace(b57517.length()-"Chars".length(),b57517.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57517 = new java.util.HashMap<String,Object>();
		map57517.put("key57517", b57517.toString()); // put in a collection
		String c57517 = (String)map57517.get("key57517"); // get it back out
		String d57517 = c57517.substring(0,c57517.length()-1); // extract most of it
		String e57517 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57517.getBytes() ) )); // B64 encode and decode it
		String f57517 = e57517.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g57517 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g57517); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
