package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16138")
public class BenchmarkTest16138 extends HttpServlet {
	
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
			idc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a18497 = param; //assign
		StringBuilder b18497 = new StringBuilder(a18497);  // stick in stringbuilder
		b18497.append(" SafeStuff"); // append some safe content
		b18497.replace(b18497.length()-"Chars".length(),b18497.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18497 = new java.util.HashMap<String,Object>();
		map18497.put("key18497", b18497.toString()); // put in a collection
		String c18497 = (String)map18497.get("key18497"); // get it back out
		String d18497 = c18497.substring(0,c18497.length()-1); // extract most of it
		String e18497 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18497.getBytes() ) )); // B64 encode and decode it
		String f18497 = e18497.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f18497); // reflection
	
		return bar;	
	}
}
