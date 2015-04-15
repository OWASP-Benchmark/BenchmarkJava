package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15423")
public class BenchmarkTest15423 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a20776 = param; //assign
		StringBuilder b20776 = new StringBuilder(a20776);  // stick in stringbuilder
		b20776.append(" SafeStuff"); // append some safe content
		b20776.replace(b20776.length()-"Chars".length(),b20776.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map20776 = new java.util.HashMap<String,Object>();
		map20776.put("key20776", b20776.toString()); // put in a collection
		String c20776 = (String)map20776.get("key20776"); // get it back out
		String d20776 = c20776.substring(0,c20776.length()-1); // extract most of it
		String e20776 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d20776.getBytes() ) )); // B64 encode and decode it
		String f20776 = e20776.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g20776 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g20776); // reflection
	
		return bar;	
	}
}
