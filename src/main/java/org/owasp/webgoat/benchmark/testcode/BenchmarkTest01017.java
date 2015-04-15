package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01017")
public class BenchmarkTest01017 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a87443 = param; //assign
		StringBuilder b87443 = new StringBuilder(a87443);  // stick in stringbuilder
		b87443.append(" SafeStuff"); // append some safe content
		b87443.replace(b87443.length()-"Chars".length(),b87443.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87443 = new java.util.HashMap<String,Object>();
		map87443.put("key87443", b87443.toString()); // put in a collection
		String c87443 = (String)map87443.get("key87443"); // get it back out
		String d87443 = c87443.substring(0,c87443.length()-1); // extract most of it
		String e87443 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87443.getBytes() ) )); // B64 encode and decode it
		String f87443 = e87443.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g87443 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g87443); // reflection
		
		
		java.io.File file = new java.io.File(bar);
	}
}
