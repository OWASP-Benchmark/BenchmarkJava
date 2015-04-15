package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02930")
public class BenchmarkTest02930 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a26386 = param; //assign
		StringBuilder b26386 = new StringBuilder(a26386);  // stick in stringbuilder
		b26386.append(" SafeStuff"); // append some safe content
		b26386.replace(b26386.length()-"Chars".length(),b26386.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map26386 = new java.util.HashMap<String,Object>();
		map26386.put("key26386", b26386.toString()); // put in a collection
		String c26386 = (String)map26386.get("key26386"); // get it back out
		String d26386 = c26386.substring(0,c26386.length()-1); // extract most of it
		String e26386 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d26386.getBytes() ) )); // B64 encode and decode it
		String f26386 = e26386.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g26386 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g26386); // reflection
		
		
		java.io.File file = new java.io.File(bar);
	}
}
