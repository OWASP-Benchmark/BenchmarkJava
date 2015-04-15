package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17862")
public class BenchmarkTest17862 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

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
		String a83272 = param; //assign
		StringBuilder b83272 = new StringBuilder(a83272);  // stick in stringbuilder
		b83272.append(" SafeStuff"); // append some safe content
		b83272.replace(b83272.length()-"Chars".length(),b83272.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83272 = new java.util.HashMap<String,Object>();
		map83272.put("key83272", b83272.toString()); // put in a collection
		String c83272 = (String)map83272.get("key83272"); // get it back out
		String d83272 = c83272.substring(0,c83272.length()-1); // extract most of it
		String e83272 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83272.getBytes() ) )); // B64 encode and decode it
		String f83272 = e83272.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f83272); // reflection
	
		return bar;	
	}
}
