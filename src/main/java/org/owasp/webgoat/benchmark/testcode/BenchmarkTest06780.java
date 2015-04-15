package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06780")
public class BenchmarkTest06780 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a35912 = param; //assign
		StringBuilder b35912 = new StringBuilder(a35912);  // stick in stringbuilder
		b35912.append(" SafeStuff"); // append some safe content
		b35912.replace(b35912.length()-"Chars".length(),b35912.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35912 = new java.util.HashMap<String,Object>();
		map35912.put("key35912", b35912.toString()); // put in a collection
		String c35912 = (String)map35912.get("key35912"); // get it back out
		String d35912 = c35912.substring(0,c35912.length()-1); // extract most of it
		String e35912 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35912.getBytes() ) )); // B64 encode and decode it
		String f35912 = e35912.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g35912 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g35912); // reflection
		
		
		response.getWriter().print(bar.toCharArray());
	}
}
