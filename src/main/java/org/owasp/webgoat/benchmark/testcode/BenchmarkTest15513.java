package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15513")
public class BenchmarkTest15513 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

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
		String a86239 = param; //assign
		StringBuilder b86239 = new StringBuilder(a86239);  // stick in stringbuilder
		b86239.append(" SafeStuff"); // append some safe content
		b86239.replace(b86239.length()-"Chars".length(),b86239.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86239 = new java.util.HashMap<String,Object>();
		map86239.put("key86239", b86239.toString()); // put in a collection
		String c86239 = (String)map86239.get("key86239"); // get it back out
		String d86239 = c86239.substring(0,c86239.length()-1); // extract most of it
		String e86239 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86239.getBytes() ) )); // B64 encode and decode it
		String f86239 = e86239.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f86239); // reflection
	
		return bar;	
	}
}
