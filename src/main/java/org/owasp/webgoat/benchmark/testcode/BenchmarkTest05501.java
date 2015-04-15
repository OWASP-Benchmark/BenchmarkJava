package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05501")
public class BenchmarkTest05501 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a13303 = param; //assign
		StringBuilder b13303 = new StringBuilder(a13303);  // stick in stringbuilder
		b13303.append(" SafeStuff"); // append some safe content
		b13303.replace(b13303.length()-"Chars".length(),b13303.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13303 = new java.util.HashMap<String,Object>();
		map13303.put("key13303", b13303.toString()); // put in a collection
		String c13303 = (String)map13303.get("key13303"); // get it back out
		String d13303 = c13303.substring(0,c13303.length()-1); // extract most of it
		String e13303 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13303.getBytes() ) )); // B64 encode and decode it
		String f13303 = e13303.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f13303); // reflection
		
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
