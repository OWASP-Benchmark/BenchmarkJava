package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17368")
public class BenchmarkTest17368 extends HttpServlet {
	
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
		String a64830 = param; //assign
		StringBuilder b64830 = new StringBuilder(a64830);  // stick in stringbuilder
		b64830.append(" SafeStuff"); // append some safe content
		b64830.replace(b64830.length()-"Chars".length(),b64830.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64830 = new java.util.HashMap<String,Object>();
		map64830.put("key64830", b64830.toString()); // put in a collection
		String c64830 = (String)map64830.get("key64830"); // get it back out
		String d64830 = c64830.substring(0,c64830.length()-1); // extract most of it
		String e64830 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64830.getBytes() ) )); // B64 encode and decode it
		String f64830 = e64830.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f64830); // reflection
	
		return bar;	
	}
}
