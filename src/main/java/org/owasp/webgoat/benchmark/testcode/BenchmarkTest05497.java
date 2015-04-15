package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05497")
public class BenchmarkTest05497 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a83569 = param; //assign
		StringBuilder b83569 = new StringBuilder(a83569);  // stick in stringbuilder
		b83569.append(" SafeStuff"); // append some safe content
		b83569.replace(b83569.length()-"Chars".length(),b83569.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83569 = new java.util.HashMap<String,Object>();
		map83569.put("key83569", b83569.toString()); // put in a collection
		String c83569 = (String)map83569.get("key83569"); // get it back out
		String d83569 = c83569.substring(0,c83569.length()-1); // extract most of it
		String e83569 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83569.getBytes() ) )); // B64 encode and decode it
		String f83569 = e83569.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f83569); // reflection
		
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			Object[] filterArgs = {"a","b"};
			idc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
