package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14867")
public class BenchmarkTest14867 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a97155 = param; //assign
		StringBuilder b97155 = new StringBuilder(a97155);  // stick in stringbuilder
		b97155.append(" SafeStuff"); // append some safe content
		b97155.replace(b97155.length()-"Chars".length(),b97155.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map97155 = new java.util.HashMap<String,Object>();
		map97155.put("key97155", b97155.toString()); // put in a collection
		String c97155 = (String)map97155.get("key97155"); // get it back out
		String d97155 = c97155.substring(0,c97155.length()-1); // extract most of it
		String e97155 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d97155.getBytes() ) )); // B64 encode and decode it
		String f97155 = e97155.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g97155 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g97155); // reflection
	
		return bar;	
	}
}
