package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01086")
public class BenchmarkTest01086 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a6423 = param; //assign
		StringBuilder b6423 = new StringBuilder(a6423);  // stick in stringbuilder
		b6423.append(" SafeStuff"); // append some safe content
		b6423.replace(b6423.length()-"Chars".length(),b6423.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6423 = new java.util.HashMap<String,Object>();
		map6423.put("key6423", b6423.toString()); // put in a collection
		String c6423 = (String)map6423.get("key6423"); // get it back out
		String d6423 = c6423.substring(0,c6423.length()-1); // extract most of it
		String e6423 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6423.getBytes() ) )); // B64 encode and decode it
		String f6423 = e6423.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g6423 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g6423); // reflection
		
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			Object[] filterArgs = {"a","b"};
			idc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
