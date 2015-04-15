package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02353")
public class BenchmarkTest02353 extends HttpServlet {
	
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
		String a89263 = param; //assign
		StringBuilder b89263 = new StringBuilder(a89263);  // stick in stringbuilder
		b89263.append(" SafeStuff"); // append some safe content
		b89263.replace(b89263.length()-"Chars".length(),b89263.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89263 = new java.util.HashMap<String,Object>();
		map89263.put("key89263", b89263.toString()); // put in a collection
		String c89263 = (String)map89263.get("key89263"); // get it back out
		String d89263 = c89263.substring(0,c89263.length()-1); // extract most of it
		String e89263 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89263.getBytes() ) )); // B64 encode and decode it
		String f89263 = e89263.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g89263 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g89263); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}
}
