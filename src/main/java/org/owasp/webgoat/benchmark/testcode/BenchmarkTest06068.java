package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06068")
public class BenchmarkTest06068 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a83695 = param; //assign
		StringBuilder b83695 = new StringBuilder(a83695);  // stick in stringbuilder
		b83695.append(" SafeStuff"); // append some safe content
		b83695.replace(b83695.length()-"Chars".length(),b83695.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83695 = new java.util.HashMap<String,Object>();
		map83695.put("key83695", b83695.toString()); // put in a collection
		String c83695 = (String)map83695.get("key83695"); // get it back out
		String d83695 = c83695.substring(0,c83695.length()-1); // extract most of it
		String e83695 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83695.getBytes() ) )); // B64 encode and decode it
		String f83695 = e83695.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f83695); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}
}
