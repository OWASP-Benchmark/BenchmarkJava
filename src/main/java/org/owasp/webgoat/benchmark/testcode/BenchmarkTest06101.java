package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06101")
public class BenchmarkTest06101 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a2836 = param; //assign
		StringBuilder b2836 = new StringBuilder(a2836);  // stick in stringbuilder
		b2836.append(" SafeStuff"); // append some safe content
		b2836.replace(b2836.length()-"Chars".length(),b2836.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map2836 = new java.util.HashMap<String,Object>();
		map2836.put("key2836", b2836.toString()); // put in a collection
		String c2836 = (String)map2836.get("key2836"); // get it back out
		String d2836 = c2836.substring(0,c2836.length()-1); // extract most of it
		String e2836 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d2836.getBytes() ) )); // B64 encode and decode it
		String f2836 = e2836.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f2836); // reflection
		
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			Object[] filterArgs = {"a","b"};
			idc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
