package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01092")
public class BenchmarkTest01092 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a52852 = param; //assign
		StringBuilder b52852 = new StringBuilder(a52852);  // stick in stringbuilder
		b52852.append(" SafeStuff"); // append some safe content
		b52852.replace(b52852.length()-"Chars".length(),b52852.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52852 = new java.util.HashMap<String,Object>();
		map52852.put("key52852", b52852.toString()); // put in a collection
		String c52852 = (String)map52852.get("key52852"); // get it back out
		String d52852 = c52852.substring(0,c52852.length()-1); // extract most of it
		String e52852 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52852.getBytes() ) )); // B64 encode and decode it
		String f52852 = e52852.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52852 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52852); // reflection
		
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
