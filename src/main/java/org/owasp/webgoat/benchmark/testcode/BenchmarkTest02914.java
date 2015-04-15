package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02914")
public class BenchmarkTest02914 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a34494 = param; //assign
		StringBuilder b34494 = new StringBuilder(a34494);  // stick in stringbuilder
		b34494.append(" SafeStuff"); // append some safe content
		b34494.replace(b34494.length()-"Chars".length(),b34494.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map34494 = new java.util.HashMap<String,Object>();
		map34494.put("key34494", b34494.toString()); // put in a collection
		String c34494 = (String)map34494.get("key34494"); // get it back out
		String d34494 = c34494.substring(0,c34494.length()-1); // extract most of it
		String e34494 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d34494.getBytes() ) )); // B64 encode and decode it
		String f34494 = e34494.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g34494 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g34494); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
