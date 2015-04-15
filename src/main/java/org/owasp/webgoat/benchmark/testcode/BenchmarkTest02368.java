package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02368")
public class BenchmarkTest02368 extends HttpServlet {
	
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
		String a89779 = param; //assign
		StringBuilder b89779 = new StringBuilder(a89779);  // stick in stringbuilder
		b89779.append(" SafeStuff"); // append some safe content
		b89779.replace(b89779.length()-"Chars".length(),b89779.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89779 = new java.util.HashMap<String,Object>();
		map89779.put("key89779", b89779.toString()); // put in a collection
		String c89779 = (String)map89779.get("key89779"); // get it back out
		String d89779 = c89779.substring(0,c89779.length()-1); // extract most of it
		String e89779 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89779.getBytes() ) )); // B64 encode and decode it
		String f89779 = e89779.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f89779); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}
}
