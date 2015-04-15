package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01635")
public class BenchmarkTest01635 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a43892 = param; //assign
		StringBuilder b43892 = new StringBuilder(a43892);  // stick in stringbuilder
		b43892.append(" SafeStuff"); // append some safe content
		b43892.replace(b43892.length()-"Chars".length(),b43892.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43892 = new java.util.HashMap<String,Object>();
		map43892.put("key43892", b43892.toString()); // put in a collection
		String c43892 = (String)map43892.get("key43892"); // get it back out
		String d43892 = c43892.substring(0,c43892.length()-1); // extract most of it
		String e43892 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43892.getBytes() ) )); // B64 encode and decode it
		String f43892 = e43892.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f43892); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			Object[] filterArgs = {"a","b"};
			dc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
