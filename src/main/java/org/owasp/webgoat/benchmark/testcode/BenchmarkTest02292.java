package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02292")
public class BenchmarkTest02292 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a5664 = param; //assign
		StringBuilder b5664 = new StringBuilder(a5664);  // stick in stringbuilder
		b5664.append(" SafeStuff"); // append some safe content
		b5664.replace(b5664.length()-"Chars".length(),b5664.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map5664 = new java.util.HashMap<String,Object>();
		map5664.put("key5664", b5664.toString()); // put in a collection
		String c5664 = (String)map5664.get("key5664"); // get it back out
		String d5664 = c5664.substring(0,c5664.length()-1); // extract most of it
		String e5664 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d5664.getBytes() ) )); // B64 encode and decode it
		String f5664 = e5664.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g5664 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g5664); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			Object[] filterArgs = {"a","b"};
			dc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
