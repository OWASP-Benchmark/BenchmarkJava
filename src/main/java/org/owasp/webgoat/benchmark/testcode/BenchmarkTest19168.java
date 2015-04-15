package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19168")
public class BenchmarkTest19168 extends HttpServlet {
	
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
		String a35538 = param; //assign
		StringBuilder b35538 = new StringBuilder(a35538);  // stick in stringbuilder
		b35538.append(" SafeStuff"); // append some safe content
		b35538.replace(b35538.length()-"Chars".length(),b35538.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map35538 = new java.util.HashMap<String,Object>();
		map35538.put("key35538", b35538.toString()); // put in a collection
		String c35538 = (String)map35538.get("key35538"); // get it back out
		String d35538 = c35538.substring(0,c35538.length()-1); // extract most of it
		String e35538 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d35538.getBytes() ) )); // B64 encode and decode it
		String f35538 = e35538.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g35538 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g35538); // reflection
	
		return bar;	
	}
}
