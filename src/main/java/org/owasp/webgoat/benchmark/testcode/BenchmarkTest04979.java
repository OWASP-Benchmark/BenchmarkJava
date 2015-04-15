package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04979")
public class BenchmarkTest04979 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a18317 = param; //assign
		StringBuilder b18317 = new StringBuilder(a18317);  // stick in stringbuilder
		b18317.append(" SafeStuff"); // append some safe content
		b18317.replace(b18317.length()-"Chars".length(),b18317.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18317 = new java.util.HashMap<String,Object>();
		map18317.put("key18317", b18317.toString()); // put in a collection
		String c18317 = (String)map18317.get("key18317"); // get it back out
		String d18317 = c18317.substring(0,c18317.length()-1); // extract most of it
		String e18317 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18317.getBytes() ) )); // B64 encode and decode it
		String f18317 = e18317.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g18317 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g18317); // reflection
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
