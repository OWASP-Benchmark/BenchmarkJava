package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15351")
public class BenchmarkTest15351 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
		javax.xml.xpath.XPath xp = xpf.newXPath();
		try {
			xp.compile(bar);
		} catch (javax.xml.xpath.XPathExpressionException e) {
			// OK to swallow
			System.out.println("XPath expression exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a83198 = param; //assign
		StringBuilder b83198 = new StringBuilder(a83198);  // stick in stringbuilder
		b83198.append(" SafeStuff"); // append some safe content
		b83198.replace(b83198.length()-"Chars".length(),b83198.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83198 = new java.util.HashMap<String,Object>();
		map83198.put("key83198", b83198.toString()); // put in a collection
		String c83198 = (String)map83198.get("key83198"); // get it back out
		String d83198 = c83198.substring(0,c83198.length()-1); // extract most of it
		String e83198 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83198.getBytes() ) )); // B64 encode and decode it
		String f83198 = e83198.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g83198 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g83198); // reflection
	
		return bar;	
	}
}
