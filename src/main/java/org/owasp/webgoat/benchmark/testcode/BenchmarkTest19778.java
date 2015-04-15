package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19778")
public class BenchmarkTest19778 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
		String a46292 = param; //assign
		StringBuilder b46292 = new StringBuilder(a46292);  // stick in stringbuilder
		b46292.append(" SafeStuff"); // append some safe content
		b46292.replace(b46292.length()-"Chars".length(),b46292.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46292 = new java.util.HashMap<String,Object>();
		map46292.put("key46292", b46292.toString()); // put in a collection
		String c46292 = (String)map46292.get("key46292"); // get it back out
		String d46292 = c46292.substring(0,c46292.length()-1); // extract most of it
		String e46292 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46292.getBytes() ) )); // B64 encode and decode it
		String f46292 = e46292.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f46292); // reflection
	
		return bar;	
	}
}
