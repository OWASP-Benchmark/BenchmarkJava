package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18838")
public class BenchmarkTest18838 extends HttpServlet {
	
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
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a50078 = param; //assign
		StringBuilder b50078 = new StringBuilder(a50078);  // stick in stringbuilder
		b50078.append(" SafeStuff"); // append some safe content
		b50078.replace(b50078.length()-"Chars".length(),b50078.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map50078 = new java.util.HashMap<String,Object>();
		map50078.put("key50078", b50078.toString()); // put in a collection
		String c50078 = (String)map50078.get("key50078"); // get it back out
		String d50078 = c50078.substring(0,c50078.length()-1); // extract most of it
		String e50078 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d50078.getBytes() ) )); // B64 encode and decode it
		String f50078 = e50078.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g50078 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g50078); // reflection
	
		return bar;	
	}
}
