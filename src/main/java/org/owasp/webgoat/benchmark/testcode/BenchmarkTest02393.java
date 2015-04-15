package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02393")
public class BenchmarkTest02393 extends HttpServlet {
	
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
		String a56757 = param; //assign
		StringBuilder b56757 = new StringBuilder(a56757);  // stick in stringbuilder
		b56757.append(" SafeStuff"); // append some safe content
		b56757.replace(b56757.length()-"Chars".length(),b56757.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map56757 = new java.util.HashMap<String,Object>();
		map56757.put("key56757", b56757.toString()); // put in a collection
		String c56757 = (String)map56757.get("key56757"); // get it back out
		String d56757 = c56757.substring(0,c56757.length()-1); // extract most of it
		String e56757 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d56757.getBytes() ) )); // B64 encode and decode it
		String f56757 = e56757.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f56757); // reflection
		
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
