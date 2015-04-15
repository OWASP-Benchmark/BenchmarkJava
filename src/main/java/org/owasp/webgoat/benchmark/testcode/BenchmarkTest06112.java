package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06112")
public class BenchmarkTest06112 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a78253 = param; //assign
		StringBuilder b78253 = new StringBuilder(a78253);  // stick in stringbuilder
		b78253.append(" SafeStuff"); // append some safe content
		b78253.replace(b78253.length()-"Chars".length(),b78253.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map78253 = new java.util.HashMap<String,Object>();
		map78253.put("key78253", b78253.toString()); // put in a collection
		String c78253 = (String)map78253.get("key78253"); // get it back out
		String d78253 = c78253.substring(0,c78253.length()-1); // extract most of it
		String e78253 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d78253.getBytes() ) )); // B64 encode and decode it
		String f78253 = e78253.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f78253); // reflection
		
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
