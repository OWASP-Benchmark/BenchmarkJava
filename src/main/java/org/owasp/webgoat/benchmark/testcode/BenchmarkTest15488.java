package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15488")
public class BenchmarkTest15488 extends HttpServlet {
	
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
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a19552 = param; //assign
		StringBuilder b19552 = new StringBuilder(a19552);  // stick in stringbuilder
		b19552.append(" SafeStuff"); // append some safe content
		b19552.replace(b19552.length()-"Chars".length(),b19552.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19552 = new java.util.HashMap<String,Object>();
		map19552.put("key19552", b19552.toString()); // put in a collection
		String c19552 = (String)map19552.get("key19552"); // get it back out
		String d19552 = c19552.substring(0,c19552.length()-1); // extract most of it
		String e19552 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19552.getBytes() ) )); // B64 encode and decode it
		String f19552 = e19552.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g19552 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g19552); // reflection
	
		return bar;	
	}
}
