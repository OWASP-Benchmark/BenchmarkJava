package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01601")
public class BenchmarkTest01601 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a28465 = param; //assign
		StringBuilder b28465 = new StringBuilder(a28465);  // stick in stringbuilder
		b28465.append(" SafeStuff"); // append some safe content
		b28465.replace(b28465.length()-"Chars".length(),b28465.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map28465 = new java.util.HashMap<String,Object>();
		map28465.put("key28465", b28465.toString()); // put in a collection
		String c28465 = (String)map28465.get("key28465"); // get it back out
		String d28465 = c28465.substring(0,c28465.length()-1); // extract most of it
		String e28465 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d28465.getBytes() ) )); // B64 encode and decode it
		String f28465 = e28465.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g28465 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g28465); // reflection
		
		
		javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
		javax.xml.xpath.XPath xp = xpf.newXPath();
		try {
			xp.compile(bar);
		} catch (javax.xml.xpath.XPathExpressionException e) {
			// OK to swallow
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		}
	}
}
