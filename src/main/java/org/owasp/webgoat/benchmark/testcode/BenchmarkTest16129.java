package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16129")
public class BenchmarkTest16129 extends HttpServlet {
	
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
		String a82511 = param; //assign
		StringBuilder b82511 = new StringBuilder(a82511);  // stick in stringbuilder
		b82511.append(" SafeStuff"); // append some safe content
		b82511.replace(b82511.length()-"Chars".length(),b82511.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82511 = new java.util.HashMap<String,Object>();
		map82511.put("key82511", b82511.toString()); // put in a collection
		String c82511 = (String)map82511.get("key82511"); // get it back out
		String d82511 = c82511.substring(0,c82511.length()-1); // extract most of it
		String e82511 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82511.getBytes() ) )); // B64 encode and decode it
		String f82511 = e82511.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f82511); // reflection
	
		return bar;	
	}
}
