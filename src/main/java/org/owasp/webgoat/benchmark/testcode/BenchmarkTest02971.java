package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02971")
public class BenchmarkTest02971 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a80584 = param; //assign
		StringBuilder b80584 = new StringBuilder(a80584);  // stick in stringbuilder
		b80584.append(" SafeStuff"); // append some safe content
		b80584.replace(b80584.length()-"Chars".length(),b80584.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map80584 = new java.util.HashMap<String,Object>();
		map80584.put("key80584", b80584.toString()); // put in a collection
		String c80584 = (String)map80584.get("key80584"); // get it back out
		String d80584 = c80584.substring(0,c80584.length()-1); // extract most of it
		String e80584 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d80584.getBytes() ) )); // B64 encode and decode it
		String f80584 = e80584.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g80584 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g80584); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}
}
