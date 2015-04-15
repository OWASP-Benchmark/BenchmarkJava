package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16218")
public class BenchmarkTest16218 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		Object[] obj = { "a", "b"};
		
		response.getWriter().printf(java.util.Locale.US,bar,obj);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a52489 = param; //assign
		StringBuilder b52489 = new StringBuilder(a52489);  // stick in stringbuilder
		b52489.append(" SafeStuff"); // append some safe content
		b52489.replace(b52489.length()-"Chars".length(),b52489.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52489 = new java.util.HashMap<String,Object>();
		map52489.put("key52489", b52489.toString()); // put in a collection
		String c52489 = (String)map52489.get("key52489"); // get it back out
		String d52489 = c52489.substring(0,c52489.length()-1); // extract most of it
		String e52489 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52489.getBytes() ) )); // B64 encode and decode it
		String f52489 = e52489.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52489 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52489); // reflection
	
		return bar;	
	}
}
