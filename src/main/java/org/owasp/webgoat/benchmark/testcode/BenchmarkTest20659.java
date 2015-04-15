package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20659")
public class BenchmarkTest20659 extends HttpServlet {
	
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
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43836 = param; //assign
		StringBuilder b43836 = new StringBuilder(a43836);  // stick in stringbuilder
		b43836.append(" SafeStuff"); // append some safe content
		b43836.replace(b43836.length()-"Chars".length(),b43836.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43836 = new java.util.HashMap<String,Object>();
		map43836.put("key43836", b43836.toString()); // put in a collection
		String c43836 = (String)map43836.get("key43836"); // get it back out
		String d43836 = c43836.substring(0,c43836.length()-1); // extract most of it
		String e43836 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43836.getBytes() ) )); // B64 encode and decode it
		String f43836 = e43836.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g43836 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43836); // reflection
	
		return bar;	
	}
}
