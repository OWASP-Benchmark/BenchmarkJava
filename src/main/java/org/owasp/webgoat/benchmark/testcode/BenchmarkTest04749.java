package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04749")
public class BenchmarkTest04749 extends HttpServlet {
	
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
		String a61429 = param; //assign
		StringBuilder b61429 = new StringBuilder(a61429);  // stick in stringbuilder
		b61429.append(" SafeStuff"); // append some safe content
		b61429.replace(b61429.length()-"Chars".length(),b61429.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map61429 = new java.util.HashMap<String,Object>();
		map61429.put("key61429", b61429.toString()); // put in a collection
		String c61429 = (String)map61429.get("key61429"); // get it back out
		String d61429 = c61429.substring(0,c61429.length()-1); // extract most of it
		String e61429 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d61429.getBytes() ) )); // B64 encode and decode it
		String f61429 = e61429.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f61429); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
