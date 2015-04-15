package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13546")
public class BenchmarkTest13546 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a83953 = param; //assign
		StringBuilder b83953 = new StringBuilder(a83953);  // stick in stringbuilder
		b83953.append(" SafeStuff"); // append some safe content
		b83953.replace(b83953.length()-"Chars".length(),b83953.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83953 = new java.util.HashMap<String,Object>();
		map83953.put("key83953", b83953.toString()); // put in a collection
		String c83953 = (String)map83953.get("key83953"); // get it back out
		String d83953 = c83953.substring(0,c83953.length()-1); // extract most of it
		String e83953 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83953.getBytes() ) )); // B64 encode and decode it
		String f83953 = e83953.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g83953 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g83953); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
