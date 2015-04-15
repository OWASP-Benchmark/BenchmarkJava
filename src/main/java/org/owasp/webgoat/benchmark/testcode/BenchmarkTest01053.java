package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01053")
public class BenchmarkTest01053 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a44965 = param; //assign
		StringBuilder b44965 = new StringBuilder(a44965);  // stick in stringbuilder
		b44965.append(" SafeStuff"); // append some safe content
		b44965.replace(b44965.length()-"Chars".length(),b44965.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44965 = new java.util.HashMap<String,Object>();
		map44965.put("key44965", b44965.toString()); // put in a collection
		String c44965 = (String)map44965.get("key44965"); // get it back out
		String d44965 = c44965.substring(0,c44965.length()-1); // extract most of it
		String e44965 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44965.getBytes() ) )); // B64 encode and decode it
		String f44965 = e44965.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g44965 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g44965); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}
}
