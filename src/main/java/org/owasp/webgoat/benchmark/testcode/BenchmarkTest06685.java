package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06685")
public class BenchmarkTest06685 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a92641 = param; //assign
		StringBuilder b92641 = new StringBuilder(a92641);  // stick in stringbuilder
		b92641.append(" SafeStuff"); // append some safe content
		b92641.replace(b92641.length()-"Chars".length(),b92641.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92641 = new java.util.HashMap<String,Object>();
		map92641.put("key92641", b92641.toString()); // put in a collection
		String c92641 = (String)map92641.get("key92641"); // get it back out
		String d92641 = c92641.substring(0,c92641.length()-1); // extract most of it
		String e92641 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92641.getBytes() ) )); // B64 encode and decode it
		String f92641 = e92641.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g92641 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g92641); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}
}
