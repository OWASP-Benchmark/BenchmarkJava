package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06020")
public class BenchmarkTest06020 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a77068 = param; //assign
		StringBuilder b77068 = new StringBuilder(a77068);  // stick in stringbuilder
		b77068.append(" SafeStuff"); // append some safe content
		b77068.replace(b77068.length()-"Chars".length(),b77068.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map77068 = new java.util.HashMap<String,Object>();
		map77068.put("key77068", b77068.toString()); // put in a collection
		String c77068 = (String)map77068.get("key77068"); // get it back out
		String d77068 = c77068.substring(0,c77068.length()-1); // extract most of it
		String e77068 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d77068.getBytes() ) )); // B64 encode and decode it
		String f77068 = e77068.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f77068); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
