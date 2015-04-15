package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20452")
public class BenchmarkTest20452 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a75954 = param; //assign
		StringBuilder b75954 = new StringBuilder(a75954);  // stick in stringbuilder
		b75954.append(" SafeStuff"); // append some safe content
		b75954.replace(b75954.length()-"Chars".length(),b75954.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75954 = new java.util.HashMap<String,Object>();
		map75954.put("key75954", b75954.toString()); // put in a collection
		String c75954 = (String)map75954.get("key75954"); // get it back out
		String d75954 = c75954.substring(0,c75954.length()-1); // extract most of it
		String e75954 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75954.getBytes() ) )); // B64 encode and decode it
		String f75954 = e75954.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g75954 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g75954); // reflection
	
		return bar;	
	}
}
