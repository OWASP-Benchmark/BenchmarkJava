package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03538")
public class BenchmarkTest03538 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a12858 = param; //assign
		StringBuilder b12858 = new StringBuilder(a12858);  // stick in stringbuilder
		b12858.append(" SafeStuff"); // append some safe content
		b12858.replace(b12858.length()-"Chars".length(),b12858.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map12858 = new java.util.HashMap<String,Object>();
		map12858.put("key12858", b12858.toString()); // put in a collection
		String c12858 = (String)map12858.get("key12858"); // get it back out
		String d12858 = c12858.substring(0,c12858.length()-1); // extract most of it
		String e12858 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d12858.getBytes() ) )); // B64 encode and decode it
		String f12858 = e12858.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f12858); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
