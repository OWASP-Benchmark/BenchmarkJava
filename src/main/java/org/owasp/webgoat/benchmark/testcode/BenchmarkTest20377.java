package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20377")
public class BenchmarkTest20377 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a72161 = param; //assign
		StringBuilder b72161 = new StringBuilder(a72161);  // stick in stringbuilder
		b72161.append(" SafeStuff"); // append some safe content
		b72161.replace(b72161.length()-"Chars".length(),b72161.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72161 = new java.util.HashMap<String,Object>();
		map72161.put("key72161", b72161.toString()); // put in a collection
		String c72161 = (String)map72161.get("key72161"); // get it back out
		String d72161 = c72161.substring(0,c72161.length()-1); // extract most of it
		String e72161 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72161.getBytes() ) )); // B64 encode and decode it
		String f72161 = e72161.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f72161); // reflection
	
		return bar;	
	}
}
