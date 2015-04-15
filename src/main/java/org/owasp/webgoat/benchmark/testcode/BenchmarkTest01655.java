package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01655")
public class BenchmarkTest01655 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a76924 = param; //assign
		StringBuilder b76924 = new StringBuilder(a76924);  // stick in stringbuilder
		b76924.append(" SafeStuff"); // append some safe content
		b76924.replace(b76924.length()-"Chars".length(),b76924.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map76924 = new java.util.HashMap<String,Object>();
		map76924.put("key76924", b76924.toString()); // put in a collection
		String c76924 = (String)map76924.get("key76924"); // get it back out
		String d76924 = c76924.substring(0,c76924.length()-1); // extract most of it
		String e76924 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d76924.getBytes() ) )); // B64 encode and decode it
		String f76924 = e76924.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g76924 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g76924); // reflection
		
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}
}
