package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14763")
public class BenchmarkTest14763 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a90849 = param; //assign
		StringBuilder b90849 = new StringBuilder(a90849);  // stick in stringbuilder
		b90849.append(" SafeStuff"); // append some safe content
		b90849.replace(b90849.length()-"Chars".length(),b90849.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map90849 = new java.util.HashMap<String,Object>();
		map90849.put("key90849", b90849.toString()); // put in a collection
		String c90849 = (String)map90849.get("key90849"); // get it back out
		String d90849 = c90849.substring(0,c90849.length()-1); // extract most of it
		String e90849 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d90849.getBytes() ) )); // B64 encode and decode it
		String f90849 = e90849.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g90849 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g90849); // reflection
	
		return bar;	
	}
}
