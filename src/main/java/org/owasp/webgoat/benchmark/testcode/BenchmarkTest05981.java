package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05981")
public class BenchmarkTest05981 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a49534 = param; //assign
		StringBuilder b49534 = new StringBuilder(a49534);  // stick in stringbuilder
		b49534.append(" SafeStuff"); // append some safe content
		b49534.replace(b49534.length()-"Chars".length(),b49534.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map49534 = new java.util.HashMap<String,Object>();
		map49534.put("key49534", b49534.toString()); // put in a collection
		String c49534 = (String)map49534.get("key49534"); // get it back out
		String d49534 = c49534.substring(0,c49534.length()-1); // extract most of it
		String e49534 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d49534.getBytes() ) )); // B64 encode and decode it
		String f49534 = e49534.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g49534 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g49534); // reflection
		
		
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
