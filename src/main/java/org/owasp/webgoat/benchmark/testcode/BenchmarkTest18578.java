package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18578")
public class BenchmarkTest18578 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a24296 = param; //assign
		StringBuilder b24296 = new StringBuilder(a24296);  // stick in stringbuilder
		b24296.append(" SafeStuff"); // append some safe content
		b24296.replace(b24296.length()-"Chars".length(),b24296.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24296 = new java.util.HashMap<String,Object>();
		map24296.put("key24296", b24296.toString()); // put in a collection
		String c24296 = (String)map24296.get("key24296"); // get it back out
		String d24296 = c24296.substring(0,c24296.length()-1); // extract most of it
		String e24296 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24296.getBytes() ) )); // B64 encode and decode it
		String f24296 = e24296.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g24296 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g24296); // reflection
	
		return bar;	
	}
}
