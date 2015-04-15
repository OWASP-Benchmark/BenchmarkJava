package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04814")
public class BenchmarkTest04814 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a91959 = param; //assign
		StringBuilder b91959 = new StringBuilder(a91959);  // stick in stringbuilder
		b91959.append(" SafeStuff"); // append some safe content
		b91959.replace(b91959.length()-"Chars".length(),b91959.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map91959 = new java.util.HashMap<String,Object>();
		map91959.put("key91959", b91959.toString()); // put in a collection
		String c91959 = (String)map91959.get("key91959"); // get it back out
		String d91959 = c91959.substring(0,c91959.length()-1); // extract most of it
		String e91959 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d91959.getBytes() ) )); // B64 encode and decode it
		String f91959 = e91959.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g91959 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g91959); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}
}
