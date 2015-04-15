package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14755")
public class BenchmarkTest14755 extends HttpServlet {
	
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
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a19789 = param; //assign
		StringBuilder b19789 = new StringBuilder(a19789);  // stick in stringbuilder
		b19789.append(" SafeStuff"); // append some safe content
		b19789.replace(b19789.length()-"Chars".length(),b19789.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19789 = new java.util.HashMap<String,Object>();
		map19789.put("key19789", b19789.toString()); // put in a collection
		String c19789 = (String)map19789.get("key19789"); // get it back out
		String d19789 = c19789.substring(0,c19789.length()-1); // extract most of it
		String e19789 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19789.getBytes() ) )); // B64 encode and decode it
		String f19789 = e19789.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g19789 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g19789); // reflection
	
		return bar;	
	}
}
