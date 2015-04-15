package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05010")
public class BenchmarkTest05010 extends HttpServlet {
	
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
		String a61586 = param; //assign
		StringBuilder b61586 = new StringBuilder(a61586);  // stick in stringbuilder
		b61586.append(" SafeStuff"); // append some safe content
		b61586.replace(b61586.length()-"Chars".length(),b61586.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61586 = new java.util.HashMap<String,Object>();
		map61586.put("key61586", b61586.toString()); // put in a collection
		String c61586 = (String)map61586.get("key61586"); // get it back out
		String d61586 = c61586.substring(0,c61586.length()-1); // extract most of it
		String e61586 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61586.getBytes() ) )); // B64 encode and decode it
		String f61586 = e61586.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f61586); // reflection
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
