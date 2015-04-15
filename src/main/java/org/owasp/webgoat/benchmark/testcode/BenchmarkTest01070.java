package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01070")
public class BenchmarkTest01070 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a69913 = param; //assign
		StringBuilder b69913 = new StringBuilder(a69913);  // stick in stringbuilder
		b69913.append(" SafeStuff"); // append some safe content
		b69913.replace(b69913.length()-"Chars".length(),b69913.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map69913 = new java.util.HashMap<String,Object>();
		map69913.put("key69913", b69913.toString()); // put in a collection
		String c69913 = (String)map69913.get("key69913"); // get it back out
		String d69913 = c69913.substring(0,c69913.length()-1); // extract most of it
		String e69913 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d69913.getBytes() ) )); // B64 encode and decode it
		String f69913 = e69913.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g69913 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g69913); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}
}
