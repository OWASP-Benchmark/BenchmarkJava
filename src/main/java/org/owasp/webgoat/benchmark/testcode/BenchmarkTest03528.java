package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03528")
public class BenchmarkTest03528 extends HttpServlet {
	
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
		String a24754 = param; //assign
		StringBuilder b24754 = new StringBuilder(a24754);  // stick in stringbuilder
		b24754.append(" SafeStuff"); // append some safe content
		b24754.replace(b24754.length()-"Chars".length(),b24754.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24754 = new java.util.HashMap<String,Object>();
		map24754.put("key24754", b24754.toString()); // put in a collection
		String c24754 = (String)map24754.get("key24754"); // get it back out
		String d24754 = c24754.substring(0,c24754.length()-1); // extract most of it
		String e24754 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24754.getBytes() ) )); // B64 encode and decode it
		String f24754 = e24754.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f24754); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			Object[] filterArgs = {"a","b"};
			dc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
