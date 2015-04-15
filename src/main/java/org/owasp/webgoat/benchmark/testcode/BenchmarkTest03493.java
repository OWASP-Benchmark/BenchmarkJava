package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03493")
public class BenchmarkTest03493 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a63217 = param; //assign
		StringBuilder b63217 = new StringBuilder(a63217);  // stick in stringbuilder
		b63217.append(" SafeStuff"); // append some safe content
		b63217.replace(b63217.length()-"Chars".length(),b63217.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map63217 = new java.util.HashMap<String,Object>();
		map63217.put("key63217", b63217.toString()); // put in a collection
		String c63217 = (String)map63217.get("key63217"); // get it back out
		String d63217 = c63217.substring(0,c63217.length()-1); // extract most of it
		String e63217 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d63217.getBytes() ) )); // B64 encode and decode it
		String f63217 = e63217.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f63217); // reflection
		
		
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
