package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06634")
public class BenchmarkTest06634 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a90025 = param; //assign
		StringBuilder b90025 = new StringBuilder(a90025);  // stick in stringbuilder
		b90025.append(" SafeStuff"); // append some safe content
		b90025.replace(b90025.length()-"Chars".length(),b90025.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map90025 = new java.util.HashMap<String,Object>();
		map90025.put("key90025", b90025.toString()); // put in a collection
		String c90025 = (String)map90025.get("key90025"); // get it back out
		String d90025 = c90025.substring(0,c90025.length()-1); // extract most of it
		String e90025 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d90025.getBytes() ) )); // B64 encode and decode it
		String f90025 = e90025.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f90025); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
