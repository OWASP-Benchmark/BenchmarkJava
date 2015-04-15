package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12948")
public class BenchmarkTest12948 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52452 = param; //assign
		StringBuilder b52452 = new StringBuilder(a52452);  // stick in stringbuilder
		b52452.append(" SafeStuff"); // append some safe content
		b52452.replace(b52452.length()-"Chars".length(),b52452.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52452 = new java.util.HashMap<String,Object>();
		map52452.put("key52452", b52452.toString()); // put in a collection
		String c52452 = (String)map52452.get("key52452"); // get it back out
		String d52452 = c52452.substring(0,c52452.length()-1); // extract most of it
		String e52452 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52452.getBytes() ) )); // B64 encode and decode it
		String f52452 = e52452.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52452 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52452); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
