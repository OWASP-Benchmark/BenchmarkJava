package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06045")
public class BenchmarkTest06045 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a41531 = param; //assign
		StringBuilder b41531 = new StringBuilder(a41531);  // stick in stringbuilder
		b41531.append(" SafeStuff"); // append some safe content
		b41531.replace(b41531.length()-"Chars".length(),b41531.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map41531 = new java.util.HashMap<String,Object>();
		map41531.put("key41531", b41531.toString()); // put in a collection
		String c41531 = (String)map41531.get("key41531"); // get it back out
		String d41531 = c41531.substring(0,c41531.length()-1); // extract most of it
		String e41531 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d41531.getBytes() ) )); // B64 encode and decode it
		String f41531 = e41531.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g41531 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g41531); // reflection
		
		
		new java.io.File(bar, "/Test.txt");
	}
}
