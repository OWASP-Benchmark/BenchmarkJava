package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15502")
public class BenchmarkTest15502 extends HttpServlet {
	
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
			Object[] filterArgs = {"a","b"};
			idc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a57763 = param; //assign
		StringBuilder b57763 = new StringBuilder(a57763);  // stick in stringbuilder
		b57763.append(" SafeStuff"); // append some safe content
		b57763.replace(b57763.length()-"Chars".length(),b57763.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57763 = new java.util.HashMap<String,Object>();
		map57763.put("key57763", b57763.toString()); // put in a collection
		String c57763 = (String)map57763.get("key57763"); // get it back out
		String d57763 = c57763.substring(0,c57763.length()-1); // extract most of it
		String e57763 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57763.getBytes() ) )); // B64 encode and decode it
		String f57763 = e57763.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f57763); // reflection
	
		return bar;	
	}
}
