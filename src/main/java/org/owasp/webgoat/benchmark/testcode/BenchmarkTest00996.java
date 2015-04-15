package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00996")
public class BenchmarkTest00996 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a28206 = param; //assign
		StringBuilder b28206 = new StringBuilder(a28206);  // stick in stringbuilder
		b28206.append(" SafeStuff"); // append some safe content
		b28206.replace(b28206.length()-"Chars".length(),b28206.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map28206 = new java.util.HashMap<String,Object>();
		map28206.put("key28206", b28206.toString()); // put in a collection
		String c28206 = (String)map28206.get("key28206"); // get it back out
		String d28206 = c28206.substring(0,c28206.length()-1); // extract most of it
		String e28206 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d28206.getBytes() ) )); // B64 encode and decode it
		String f28206 = e28206.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g28206 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g28206); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			Object[] filterArgs = {"a","b"};
			dc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
