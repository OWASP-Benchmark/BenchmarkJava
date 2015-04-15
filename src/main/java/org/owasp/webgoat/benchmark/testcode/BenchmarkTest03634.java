package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03634")
public class BenchmarkTest03634 extends HttpServlet {
	
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
		String a64549 = param; //assign
		StringBuilder b64549 = new StringBuilder(a64549);  // stick in stringbuilder
		b64549.append(" SafeStuff"); // append some safe content
		b64549.replace(b64549.length()-"Chars".length(),b64549.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64549 = new java.util.HashMap<String,Object>();
		map64549.put("key64549", b64549.toString()); // put in a collection
		String c64549 = (String)map64549.get("key64549"); // get it back out
		String d64549 = c64549.substring(0,c64549.length()-1); // extract most of it
		String e64549 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64549.getBytes() ) )); // B64 encode and decode it
		String f64549 = e64549.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g64549 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64549); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}
}
