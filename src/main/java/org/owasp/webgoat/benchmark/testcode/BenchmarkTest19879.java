package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19879")
public class BenchmarkTest19879 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

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
		String a72557 = param; //assign
		StringBuilder b72557 = new StringBuilder(a72557);  // stick in stringbuilder
		b72557.append(" SafeStuff"); // append some safe content
		b72557.replace(b72557.length()-"Chars".length(),b72557.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72557 = new java.util.HashMap<String,Object>();
		map72557.put("key72557", b72557.toString()); // put in a collection
		String c72557 = (String)map72557.get("key72557"); // get it back out
		String d72557 = c72557.substring(0,c72557.length()-1); // extract most of it
		String e72557 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72557.getBytes() ) )); // B64 encode and decode it
		String f72557 = e72557.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g72557 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g72557); // reflection
	
		return bar;	
	}
}
